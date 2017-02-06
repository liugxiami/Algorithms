package com.ccsi.leetcode;

import java.util.*;
/**
 * Created by gxliu on 2017/2/5.
 */
public class LC13romanToInteger {
    public static void main(String[] args) {
        String s="MMMCDLXXX";
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s){
        if(s==null||s.length()==0)return -1;
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result=map.get(s.charAt(0));
        //从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数
        for (int i = 1; i < s.length(); i++) {
            int curr=map.get(s.charAt(i));
            int pre=map.get(s.charAt(i-1));

            if(curr<=pre)result+=curr;
            else result=result-2*pre+curr;
        }
        return result;
    }
}
