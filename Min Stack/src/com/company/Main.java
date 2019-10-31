package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class MinStack {


        Stack<Integer> orginalStack = new Stack<>();
        Stack<Integer> sortedStack = new Stack<>();
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            orginalStack.push(x);
            if (sortedStack.isEmpty()) {
                sortedStack.push(x);
            } else if (sortedStack.peek() >= x) {
                sortedStack.push(x);
            }
        }

        public void pop() {
            if (sortedStack.peek().equals(orginalStack.pop())) {
                sortedStack.pop();
            }

        }

        public int top() {

            return orginalStack.peek();
        }

        public int getMin() {

            return sortedStack.peek();
        }
    }
}
