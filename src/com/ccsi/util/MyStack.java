package com.ccsi.util;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by gxliu on 2016/11/2.
 */
public class MyStack<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        MyStack<Integer> stack=new MyStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        stack.pop();
        stack.pop();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        for(Integer i:stack){
            System.out.println(i);
        }
    }

    private Item[] core;
    private int top = 0;

    public MyStack(int initSize) {
        this.core = (Item[]) new Object[initSize];  //强制转换数组，需要注意
    }
    //关键步骤，如果数组大小不够了，需要增加size*2
    public void push(Item val) {
        core[top++] = val;
        if (top == core.length) {
            reSize(core.length*2);
        }
    }
    //为了不浪费空间，如果pop了太多，需要减少size，判断是当值个数只有数组大小1/4是缩小一半
    public Item pop() {
        if (top == 0) return null;
        Item temp= core[--top];
        if(top>0&&top==core.length/4){
            reSize(core.length/2);
        }
        return temp;
    }

    public Item peek() {
        if (top == 0) return null;
        return core[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    //reSize数组，新增一个暂时数组，把原来数组的值一个一个考进去，然后将临时数组赋给原数组
    public void reSize(int max){
        Item[] temp=(Item[]) new Object[max];
        for (int i = 0; i < top; i++) {
            temp[i]=core[i];
        }
        core=temp;
    }

    @Override
    public Iterator<Item> iterator() {      //需要实现iterator，
        return new ReverseArrayIterator();  //因为这是栈，所以迭代时是从后往前（后进先出原则）
    }
    //镶嵌类，实现Iterator接口
    private class ReverseArrayIterator implements Iterator<Item>{    //定义一个镶嵌类，实现Iterator接口
        private int i=top;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return core[--i];
        }

        @Override
        public void remove() {

        }
    }
}
