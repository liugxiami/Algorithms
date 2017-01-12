package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/10.
 */
public class LC345reverseVowels {
    public static void main(String[] args) {
        String s="Hello";
        System.out.println(reverse(s));
    }
    //双指针
    public static String reverse(String word){
        if(word==null||word.length()==0)return word;

        int p=-1,q=word.length();
        int len=word.length();
        char[] chars=word.toCharArray();
        while(p++<q--){
            while(!isVowel(chars[p])&&p<len)p++;
            while(!isVowel(chars[q])&&q>=0)q--;
            if(p<q){
                swap(chars,p,q);
            }else break;
        }
        return new String(chars);
    }

    private static boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')return true;
        else if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U')return true;
        else return false;
    }

    private static void swap(char[] chars,int p,int q){
        char t=chars[p];
        chars[p]=chars[q];
        chars[q]=t;
    }
}
