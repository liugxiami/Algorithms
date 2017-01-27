package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/25.
 */
public class LC172factorialTrailingZeros {
    public static void main(String[] args) {
        System.out.println(trailingZeroes1(25));
    }
    public static int trailingZeroes(int n){
        if(n<5)return 0;
        int count=0;
        for (int i = 5; i <=n; i++) {
            int temp=i;
            while(temp!=0){
                if((temp%5)!=0)break;
                count++;
                temp/=5;
            }
        }
        return count;
    }
    public static int trailingZeroes1(int n){
        int count=0;
        while(n>0){
            n/=5;
            count+=n;
        }
        return count;
    }
}
