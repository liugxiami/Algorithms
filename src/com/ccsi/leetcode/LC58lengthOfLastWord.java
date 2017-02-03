package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/2.
 */
public class LC58lengthOfLastWord {
    public static void main(String[] args) {
        String s="Hello World   ";
        System.out.println(lengthOfLastWord(s));
    }
    //note，1，从后往前探测，2. 注意末尾可能有空格
    public static int lengthOfLastWord(String s){
        if(s==null||s.length()==0)return 0;
        int len=s.length();
        int idx=len-1;
        while(idx>=0&&s.charAt(idx)==' ')idx--;

        int counter=0;
        while(idx>=0&&Character.isLetter(s.charAt(idx))){
            idx--;
            counter++;
        }
        return counter;
    }
}
