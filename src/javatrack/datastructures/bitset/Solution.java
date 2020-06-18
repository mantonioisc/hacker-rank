package javatrack.datastructures.bitset;

import java.io.*;
import java.util.*;

/**
 * 5 4
 * AND 1 2
 * SET 1 4
 * FLIP 2 2
 * OR 2 1
 */
public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int operations = s.nextInt();

        Map<Integer, BitSet> m = new HashMap<>();
        m.put(1, new BitSet(size));
        m.put(2, new BitSet(size));

        for (int i = 0; i < operations; i++) {
            String operation = s.next();
            int param1 = s.nextInt();
            int param2 = s.nextInt();
            switch (operation) {
                case "AND":
                    m.get(param1).and(m.get(param2));
                    break;
                case "OR":
                    m.get(param1).or(m.get(param2));
                    break;
                case "XOR":
                    m.get(param1).xor(m.get(param2));
                    break;
                case "FLIP":
                    m.get(param1).flip(param2);
                    break;
                case "SET":
                    m.get(param1).set(param2);
                    break;
            }
            System.out.println(m.get(1).cardinality() + " " + m.get(2).cardinality());
        }


        s.close();
    }
}
