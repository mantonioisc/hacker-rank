package daysofcode.twentytwo;

import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}

/**
 * 7
 * 3
 * 5
 * 2
 * 1
 * 4
 * 6
 * 7
 */
class Solution{

    public static int getHeight(Node root){
        //Write your code here
        if(root == null) {
            return 0;
        } else if(root.left == null & root.right == null) {
            return 0;
        } else {
            int depthLeft = 1 + getHeight(root.left);
            int depthRight = 1 + getHeight(root.right);
            return Math.max(depthLeft, depthRight);
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}
