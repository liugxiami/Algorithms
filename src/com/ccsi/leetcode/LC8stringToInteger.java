package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/5.
 */
public class LC8stringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("    -1239999999999999999999999999999999999940"));
    }
    public static int myAtoi(String str){
        if(str==null||str.length()==0)return -1;
        long result=0; //有可能超出Integer阈值
        int flag=1;    //用来标记正负
        int idx=0;     //用来记录第一个非空格字符
        //前面是否有空格
        while(str.charAt(idx)==' '){
            idx++;
        }
        //是否为负数
        if(str.charAt(idx)=='-')flag=-1;
        for (int i = str.charAt(idx)=='-'?idx+1:idx; i < str.length(); i++) {
            Character c=str.charAt(i);
            //是否都为数字
            if(c-'0'<0||c-'0'>9)return -1;
            result=result*10+(c-'0');
            if(result>Integer.MAX_VALUE)break;
        }

        if(result>Integer.MAX_VALUE){
            return flag==-1?Integer.MIN_VALUE:Integer.MIN_VALUE;
        }else return (int)result*flag;
    }
}
