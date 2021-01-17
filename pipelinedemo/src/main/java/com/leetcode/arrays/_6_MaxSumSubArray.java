package com.leetcode.arrays;

public class _6_MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, -1, 4, -8, -3, 1};
        int result = getMaxSubArray(arr);
        System.out.println(result);
    }

    private static int getMaxSubArray(int[] arr) {
        int result = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max += arr[i];
            if(max < 0){
                max = 0;
            } else if (result < max) {
                result = max;
            }
        }
        return result;
    }
}