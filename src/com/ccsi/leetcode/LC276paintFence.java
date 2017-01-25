package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/24.
 */
public class LC276paintFence {
    public static void main(String[] args) {
        System.out.println(numWays(3,3));
    }
    //1.递推（不好理解）
    public static int numWays(int n,int k){
        if(n==0)return 0;
        if(n==1)return k;

        int[] cache=new int[n+1];
        cache[1]=k;
        cache[2]=k*k;
        for (int i = 3; i <=n; i++) {
            cache[i]=(cache[i-2]+cache[i-1])*(k-1);
        }
        return cache[n];
    }

    //2.递推,内存优化
    public static int numWays1(int n,int k){
        if(n==0)return 0;
        if(n==1)return k;

        //n==2的情况
        int diffColors=k*(k-1);
        int sameColors=k*1;     //注意，这里的diffColors和sameColors其实是同一fence上的ways
        //前面是连续同一颜色，那么后面一块只能不同，那么便是前面的可能性之和乘以k-1；如果前面是不同颜色，那这块板可以是相同
        for (int i = 3; i <=n ; i++) {
            int temp=diffColors;
            diffColors=(diffColors+sameColors)*(k-1);
            sameColors=temp*1;
        }
        return diffColors+sameColors;
    }
}
