package challenge0.superreducedstring;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String super_reduced_string(String s){
        if(s == null || s.equals("")) {
            return "Empty String";
        } else if(s.length() == 1){
            return s;
        } else {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while(i < s.length()){
                if((i + 1) < s.length() && s.charAt(i) == s.charAt(i + 1)){
                    sb.append(s, i + 2, s.length());
                    break;
                } else {
                    sb.append(s.charAt(i));
                }
                i++;
            }
            if(sb.length() != s.length()){
                return super_reduced_string(sb.toString());
            } else {
                return s;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
