package com.leetcode;

public class _3_ReverseIntegersDigit {
    public static void main(String[] args) {
//        int reversedInt = reverse(12340);
        long l = 10;
        int reversedInt = reverse(1534236469);
        System.out.println(reversedInt);
    }
    public static int reverse(int x) {
        int reverseInt = 0;
        int remainder = 0;
        while(x != 0){
            remainder = x % 10;
            if((10l * reverseInt + remainder) > Integer.MAX_VALUE || (10l * reverseInt + remainder) < Integer.MIN_VALUE){
                return 0;
            }
            reverseInt = 10 * reverseInt + remainder;
            x /= 10;
        }
        return reverseInt;
    }
}