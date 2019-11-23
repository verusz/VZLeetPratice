package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int minimumSwap(String s1, String s2) {

        int steps = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                nums.add(i);
            }
        }

        if (nums.size() % 2 == 1) {
            return -1;
        } else {
            if (s1.indexOf('x') < 0  || s1.indexOf('y') < 0 ) {
                steps = nums.size() / 2;
            } else {
                steps = nums.size();
            }
        }

        return steps;
    }
}
