package challenge0.questionmarks;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 0t??m4???n6 true
 3????7???3 false
 a1?b?c?d9  true
 5???5???5 true
 3???7??? true
 5??5?5 false
 */
public class Solution
{

    /*
     * Complete the QuestionMarks function below.
     */
    static boolean QuestionMarksOld(String s) {
        if(s.length() < 5){
            return false;
        }
        boolean correct = false;
        boolean error = false;

        external: for (int i = 0; i < s.length() - 1; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                continue;
            }
            int count = 0;
            int left = Integer.parseInt(s.charAt(i) + "");

            for (int j = i + 1; j < s.length(); j++) {
                if ('?' == s.charAt(j)) {
                    count++;
                } else if (!Character.isDigit(s.charAt(j))) {
                    continue;
                } else {
                    int right = Integer.parseInt("" + s.charAt(j));
                    if ((left + right) == 10) {
                        if (count == 3) {
                            correct = true;
                        } else if (count >= 4) {
                            error = true;
                        }
                        continue external;
                    } else {
                        continue external;
                    }
                }
            }
        }

        return correct && !error;
    }

    static boolean QuestionMarks(String s) {
        if(s.length() < 5){
            return false;
        }
        boolean correct = false;
        int left = 0;

        external: while(left < s.length() - 1) {
            if(Character.isDigit(s.charAt(left))) {
                int right = left + 1;
                int count = 0;
                while(right < s.length()) {
                    if('?' == s.charAt(right)){
                        count++;
                    } else if (Character.isDigit(s.charAt(right))) {
                        int leftVal = Integer.parseInt("" + s.charAt(left));
                        int rightVal = Integer.parseInt("" + s.charAt(right));
                        if((leftVal + rightVal) == 10) {
                            if(count == 3) {
                                correct = true;
                            } else if(count > 3){
                                return false;
                            }
                        }
                        left = right;
                        continue external;
                    }
                    right++;
                }
            }
            left++;
        }

        return correct;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scan.nextLine();

        boolean result = QuestionMarks(s);

        bw.write(String.valueOf(result ? 1 : 0));
        bw.newLine();

        bw.close();
    }
}
