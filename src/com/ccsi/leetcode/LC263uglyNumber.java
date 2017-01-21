package com.ccsi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxliu on 2017/1/19.
 */
public class LC263uglyNumber {
    public static void main(String[] args) {
        System.out.println(isUglyNum(14));
    }
    public static boolean isUglyNum(int n){
        if(n==0)return false;

        int[] dividers={5,3,2};
        for(Integer i:dividers){
            while(n%i==0)n/=i;
        }
        return n==1;
    }
}
