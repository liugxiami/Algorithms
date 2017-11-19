package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/5/8.
 */
public class LC69Sqrt {
    public static void main(String[] args) {
        int[] array={9,20,25,37,66,99,100};
        for (int i = 0; i < array.length; i++) {
            //System.out.println(String.format("Sqrt(%d):%d",array[i],sqrt(array[i])));
            System.out.println(String.format("Sqrt(%d):%.2f",array[i],sqrt1(array[i])));
        }
        System.out.println("========");
        for (int i = 0; i < array.length; i++) {
            System.out.println(String.format("Sqrt(%d):%d",array[i],newTon(array[i],0.0001)));
        }
    }
    public static int sqrt(int x){
        if(x<0)throw new IllegalStateException("Input should be positive integers");
        int start=1;
        int end=x/2+1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int temp=mid*mid;
            if(temp==x)return mid;
            else if(temp<x){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return end;   //loop完都没找到，那么返回平方正好大于x的那个数，这个函数里就是end。
    }
    public static double sqrt1(int a){
        if(a<0)throw new IllegalStateException("Input should be positive numbers");
        long x=a*10000;
        long start=1;
        long end=x/2+1;
        while(start<=end){
            long mid=start+(end-start)/2;
            long temp=mid*mid;
            if(temp==x){
                return 1.0*mid/100;
            }else if(temp<x){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return 1.0*end/100;
    }
    //x为输入数字，e为精度
    public static double sqrtNewton(double x,double e){
        double guess=x/2;
        double e0;
        do{
            guess=(guess+x/guess)/2;
            e0=guess*guess-x;
        }while(e0>e);

        return guess;
    }

    public static int newTon(double x,double e){
        double guess=1.0;
        double temp=1.0;
        while(true){
            temp=guess;
            guess=(guess+x/guess)/2;
            if(Math.abs(temp-guess)<e)break;
        }
        return (int)guess;
    }
}
