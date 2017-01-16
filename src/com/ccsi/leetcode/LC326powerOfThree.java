package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/15.
 * powerofNumber
 */
public class LC326powerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(-27));
    }
    public static boolean isPowerOfThree(int n){
        if(n==0)return false;
        if(n<0) n=-n;

        while(n!=0){
            if(n==1)return true;
            if((n%3)!=0)return false;
            n/=3;
        }
        return false;
    }
}
