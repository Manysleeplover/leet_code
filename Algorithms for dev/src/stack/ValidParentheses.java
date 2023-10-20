package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                char topStackChar = stack.peek();
                if (topStackChar == '(' && s.charAt(i) == ')')
                    stack.pop();
                else if (topStackChar == '{' && s.charAt(i) == '}')
                    stack.pop();
                else if (topStackChar == '[' && s.charAt(i) == ']')
                    stack.pop();
                else
                    stack.push(s.charAt(i));

            }
        }
        return stack.isEmpty();
    }
}
