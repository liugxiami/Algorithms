package com.ccsi.test;

/**
 * Created by gxliu on 2017/1/5.
 */
public class LC70climbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs2(9));
    }
    //1.递推+缓存
    public static int climbStairs(int n){
        if(n==0)return 0;

        int[] cache=new int[n+1];
        cache[1]=1;
        if(n==1)return 1;
        cache[2]=2;
        for (int i = 3; i <=n ; i++) {
            cache[i]=cache[i-1]+cache[i-2];
        }

        return cache[n];
    }
    //2.内存优化
    public static int climbStairs1(int n){
        if(n==0)return 0;
        int first=1;
        if(n==1)return first;
        int second=2;
        for (int i = 3; i <=n; i++) {
            int curr=first+second;
            first=second;
            second=curr;
        }
        return second;
    }
    //3.递归+buffer
    public static int climbStairs2(int n){
        int[] cache=new int[n+1];
        climbStairs2(n,n,cache);
        return cache[n];
    }
    private static int climbStairs2(int n, int idx, int[] cache){
        if(idx==0)return 0;
        if(idx<=2)return idx;

        if(cache[idx]!=0)return cache[idx];
        cache[idx]=climbStairs2(n,idx-1,cache)+climbStairs2(n,idx-2,cache);
        return cache[idx];
    }
}
