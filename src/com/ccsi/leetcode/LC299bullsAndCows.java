package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/17.
 */
public class LC299bullsAndCows {
    public static String getHint(String secret,String guess){
        if(secret==null||secret.length()==0||guess==null||guess.length()==0)return null;
        int sLen=secret.length();
        int gLen=guess.length();
        int minLen=Math.min(sLen,gLen);

        int total=0,bulls=0,cows=0;
        int[] s=new int[10];
        int[] g=new int[10];

        for (int i = 0; i < minLen; i++) {
            if(secret.charAt(i)-'0'==guess.charAt(i)-'0')bulls++;  //位置字符完全相同是bulls
        }
        for (int i = 0; i < sLen; i++) {
            s[secret.charAt(i)-'0']++;
        }
        for (int i = 0; i < gLen; i++) {
            g[guess.charAt(i)-'0']++;
        }
        for (int i = 0; i < 10; i++) {
            total+=Math.min(s[i],g[i]);                   //统计总的相同的字符数
        }

        cows=total-bulls;                                 //总字符数-bulls是
        return String.format("%dA%dB",bulls,cows);
    }

    public static void main(String[] args) {
        String secret="7108";
        String guess="7180";
        System.out.println(getHint(secret,guess));
    }
}
