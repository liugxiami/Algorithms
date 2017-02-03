package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/2.
 */
public class LC70climbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs3(5));
    }
    //1.递推，用数组缓存
    public static int climbStairs(int n){
        if(n<=0)throw new IllegalStateException("n should be >=1");
        if(n==1)return 1;
        if(n==2)return 2;

        int[] cache=new int[n+1];
        cache[1]=1;
        cache[2]=2;

        for (int i =3; i <=n; i++) {
            cache[i]=cache[i-1]+cache[i-2];
        }
        return cache[n];
    }
    //2.递推，内存优化
    public static int climbStairs1(int n){
        if(n<=0)throw new IllegalStateException("n should be >=1");
        if(n==1)return 1;
        if(n==2)return 2;

        int p=1,q=2;
        for (int i = 3; i <= n; i++) {
            int temp=p+q;
            p=q;
            q=temp;
        }

        return q;
    }
    //3.递归,DP(可以用数组或Map)
    public static int climbStairs2(int n){
        if(n<=0)throw new IllegalStateException("n should be >=1");
        if(n==1)return 1;
        if(n==2)return 2;

        int[] cache=new int[n+1];
        helper(n,cache);
        return cache[n];
    }
    private static int helper(int n,int[] cache){
        if(n==1)return 1;
        if(n==2)return 2;

        if(cache[n]!=0)return cache[n];
        return cache[n]=helper(n-1,cache)+helper(n-2,cache);
    }
    //4.递归
    public static int climbStairs3(int n){
        if(n<=0)throw new IllegalStateException("n should be >=1");
        if(n==1)return 1;
        if(n==2)return 2;

        return climbStairs3(n-1)+climbStairs3(n-2);
    }
}
