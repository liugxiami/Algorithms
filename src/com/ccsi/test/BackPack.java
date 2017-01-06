package com.ccsi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by gxliu on 2017/1/4.
 */
public class BackPack {
    public static void main(String[] args) {
        int[] weights={2,3,4,5,6};
        int[] volumes={1,4,3,6,8};
        int total=12;
        bt(total,weights,volumes);
    }
    //1.recursion
    private static int max=0;
    public static int backPack(int total,int[] weights,int[] volumes){
        backPack(total,weights,volumes,0,0);
        return max;
    }

    private static void backPack(int total,int[] weights,int[] volumes,int curr,int idx){
        if(total<=0||idx>=weights.length){
            max=Math.max(max,curr);
            return;
        }

        backPack(total,weights,volumes,curr,idx+1);
        if(total-volumes[idx]>=0){
            backPack(total-volumes[idx],weights,volumes,curr+weights[idx],idx+1);
        }
    }

    //2.递推
    public static int dynamicProgramming(int total,int[] weights,int[] volumes){
        int len=weights.length;
        int[][] cache=new int[len][total+1];

//        for (int i = 0; i <= total; i++) {
//            if(i>=volumes[0])cache[0][i]=weights[0];
//        }

        int init=Math.min(total,volumes[0]);
        for (int i = init; i <= total; i++) {
            cache[0][i]=weights[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= total; j++) {
                if(j-volumes[i]>=0){
                    cache[i][j]=Math.max(cache[i-1][j],cache[i-1][j-volumes[i]]+weights[i]);
                }else{
                    cache[i][j]=cache[i-1][j];
                }
            }
        }
        return cache[len-1][total];
    }
    //3.内存优化
    public static int dynamicProgramming1(int total,int[] weights,int[] volumes){
        int len=weights.length;
        int[] pre=new int[total+1];

//        for (int i = 0; i <= total; i++) {
//            if(i>=volumes[0])pre[i]=weights[0];
//        }

        int init=Math.min(total,volumes[0]);
        for (int i = init; i <= total; i++) {
            pre[i]=weights[0];
        }

        for (int i = 1; i < len; i++) {
            int[] curr=new int[total+1];
            for (int j = 1; j <= total; j++) {
                if(j-volumes[i]>=0){
                    curr[j]=Math.max(pre[j],pre[j-volumes[i]]+weights[i]);
                }else{
                    curr[j]=pre[j];
                }
            }
            pre=curr;
        }
        return pre[total];
    }
    //4.backtracking 保存solution
    static List<Integer> solutions=new ArrayList<>();
    public static void bt(int total,int[] weights,int[] volumes){
        bt(total,weights,volumes,0,0,new Stack<Integer>());
        for(Integer i:solutions){
            System.out.println(i);
        }
        System.out.println(max);
    }
    private static void bt(int total,int[] weights,int[] volumes,int curr,int idx,Stack<Integer> currSolution){
        if(total<=0||idx>=weights.length){
            if(curr>max){
                max=curr;
                solutions.clear();
                solutions.addAll(currSolution);
            }
            return;
        }
        bt(total,weights,volumes,curr,idx+1,currSolution);
        if(total-volumes[idx]>=0){
            currSolution.push(idx);
            bt(total-volumes[idx],weights,volumes,curr+weights[idx],idx+1,currSolution);
            currSolution.pop();
        }
    }
}
