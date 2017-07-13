package javatrack.advanced.visitorpattern.java7;

import java.util.ArrayList;
import java.util.*;

import java.util.Scanner;
/*
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5

24
40
15
 */
enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

//----------------------------------------------------------------------------------------------------------------------

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        //do nothing for nodes
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long result = 1;
    public int getResult() {
        return (int)result;
    }

    public void visitNode(TreeNode node) {
        recalculate(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        recalculate(leaf);
    }

    private void recalculate(Tree leaf) {
        if (Color.RED.equals(leaf.getColor())) {
            result = (result * leaf.getValue()) % 1000000007;
        }
    }
}

class FancyVisitor extends TreeVis {
    int greenLeafsSum = 0;
    int nonLeafEvenSum = 0;
    public int getResult() {
        return Math.abs(greenLeafsSum - nonLeafEvenSum);
    }

    public void visitNode(TreeNode node) {
        if(node.getDepth() == 0 || node.getDepth() % 2 == 0){
            nonLeafEvenSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (Color.GREEN.equals(leaf.getColor())) {
            greenLeafsSum += leaf.getValue();
        }
    }
}

public class Solution {
    private static int[] values;
    private static Color[] colors;
    private static Map<Integer, Set<Integer>> edges;

    public static Tree solve() {
        Scanner s = new Scanner(System.in);

        //Read data from input, a problem by itself ¬¬
        int total = s.nextInt();
        values = new int[total];
        colors = new Color[total];

        for (int i = 0; i < total; i++) {
            values[i] = s.nextInt();
        }
        for (int i = 0; i < total; i++) {
            colors[i] = Color.values()[s.nextInt()];
        }

        Tree root = null;
        if (total == 1) {
            root = new TreeLeaf(values[0], colors[0], 0);
        } else {
            edges = new HashMap<>();
            for (int i = 0; i < total - 1; i++) {
                int from = s.nextInt();
                int to = s.nextInt();

                //edges definitions are not directional
                updateEdges(from, to);
                updateEdges(to, from);
            }
            root = addChildrenWithDFS(new TreeNode(values[0], colors[0], 0), 1);
        }

        s.close();
        return root;
    }

    private static void updateEdges(int from, int to) {
        Set<Integer> neighbors = edges.get(from);
        if (neighbors == null) {
            neighbors = new HashSet<>();
            edges.put(from, neighbors);
        }
        neighbors.add(to);
    }

    private static Tree addChildrenWithDFS(TreeNode parent, int parentIndex) {
        for (Integer childIndex : edges.get(parentIndex)) {
            Set<Integer> grandChildren = edges.get(childIndex);
            if (grandChildren == null) //could be empty
                grandChildren = Collections.emptySet();

            grandChildren.remove(parentIndex);//remove opposite mapping if any to avoid loops

            int value = values[childIndex - 1];
            Color color = colors[childIndex - 1];
            int newDepth = parent.getDepth() + 1;

            if (grandChildren.isEmpty()) {//no other paths then is leaf
                parent.addChild(new TreeLeaf(value, color, newDepth));
            } else {//more children bellow, make it a TreeNode
                parent.addChild(
                        addChildrenWithDFS(new TreeNode(value, color, newDepth), childIndex)
                );
            }
        }
        return parent;
    }


    //----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
