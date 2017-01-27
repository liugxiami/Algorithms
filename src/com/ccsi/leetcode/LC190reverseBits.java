package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/25.
 */
public class LC190reverseBits {
    public static void main(String[] args) {
        int n=43261596;
        System.out.println(reverseBits(n));
    }
    public static int reverseBits(int n){
        if(n==0)return 0;
        int result=0;
        for (int i = 0; i < 32; i++) {
            if((n&1)==1){
                result|=(1<<31-i);
            }
            n>>>=1;
        }
        return result;
    }
}
