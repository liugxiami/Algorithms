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
    //max用于记录最大值，放在外面，比用函数传递更方便一些，更容易读懂。
    private static int max=0;
    public static int backPack(int total,int[] weights,int[] volumes){
        backPack(total,weights,volumes,0,0);
        return max;
    }
    //其中total为剩余容量，curr为当天价值，idx是下标也就是层数，这三个参数都很重要
    private static void backPack(int total,int[] weights,int[] volumes,int curr,int idx){
        if(total<=0||idx>=weights.length){
            max=Math.max(max,curr);
            return;
        }
        //每下一层，有两种情况，一是右边的，就是第idx元素不放进去
        backPack(total,weights,volumes,curr,idx+1);
        //第2种情况，将第idx元素放进去，但有前提条件，就是要剩余的容积能容下这个元素。
        if(total-volumes[idx]>=0){
            backPack(total-volumes[idx],weights,volumes,curr+weights[idx],idx+1);
        }
    }

    //2.递推
    public static int dynamicProgramming(int total,int[] weights,int[] volumes){
        int len=weights.length;
        int[][] cache=new int[len][total+1]; //用矩阵将计算过的数据保存下来
        //初始状态，
//        for (int i = 0; i <= total; i++) {
//            if(i>=volumes[0])cache[0][i]=weights[0];
//        }

        int init=Math.min(total,volumes[0]);
        for (int i = init; i <= total; i++) {
            cache[0][i]=weights[0];
        }
        //实现递推方程式
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
        int[] pre=new int[total+1];   //第一个数组保存pre

//        for (int i = 0; i <= total; i++) {
//            if(i>=volumes[0])pre[i]=weights[0];
//        }

        int init=Math.min(total,volumes[0]);
        for (int i = init; i <= total; i++) {
            pre[i]=weights[0];
        }

        for (int i = 1; i < len; i++) {
            int[] curr=new int[total+1];   //第二个数组保存curr，必须写在这里，不能在外面
            for (int j = 1; j <= total; j++) {
                if(j-volumes[i]>=0){
                    curr[j]=Math.max(pre[j],pre[j-volumes[i]]+weights[i]);
                }else{
                    curr[j]=pre[j];
                }
            }
            pre=curr;                      //将curr交给pre
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
