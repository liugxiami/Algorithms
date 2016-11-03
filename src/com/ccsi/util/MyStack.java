package com.ccsi.util;

import java.util.Arrays;

/**
 * Created by gxliu on 2016/11/2.
 */
public class MyStack {
    Integer[] core = new Integer[10];
    int top = 0;

    public void push(int val) {
        core[top] = val;
        top++;
        if (top == core.length) {
            core = Arrays.copyOf(core, core.length + core.length / 10);
        }
    }

    public Integer pop() {
        if (top == 0) return null;
        top--;
        return core[top];
    }

    public Integer peek() {
        if (top == 0) return null;
        return core[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
