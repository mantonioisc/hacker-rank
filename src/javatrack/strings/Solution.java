package javatrack.strings;

import java.io.*;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/*
anagram
margana

abcde
xyzwf
 */
public class Solution {
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            String aLower = a.toLowerCase();
            String bLower = b.toLowerCase();
            Map<Character, Integer> occurrences = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                updateCount(occurrences, aLower.charAt(i), 1);
                updateCount(occurrences, bLower.charAt(i), -1);
            }
            return occurrences.isEmpty();
        }
    }

    static void updateCount(Map<Character, Integer> map, char c, int increment) {
        map.put(c, map.getOrDefault(c, 0) + increment);
        map.remove(c, 0);
    }

    static boolean isAnagram2(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            String aLower = a.toLowerCase();
            String bLower = b.toLowerCase();
            Map<Character, Integer> occurrences = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                occurrences.merge(aLower.charAt(i), 1, Math::addExact);
                occurrences.merge(bLower.charAt(i), -1, Math::addExact);
            }
            return occurrences.entrySet().stream().allMatch(entry -> entry.getValue() == 0);
        }
    }

    static boolean isAnagram3(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            Map<Character, Integer> occurrences = new HashMap<>();
            BiFunction<Character, Integer, Integer> merge = (c, i) -> occurrences.merge(Character.toUpperCase(c), i, Math::addExact);
            IntStream.range(0, a.length()).forEach(i -> {
                merge.apply(a.charAt(i), 1);
                merge.apply(b.charAt(i), -1);
            });
            return occurrences.entrySet().stream().allMatch(entry -> entry.getValue() == 0);
        }
    }

    static boolean isAnagram4(String a, String b) {
        if (a.length() != b.length() || a.length() <= 1) {
            return false;
        }

        int[] freq = new int['z' - 'a' + 1];
        for (int i = 0; i < a.length(); i++) {
            int iA = Character.toLowerCase(a.charAt(i)) - 'a';
            int iB = Character.toLowerCase(b.charAt(i)) - 'a';
            freq[iA]++;
            freq[iB]--;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram4(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}


