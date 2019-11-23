package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        numberOfSubarrays(new int[] {1,1,2,1,1}, 3);
    }

    public static int numberOfSubarrays(int[] nums, int k) {

        List<List<Integer>> results = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
            List<Integer> combination = new ArrayList<Integer>();
            dfs(nums, 0, results, k, combination);
//            combination.remove(0);
//        }
        return results.size();
    }

    public static void dfs(int[] nums, int startIndex, List<List<Integer>> results, int k, List<Integer> combination) {
        if (startIndex == nums.length - 1) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {

            Integer num = nums[startIndex];
            combination.add(num);
            if (num % 2 == 1) {
                k = k - 1;
            }
            if (k < 0) {
                break;
            }

            if (k == 0 && !results.contains(combination)) {
                results.add(new ArrayList<>(combination));
            }
            dfs(nums, i + 1, results, k, combination);

            if (combination.get(0) % 2 == 1) {
                k = k + 1;
            }

            combination.remove(0);
        }


    }
}
