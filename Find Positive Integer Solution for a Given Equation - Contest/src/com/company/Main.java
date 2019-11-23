package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        List<List<Integer>> results = new ArrayList<>();

        int z = 0;
        List<List<Integer>> results = new LinkedList<>();
        for (int i = 1; i <= 1000; i++ ) {
            for (int j = 1; j <= 1000; j++ ) {

                if (f(i,j) == z) {

                    ArrayList<Integer> a = new ArrayList<Integer>();

                    a.add(i);
                    a.add(j);
                    results.add(a);
                }
            }
        }
    }

    public static int f(int x, int y) {
        return 1;
    }

}
