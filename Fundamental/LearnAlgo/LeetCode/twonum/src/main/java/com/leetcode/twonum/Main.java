package com.leetcode.twonum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] result = Main.twoNum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static  int[] twoNum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {
                    map.get(complement), i
                };
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No Match");
    }
}