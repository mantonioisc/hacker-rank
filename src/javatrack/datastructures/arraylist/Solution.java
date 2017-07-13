package javatrack.datastructures.arraylist;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lines = s.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            int elements = s.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j < elements; j++) {
                line.add(s.nextInt());
            }
            lists.add(line);
        }

        int queries = s.nextInt();
        for (int i = 0; i < queries; i++) {
            int list = s.nextInt() - 1;
            int element = s.nextInt() - 1;
            try {
                System.out.println(lists.get(list).get(element));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }

        }
    }
}