package com.ccsi.test;

/**
 * Created by gxliu on 2017/1/2.
 * greedy 贪心算法
 */
public class LC392isSubsequence {
    public static boolean isSubsequence(String s,String t){
        if(s==null||s.length()==0)return true;
        if(t==null||t.length()==0)return false;

        int tLength=t.length();
        int sLength=s.length();

        int tPointer=0,sPointer=0;

        while(tPointer<tLength){
            if(s.charAt(sPointer)==t.charAt(tPointer)){
                sPointer++;
                if(sPointer==sLength)return true;   //放在这里更合适，++完后立刻判断
            }
            tPointer++;

            //if(sPointer==sLength)return true;   //该判断只能放后面
        }
        return false;
    }

    public static void main(String[] args) {
        String s="abc";
        String t="ahabgdc";
        System.out.println(isSubsequence(s,t));
    }
}
