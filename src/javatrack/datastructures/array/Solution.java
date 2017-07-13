package javatrack.datastructures.array;

import java.util.*;
/*
4
5 3
0 0 0 0 0
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
3 1
0 1 0

YES
YES
NO
NO
 */
public class Solution {
    //This produces false results and shows than an imperative version is super complex for this problem
    public static boolean canWinBadImplementation(int leap, int[] game) {
        int i = 0;
        while (true) {
            if (i + leap < game.length) {
                if (game[i + leap] == 0) {
                    i = i + leap;
                } else if (i + 1 < game.length) {
                    if (game[i + 1] == 0) {
                        i++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return i + leap >= game.length - 1;
    }

    public static boolean canWin(int leap, int[] game) {
        return isSolvable(game, leap, 0);
    }

    private static boolean isSolvable(int[] array, int leap, int i) {
        boolean isSolvable;
        if (i < 0 || array[i] == 1) {
            isSolvable = false;
        } else if (i + 1 >= array.length || i + leap >= array.length) {
            isSolvable = true;
        } else {
            array[i] = 1;

            isSolvable = isSolvable(array, leap, i + leap) || isSolvable(array, leap, i + 1) || isSolvable(array, leap, i - 1);
        }
        return isSolvable;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}

