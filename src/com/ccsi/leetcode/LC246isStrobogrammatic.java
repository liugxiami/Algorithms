package com.ccsi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gxliu on 2017/1/18.
 */
public class LC246isStrobogrammatic {
    public static void main(String[] args) {
        LC246isStrobogrammatic is=new LC246isStrobogrammatic();
        String str="81186";
        System.out.println(isStrobogrammatic(str));
    }
    public static boolean isStrobogrammatic(String num){
        if(num==null||num.length()==0)return false;
        int len=num.length();
        Map<Character,Character> map=new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('9','6');
        map.put('8','8');

        int p=-1,q=len;
        while(++p<=--q){
            char c=num.charAt(p);
            if(!map.containsKey(c)||map.get(c)!=num.charAt(q))return false;
        }
        return true;
    }
}
