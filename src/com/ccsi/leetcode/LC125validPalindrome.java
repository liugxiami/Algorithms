package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/29.
 */
public class LC125validPalindrome {
    public static void main(String[] args) {
        String s="race a car";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s){
        if(s==null||s.length()==0)return true;
        int len=s.length();
        s=s.toLowerCase();
        int p=-1,q=len;
        while(++p<--q){
            while(!Character.isLetterOrDigit(s.charAt(p)))p++;
            while(!Character.isLetterOrDigit(s.charAt(q)))q--;
            if(p<q&&s.charAt(p)!=s.charAt(q))return false;
        }
        return true;
    }
}
