package com.leetcode.arrays;

import java.util.Arrays;

public class _5_IncrementArrayElementByOne {
    public static void main(String[] args) {
        int[] result  = plusOne(new int[]{9});
//        int[] result  = plusOne(new int[]{8,9,9,9});
        Arrays.stream(result).forEach(System.out::println);
    }
    public static int[] plusOne(int[] digits) {
        int carryForward =0;
        for(int i = digits.length-1; i>=0; i--){
            if(i == digits.length-1){
                carryForward = (digits[i] + 1)/10;
                digits[i] = (digits[i] + 1)%10;
                continue;
            }
            if(carryForward != 0){
                int tempCf= (digits[i] + carryForward)/10;
                digits[i] = (digits[i] + carryForward)%10;
                carryForward = tempCf;
                continue;
            }else{
                break;
            }
        }
        if(carryForward != 0){
            int[] result = new int[digits.length + 1];
            result[0] = carryForward;
            for(int i = 0; i < digits.length; i++){
                result[i +1] = digits[i];
            }
            digits = result;
        }
        return digits;
    }
}
