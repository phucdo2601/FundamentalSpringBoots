package com.leetcode.palindromenum;

public class Main {
    public static void main(String[] args) {
        int numCheck = 123;
        boolean isNumCheck = Main.isPalindrome(numCheck);
        System.out.println(isNumCheck);
    }

    public static  boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String num = x + "";
        return checkPalindrome(num);
    }

    public static boolean checkPalindrome(String num) {
        int left = 0;
        int right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}