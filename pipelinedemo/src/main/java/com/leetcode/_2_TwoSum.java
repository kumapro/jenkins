package com.leetcode;

import java.util.*;

public class _2_TwoSum {
    public static void main(String[] args) {
        int[] arr = twoSum(new int[]{10, 1,29,3}, 4);
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<>();
        int delta = 0;
        for(int i=0; i < nums.length; i++){
            delta = target-nums[i];
            if(data.containsKey(delta)){
                return new int[]{data.get(delta), i};
            }else{
                data.put(nums[i], i);
            }
        }
        return null;
    }

}

