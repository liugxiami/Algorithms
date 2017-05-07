package com.ccsi.leetcode;

import java.util.Stack;

/**
 * Created by gxliu on 2017/1/11.
 */
public class LC155minStack {
    //用两个栈来保存数据，一个正常栈，一个只保存比当前栈顶的小的数，
    // 当pop时，如果正常栈中pop的数与min栈顶一样，则也pop
    Stack<Integer> mStack;
    Stack<Integer> mMinStack;

    public LC155minStack(){
        mStack=new Stack<>();
        mMinStack=new Stack<>();
    }

    public void push(int x){
       if(mMinStack.isEmpty()||x<=mMinStack.peek()){  //是小于等于，预防出现重复的最小值
           mMinStack.push(x);
       }
       mStack.push(x);
    }

    public void pop(){
        int temp=mStack.pop();
        if(temp==mMinStack.peek()){
            mMinStack.pop();
        }
    }
    public int top(){
        return mStack.peek();
    }
    public int getMin(){
        return mMinStack.peek();
    }
}
