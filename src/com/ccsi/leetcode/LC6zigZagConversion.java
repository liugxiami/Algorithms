package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/5.
 */
public class LC6zigZagConversion {
    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        System.out.println(convert(s,4));
    }
    public static String convert(String s,int numRows){
        if(s==null||s.length()==0||numRows<=0)return "";
        int size=2*numRows-2;
        int len=s.length();
        StringBuilder builder=new StringBuilder();
        for (int nRow = 0; nRow < numRows; nRow++) {
            for (int i = nRow; i < len; i+=size) {
                builder.append(s.charAt(i));
                if(nRow!=0&&nRow!=numRows-1){
                    int temp=i+size-2*nRow;    //不是第一行或最后一行，每两size之间还有多一个数(i+size)之间
                    if(temp<len)builder.append(s.charAt(temp));
                }
            }
        }
        return builder.toString();
    }
}
