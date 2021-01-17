package com.leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _7_ThirdMax {
    public static void main(String[] args) {
        int[] arr = {2,2,3,1};
        int result = thirdMax(arr);
        System.out.println(result);
    }

    public static int thirdMax(int[] nums) {
        int[] ints = Arrays.stream(nums).distinct().sorted().toArray();
//        for (int i : ints){
//            System.out.println(i);
//        }
        return ints[ints.length - 1];
    }
}
