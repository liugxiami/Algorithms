package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/17.
 */
public class LC292nimGame {
    public static void main(String[] args) {
        System.out.println(canWin(7));
    }
    //1.递推，数组
    public static boolean canWin1(int n){
        if(n==0)return false;
        boolean[] cache=new boolean[n+1];
        cache[1]=true;
        if(n==1)return cache[1];
        cache[2]=true;
        if(n==2)return cache[2];
        cache[3]=true;
        if(n==3)return cache[3];
        for (int i = 4; i <=n; i++) {
            if(cache[i-1]==true&&cache[i-2]==true&&cache[i-3]==true){
                cache[i]=false;
            }
        }
        return cache[n];
    }
    //2.递推，内存优化
    public static boolean canWin2(int n){
        if(n==0)return false;
        if(n<=3)return true;
        boolean first=true;
        boolean second=true;
        boolean third=true;

        for (int i = 4; i <=n; i++) {
            boolean curr=true;
            if(first==true&&second==true&&third==true){
                curr=false;
            }
            first=second;
            second=third;
            third=curr;
        }
        return third;
    }
    //3 数学
    public  static boolean canWin(int n){
        return n%4!=0;
    }
}
