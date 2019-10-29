package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        isValid("(])");
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                  return false;
                }
                Character temp = stack.pop();
                if (c == '}' && temp != '{') {
                    return false;
                }
                if (c == ']' && temp != '[') {
                    return false;
                }
                if (c == ')' && temp != '(') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
