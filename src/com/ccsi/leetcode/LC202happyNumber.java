package com.ccsi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gxliu on 2017/1/23.
 */
public class LC202happyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n){
        if(n==0)return false;
        Set<Integer> set=new HashSet<>();  //用来保存已经算过的数，预防死循环
        while(true){
            //先做点事，判断一下
            if(n==1)return true;
            if(!set.add(n))return false;

            //什么一个变量来传递数值，常规做法
            int next=0;
            while(n!=0){
                next+=(n%10)*(n%10);
                n/=10;
            }
            n=next;
        }
    }
}
