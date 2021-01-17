package com.leetcode.arrays;

public class _4_MaxProductSubArray {
    public static void main(String[] args) {
        int arr[] = {6, -3, -10, 0, 2};
//        int arr[] = {-2, -40, 0, -2, -3};
//        int arr[] = {-2, -40, 0, -21, -30};
        int maxProd = getMaxProduct(arr);
//        int maxProd = getMaxProductEfficient(arr);
        System.out.println(maxProd);
    }

    public static int getMaxProductEfficient(int[] arr){
        int result = 1;
        int max_forward = 1;
        int max_backward = 1;
        boolean isZero=false;
        int max = 1;
        for (int i = 0; i < arr.length; i++){
            if(arr[i]==0){
                max = 1;
                isZero = true;
                continue;
            }else {
                max *= arr[i];
                if (max_forward < max){
                    max_forward = max;
                }
            }
        }

        max = 1;
        for (int i = 0; i < arr.length; i++){
            if(arr[i]==0){
                max = 1;
                isZero = true;
                continue;
            }else {
                max *= arr[i];
                if (max_backward < max){
                    max_backward = max;
                }
            }
        }

        result = Math.max(max_forward, max_backward);

        if(isZero){
            result = Math.max(result, 0);
        }


        return result;
    }

    public static int getMaxProduct(int[] arr){
        int result = 1;
        for(int j = 0; j< arr.length; j++){
            int maxProd = arr[j];
            for(int i = j +1; i < arr.length; i++){
                if(maxProd * arr[i] > result){
                    result = maxProd * arr[i];
                }else{
                    break;
                }
            }
        }
        return result;
    }
}
