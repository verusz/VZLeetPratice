package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Main in = new Main();
        in.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(nums);
        dfs(results, 0, combination, nums, 0);

        return results;
    }

//    public int[] removeDuplicates(int[] candidates) {
//        Arrays.sort(candidates);
//
//        int index = 0;
//        for (int i = 0; i < candidates.length; i++) {
//            if (candidates[i] != candidates[index]) {
//                candidates[++index] = candidates[i];
//            }
//        }
//
//        int[] nums = new int[index + 1];
//        for (int i = 0; i < index + 1; i++) {
//            nums[i] = candidates[i];
//        }
//
//        return nums;
//    }

    public void dfs(List<List<Integer>> results, int sum, List<Integer> combination, int[] nums, int startIndex) {
        if (sum == 0 && combination.size() == 3) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (combination.size() > 3) {
                break;
            }
            combination.add(nums[i]);

            dfs(results, sum + nums[i], combination, nums, i + 1);

            combination.remove(combination.size() - 1);
        }
    }
}
