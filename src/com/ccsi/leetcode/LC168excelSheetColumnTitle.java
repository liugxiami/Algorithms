package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/25.
 */
public class LC168excelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }
    public static String convertToTitle(int n){
        if(n<1)return null;
        StringBuilder builder=new StringBuilder();
        while(n!=0){
            if(n==26)n=0;
            char c=(n%26)==0?'Z':(char)('A'+(n%26)-1);
            builder.append(c);
            n/=26;
        }
        return builder.reverse().toString();
    }
}
