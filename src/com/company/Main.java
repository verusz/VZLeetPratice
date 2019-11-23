package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
       System.out.println(thirdMax(new int[]{2,2, 3, 1}));
    }

    public static int thirdMax(int[] nums) {
        //Quick select

        int k = 3;
        if (k > nums.length) {
            k = nums.length;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public static int quickSelect(int[] nums, int l, int r, int k) {


        int index = partition(nums, l, r);

        if (index - l == k - 1) {
            return nums[index];
        }
        // return kthSmallest(arr, pos+1, r, k-pos+l-1);

        if (index < k - 1) {
            return quickSelect(nums, index + 1, r, k - index + l - 1);
        }
        if (index - l > k - 1) {
            return quickSelect(nums, l, index - 1, k);
        }

        return -1;
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[r], j = l;
        for (int i = l; i <= r - 1; i++) {
            if (nums[i] >= pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        int temp = nums[j];
        nums[j] = pivot;
        nums[r] = temp;
        return j;
    }
}
