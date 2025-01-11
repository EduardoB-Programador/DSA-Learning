package com.eduardo;

public class Searching {

    public static int linearSearch(int[] nums, int target){

        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            step++;
            if (nums[i] == target) {
                System.out.println("Amount of operations: " + step);
                return i;
            }
        }
        System.out.println("Amount of operations: " + step);
        return -1;
    }

    public static int binarySort(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int step = 0;

        while (left <= right) {
            step++;
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                System.out.println("Amount of operations: " + step);
                return mid;
            } else if (target > nums[mid])
                left = mid+1;
            else
                right = mid-1;


        }
        System.out.println("Amount of operations: " + step);
        return -1;
    }

    public static int binarySortRecursive(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = (left + right) /2;

            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                return binarySortRecursive(nums, target, mid+1, right);
            else
                return binarySortRecursive(nums, target, left, mid-1);
        }
        return -1;
    }
}
