package com.ccsi.leetcode;

import java.util.Stack;

/**
 * Created by gxliu on 2017/1/29.
 */
public class LC155minStack1 {

    Stack<Integer> data;
    Stack<Integer> min;

    public LC155minStack1(){
        this.data=new Stack<>();
        this.min=new Stack<>();
    }
    public void push(int x){
        data.push(x);
        if(min.isEmpty()){
            min.push(x);
        }else{
            if(x<=min.peek())min.push(x);
        }
    }

    public void pop(){
        if(data.isEmpty())throw new IllegalStateException("Stack is empty!");
        int temp=data.pop();
        if(temp==min.peek()){
            min.pop();
        }
    }
    public int top(){
        return data.peek();
    }
    public int getMin(){
        return min.peek();
    }
}
