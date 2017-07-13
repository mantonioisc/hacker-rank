package javatrack.datastructures.subarray;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        s.close();

        int negative = 0;

        for (int offset = 0; offset < a.length; offset++) {
            for (int i = 0; i < a.length - offset; i++) {
                System.out.println(i + "->" + (i + offset) + "=" + sumArray(a, i, i + offset));
                if (sumArray(a, i, i + offset) < 0) {
                    negative++;
                }
            }
        }

        System.out.println(negative);
    }

    private static int sumArray(int[] a, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += a[k];
        }
        return sum;
    }
}