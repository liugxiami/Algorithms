package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/25.
 */
public class LC171excelSheetColumnNum {
    public static void main(String[] args) {
        System.out.println(titleToNumber("Z"));
    }
    //即26进制转换成10进制
    public static int titleToNumber(String s){
        if(s==null||s.length()==0)return -1;
        int len=s.length();
        int sum=0;
        for (int i = 0; i < len; i++) {
            sum*=26;
            sum+=s.charAt(i)-'A'+1;
        }
        return sum;
    }
}
