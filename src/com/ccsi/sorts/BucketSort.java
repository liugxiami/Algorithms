package com.ccsi.sorts;

/**
 * Created by gxliu on 2016/11/6.
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] array={3,6,4,5,2,1,8,9};
        bucketSort(array);
        for(int i:array){
            System.out.println(i);
        }
    }
    //准备n个桶，桶里装数出现的次数，注意倒出来的时候的算法
    public static void bucketSort(int[] a){
        if(a==null||a.length<=1)return;
        int max=100;
        int[] bucket=new int[max];
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        int idx=0;
        for (int i = 0; i < max; i++) {
            int count=bucket[i];
            while (count-->0){
                a[idx++]=i;
            }

            if(idx==a.length)break;
        }
    }
}
