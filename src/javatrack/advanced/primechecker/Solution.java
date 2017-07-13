package javatrack.advanced.primechecker;
/*
2
1
3
4
5

2
2
2 3
2 3 5
*/

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

//----------------------------------------------------------------------------------------------------------------------
import static java.lang.System.in;

class Prime {
    public void checkPrime(int... numbers) {
        StringBuilder sb = new StringBuilder();

        for (int n : numbers) {
            if (isPrime(n))
                sb.append(n).append(" ");
        }
        if (sb.length() != 0)
            sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        } else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

//----------------------------------------------------------------------------------------------------------------------

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
