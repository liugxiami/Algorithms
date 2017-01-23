package com.ccsi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2017/1/22.
 */
public class LC225implementStackUsingQueues {
    Queue<Integer> data;
    Queue<Integer> helper;
    int count;

    public LC225implementStackUsingQueues(){
        this.data=new LinkedList<>();
        this.helper=new LinkedList<>();
        this.count=0;
    }
    public void push(int x){
        data.offer(x);
        count++;
    }
    public int pop(){
        if(data.isEmpty()) throw new IllegalStateException("Queue is empty");
        int t=0;
        int res=0;
        while(!data.isEmpty()){
            t++;
            if(t<count)helper.offer(data.poll());
            else{
                res=data.poll();
            }
        }
        while(!helper.isEmpty()){
            data.offer(helper.poll());
        }
        count--;
        return res;
    }
    public int top(){
        if(data.isEmpty()) throw new IllegalStateException("Queue is empty");
        int t=0;
        int res=0;
        while(!data.isEmpty()){
            t++;
            if(t<count)helper.offer(data.poll());
            else{
                res=data.poll();
                helper.offer(res);
            }
        }
        while(!helper.isEmpty()){
            data.offer(helper.poll());
        }
        return res;
    }
    public boolean empty(){
        return count==0;
    }
}
