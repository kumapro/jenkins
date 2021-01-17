package com.leetcode.arrays;

public class _8_monotonicIncreasingOrDecreasing {
    public static void main(String[] args) {
//        int[] arr = {1,2,2,3};
//        int[] arr = {1,1,0};
        int[] arr = {1,0};
        boolean result = isMonotonic(arr);
        System.out.println(result);
    }
    public static boolean isMonotonic(int[] arr){
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 0; i < arr.length -1; i++){
            if (arr[i] > arr[i + 1]){
                isIncreasing = false;
            }
            if (arr[i] < arr[i + 1]){
                isDecreasing = false;
            }
        }
        return isDecreasing || isIncreasing;
    }
}
