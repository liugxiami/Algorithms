package com.ccsi.leetcode;

import java.util.Stack;

/**
 * Created by gxliu on 2017/1/22.
 */
public class LC232implementQueueWithStack {
    Stack<Integer> data;
    Stack<Integer> helper;
    int count;
    public LC232implementQueueWithStack(){
        this.data=new Stack<>();
        this.helper=new Stack<>();
        this.count=0;
    }

    public void push(int x){
        data.push(x);
        count++;
    }

    public int pop(){
        if(empty()){
            throw new IllegalStateException("Queue is empty.");
        }else {
            while(!data.isEmpty()){
                helper.push(data.pop());
            }
            int res=helper.pop();
            while(!helper.isEmpty()){
                data.push(helper.pop());
            }
            count--;
            return res;
        }
    }

    public int peek(){
        if(empty()){
            throw new IllegalStateException("Queue is empty.");
        }else {
            while(!data.isEmpty()){
                helper.push(data.pop());
            }
            int res=helper.peek();
            while(!helper.isEmpty()){
                data.push(helper.pop());
            }
            return res;
        }
    }

    public boolean empty(){
        return this.data.isEmpty();
    }
}
