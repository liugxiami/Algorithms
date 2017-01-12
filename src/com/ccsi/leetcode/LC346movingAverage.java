package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/1/10.
 */
public class LC346movingAverage {
    private Queue<Integer> queue;
    private int sum;
    private int maxSize;

    public LC346movingAverage(int size){
        this.maxSize=size;
        this.sum=0;
        this.queue=new LinkedList<>();
    }
    public double next(int val){
        queue.offer(val);
        sum+=val;
        if(queue.size()>maxSize){
            sum-=queue.poll();
        }
        return (double)sum/queue.size();
    }
}
