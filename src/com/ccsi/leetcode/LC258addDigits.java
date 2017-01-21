package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/20.
 */
public class LC258addDigits {
    public static void main(String[] args) {
        System.out.println(addDigits1(99));
        System.out.println(addDigits2(99));
    }
    public static int addDigits1(int num){
        return (num-1)%9+1;
    }

    public static int addDigits2(int num){
        if(num<9)return num;
        while(num>10){
            int next=0;   //两个while之间申明一个变量用于传递，同利用bfs来记录每层的元素（queue）。
            while(num!=0){
                next+=num%10;
                num/=10;
            }
            num=next;
        }
        return num;
    }
}
