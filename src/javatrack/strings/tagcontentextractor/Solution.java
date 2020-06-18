package javatrack.strings.tagcontentextractor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>
 */
public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            int contentInTheSameLineCount = 0;
            Pattern r = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
            Matcher m = r.matcher(line);
            while (m.find()) {
                if (m.group(2).length() != 0) {
                    System.out.println(m.group(2));
                    contentInTheSameLineCount++;
                }
            }
            if (contentInTheSameLineCount == 0) {
                System.out.println("None");
            }

            testCases--;
        }
    }
}




