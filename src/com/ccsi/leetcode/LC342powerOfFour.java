package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/11.
 */
public class LC342powerOfFour {
    public static boolean isPowerOfFour(int num){
        while(num!=0){
            if(num==1)return true;
            if((num&3)==0)num>>>=2;
            else return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int num=1;
        System.out.println(isPowerOfFour(num));
    }
}
