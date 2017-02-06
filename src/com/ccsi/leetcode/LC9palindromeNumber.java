package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/5.
 */
public class LC9palindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1234321));
    }
    public static boolean isPalindrome(int x){
        if(x<0)x=-x;
        if(x<10)return true;
        int temp=x;
        int reverse=0;
        while(temp!=0){
            reverse*=10;
            reverse+=(temp%10);
            temp/=10;
        }

        return reverse==x;
    }
}
