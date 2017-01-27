package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/25.
 */
public class LC191numberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(64));
    }
    public static int hammingWeight(int n){
        if(n==0)return 0;
        int count=0;
        for (int i = 0; i < 32 && n != 0; i++) {
            if((n&1)==1)count++;
            n>>>=1;
        }
        return count;
    }
}
