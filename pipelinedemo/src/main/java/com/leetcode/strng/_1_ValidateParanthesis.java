package com.leetcode.strng;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _1_ValidateParanthesis {
    private static Map<Character, Character> mappings = new HashMap<>();

    public static void main(String[] args) {
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
//        System.out.println(isValid("()"));
        System.out.println(isValidEfficient("()"));
    }
    public static boolean isValidEfficient(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
                continue;
            }
            if(!st.isEmpty() && ((ch == ')' && st.peek() == '(') || (ch == '}' && st.peek() == '{') || (ch == ']' && st.peek() == '['))){
                st.pop();
            }else {
                return false;
            }
        }
        if(st.isEmpty()){
            return true;
        }else {
            return false;
        }

    }
}
