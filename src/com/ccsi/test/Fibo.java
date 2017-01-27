package com.ccsi.test;

/**
 * Created by gxliu on 2017/1/24.
 */
public class Fibo {
    public static void main(String[] args) {
        System.out.println(fibo1(9));
    }
    public static int fibo1(int n){

        if(n<=2)return n;
        return fibo1(n-1)+fibo1(n-2);
    }

    public static int fibo2(int n){
        if(n<=2)return n;
        int a=1,b=2;
        for (int i = 3; i <=n ; i++) {
           int t=a+b;
           a=b;
           b=t;
        }
        return b;
    }

    public static int fibo3(int n){

        if(n<=2)return n;
        int[] cache=new int[n+1];

        cache[1]=1;
        cache[2]=2;
        for (int i = 3; i <=n ; i++) {
            cache[i]=cache[i-1]+cache[i-2];
        }
        return cache[n];
    }

    public static int fibo4(int n){
        if(n<=2)return n;
        int[] cache=new int[n+1];
        return helper(n,cache);
    }
    private static int helper(int n,int[] cache){

        if(n<=2)return n;

        if(cache[n]!=0)return cache[n];
        cache[n]=helper(n-1,cache)+helper(n-2,cache);
        return cache[n];
    }
}
