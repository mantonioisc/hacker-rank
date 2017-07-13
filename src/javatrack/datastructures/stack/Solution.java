package javatrack.datastructures.stack;

import java.util.*;

/*
({}[])
(({()})))
({(){}()})()({(){}()})(){()}
{}()))(()()({}}{}
}}}}
))))
{{{
(((
[]{}(){()}((())){{{}}}{()()}{{}{}}
[[]][][]
}{


true
false
true
false
false
false
false
false
true
true
false
 */

class Solution {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isBalanced(input));
        }
        sc.close();
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('{', '}');
        pairs.put('(', ')');
        pairs.put('[', ']');

        Set<Character> invalid = new HashSet<>();
        invalid.add('}');
        invalid.add(')');
        invalid.add(']');


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                stack.push(c);
            } else if (!stack.empty() && pairs.getOrDefault(stack.peek(), '\u0000') == c) {
                //default is never going to be 0, this replaces null check and then value check
                stack.pop();
            } else if (invalid.contains(c)) {
                //just add some un-removable value to stack so stack.empty() is false in this case, instead of using a boolean flag
                stack.push(c);
            }
        }

        return stack.empty();
    }
}
