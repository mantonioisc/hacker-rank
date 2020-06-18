package javatrack.datastructures.arraylist;

import java.util.*;

/**
 * 5
 * 5 41 77 74 22 44
 * 1 12
 * 4 37 34 36 52
 * 0
 * 3 20 22 33
 * 5
 * 1 3
 * 3 4
 * 3 1
 * 4 3
 * 5 5
 *
 * ----------------
 *
 * 8
 * 7 43 35 26 34 78 99 70
 * 3 71 11 16
 * 8 70 19 42 30 84 20 57 45
 * 0
 * 1 20
 * 0
 * 0
 * 0
 * 10
 * 5 1
 * 5 7
 * 1 7
 * 5 3
 * 5 2
 * 4 7
 * 5 2
 * 1 2
 * 4 1
 * 2 3
 */
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