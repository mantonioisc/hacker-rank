package datastructures.array.twodimensions;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i< 4; i++){
            for(int j = 0; j <4; j++){
                int sum = sumHourGlass(arr, i, j);
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }
    static int sumHourGlass(int[][]a, int i, int j){
        return (a[i][j] + a[i][j+1] + a[i][j+2]) + a[i+1][j+1] + (a[i+2][j] + a[i+2][j+1] + a[i+2][j+2]);
    }
}
