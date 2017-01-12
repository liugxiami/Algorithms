package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/10.
 */
//双指针
public class LC344reverseString {
    public static String reverseString(String s){
        if(s==null||s.length()<=1)return s;
        char[] chars=s.toCharArray();
        int p=-1,q=s.length();
        while(p++<q--){
            swap(chars,p,q);
        }
        return new String(chars);
    }
    private static void swap(char[] chars,int p,int q){
        char t=chars[p];
        chars[p]=chars[q];
        chars[q]=t;
    }

    public static void main(String[] args) {
        String s="Hello";
        System.out.println(reverseString(s));
    }
}
