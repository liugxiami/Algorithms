package com.ccsi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gxliu on 2017/1/19.
 */
public class LC266permutePalindrome {
    public static void main(String[] args) {
        String s="abbacd";
        System.out.println(canPermutePalindrome(s));
    }
    public static boolean canPermutePalindrome(String s){
        if(s==null||s.length()==0)return false;
        int len=s.length();
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < len; i++) {
            if(!set.add(s.charAt(i)))set.remove(s.charAt(i));
        }
        return set.size()<=1;
    }
}
