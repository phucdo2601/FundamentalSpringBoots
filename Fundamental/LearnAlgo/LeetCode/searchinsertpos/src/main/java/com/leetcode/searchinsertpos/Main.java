package com.leetcode.searchinsertpos;

public class Main {

    public static void main(String[] args) {
        int nums[] = {1,3,5,6};
        int target = 5;
        int searchInsertPos = Main.searchInsertPos(nums, target);
        System.out.println("Searched insert num: "+searchInsertPos);
    }

    public static int searchInsertPos(int nums[], int target) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
