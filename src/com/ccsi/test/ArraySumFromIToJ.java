package com.ccsi.test;

/**
 * Created by gxliu on 2017/2/13.
 */
public class ArraySumFromIToJ {
    private int[] array;
    private int[] cache;
    public ArraySumFromIToJ(int[] arr){
        this.array=arr;
        cache=new int[array.length];
        cache[0]=array[0];
        for (int i = 1; i < array.length; i++) {
            cache[i]=cache[i-1]+array[i];
        }
    }
    public int sum(int i,int j){
        if(i==j)return array[i];

        if(i==0)return cache[j];
        return cache[j]-cache[i-1];
    }
}
