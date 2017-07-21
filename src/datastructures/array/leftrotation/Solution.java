package datastructures.array.leftrotation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
5 4
1 2 3 4 5

5 1 2 3 4


9 3
1 2 3 4 5 6 7 8 9
 */
public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int d = s.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        a = justOnePass(n, d, a);

        System.out.println(Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(" ")));

        s.close();
    }

    /**
     * In place, not time efficient, n*d complexity
     */
    private static int[] stepByStep(int n, int d, int[] a) {
        while (d-- > 0) {
            int aux = a[0];
            for (int i = 0; i < n - 1; i++) {
                a[i] = a[i + 1];
            }
            a[n - 1] = aux;
        }
        return a;
    }

    //1 2 3 4 5 6 7 8 9 - 1 2 3 -0 1 2
    //4 5 6 7 8 9                6 7 8

    //1 2 3 4 5 - 1 2 3 4 - 0 1 2 3
    //5                   - 1 2 3 4

    /**
     * In place, just 1 iteration, linear time
     * Using aux array of size d, but (d < n) always, this means less space than with array copy
     */
    private static int[] justOnePass(int n, int d, int[] a) {
        int[] aux = new int[d];
        for (int i = 0; i < n; i++) {
            if (i < d) {
                aux[i] = a[i];//move first d elements to aux array
            }

            if (i < n - d) {
                a[i] = a[i + d];//at the beginning just switch
            } else {//at the end a[n - d] must match aux[0] and so on a[n - d + 1]=aux[1] until a[n-1]=aux[d-1]
                a[i] = aux[i - (n - d)];
            }
        }
        return a;
    }

    /**
     * Not in place, additional array of size n. I assume linear time.
     * Feels cheap for a problem called "left rotation"
     */
    private static int[] withArrayCopy(int n, int d, int[] a) {
        int[] aux = new int[n];

        System.arraycopy(a, d, aux, 0, n - d);
        System.arraycopy(a, 0, aux, n - d, d);

        return aux;
    }
}