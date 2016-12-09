package com.ccsi.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gxliu on 2016/12/7.
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    //Hash table
    public static boolean isHappy(int num){
        Set<Integer> set=new HashSet<>();
        while(true){
            int sum=0;
            while(num>0){
                int t=num%10;
                sum+=t*t;
                num/=10;
            }
            if(sum==1)return true;
            else{
                if(set.contains(sum))return false;
                else{
                    set.add(sum);
                }
            }
            num=sum;
        }
    }
}
