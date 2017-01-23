package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/22.
 */
public class LC231powerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo3(16));
    }
    public static boolean isPowerOfTwo(int n){
        if(n==0)return false;
        if(n<0)n=-n;
        while(n!=0){
            if(n==1)return true;
            if(n%2!=0)return false;
            n/=2;
        }
        return false;
    }

    public static boolean isPowerOfTwo1(int n){
        if(n==0)return false;
        if(n<0)n=-n;
        while(n!=0){
            if(n==1)return true;
            if((n&1)==1)return false;
            n>>>=1;
        }
        return false;
    }
    public static boolean isPowerOfTwo2(int n){
        if(n==0)return false;
        if(n<0)n=-n;
        int count=0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n>>>=1;
        }
        return count==1;
    }
    public static boolean isPowerOfTwo3(int n){
        return (n&(n-1))==0;
    }
}
