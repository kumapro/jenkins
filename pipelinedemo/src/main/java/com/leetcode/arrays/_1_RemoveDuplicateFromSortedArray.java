package com.leetcode.arrays;

import java.util.Arrays;

public class _1_RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2};
//        int[] arr = new int[]{0,0,1,1,1,1,1,1,2,2,2,2,2,3,3,4};
//        int newLength =  removeDuplicates(arr);
        int newLength =  removeDuplicates1(arr);
        Arrays.stream(arr).forEach(value -> System.out.print(value + ", "));
        System.out.println("\n Number of unique elements are: " + newLength);
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length <=1){
            return nums.length;
        }
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j++] = nums[i];
            }
        }
        nums[j++] = nums[nums.length-1];
        return j;
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <=0){
            return 0;
        }
        for (int i=0; i < nums.length; i++){
            int j = i;
            int count = 0;
            while(j < nums.length-1 && nums[j] == nums[j+1] ){
               count++;
               j++;
            }
            int k = i;
            while (count > 0 && k < nums.length - (i + count)){
                nums[k] = nums[k + count];
                k++;
            }
            while (count > 0 && k < nums.length){
                nums[k] = 0;
                k++;
            }
        }
        int len = 0;
        while (len < nums.length -1 && nums[len] < nums[len + 1]){
            len++;
        }
        return ++len;
    }
}
