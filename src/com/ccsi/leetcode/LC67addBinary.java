package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/2.
 */
public class LC67addBinary {
    public static void main(String[] args) {
        String a="10111";
        String b="11";
        System.out.println(addBinary(a,b));
    }
    //在加法之前format一下两String对后面的计算很有帮助
    public static String addBinary(String a,String b){
        if(a==null&&b==null)return null;
        if(a==null||b==null)return a==null?b:a;
        int aLen=a.length();
        int bLen=b.length();

        int len=Math.max(aLen,bLen);
        a=formatNum(a,len);
        b=formatNum(b,len);

        int flag=0;
        StringBuilder builder=new StringBuilder();
        for (int i = len-1; i >= 0; i--) {
            char ac=a.charAt(i);
            char bc=b.charAt(i);
            int temp=flag+(ac-'0')+(bc-'0');
            flag=temp/2;
            builder.append(temp%2);
        }
        if(flag==1)builder.append(1);
        return builder.reverse().toString();
    }

    private static String formatNum(String str,int len){
        int delta=len-str.length();
        StringBuilder builder=new StringBuilder();
        while(delta-->0){
            builder.append(0);
        }
        builder.append(str);
        return builder.toString();
    }

}
