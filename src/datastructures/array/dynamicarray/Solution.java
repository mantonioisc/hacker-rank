package datastructures.array.dynamicarray;

import java.util.ArrayList;
import java.util.Scanner;

/*
2 5
1 0 5
1 1 7
1 0 3
2 1 0
2 1 1

7
3
 */
public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lastAnswer = 0;

        int n = s.nextInt();
        int queries = s.nextInt();
        ArrayList<ArrayList<Integer>> seqList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            seqList.add(i, new ArrayList<>());
        }

        while (queries-- > 0) {
            int query = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();

            int i = (x ^ lastAnswer) % n;

            switch (query) {
                case 1:
                    seqList.get(i).add(y);
                    break;
                case 2:
                    ArrayList<Integer> seq = seqList.get(i);
                    lastAnswer = seq.get(y % seq.size());
                    System.out.println(lastAnswer);
                    break;
            }
        }

        s.close();
    }
}