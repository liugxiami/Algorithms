package com.ccsi.sorts;

/**
 * Created by gxliu on 2016/11/8.
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] a={2,3,5,1,7,4,4,3,2,4,1};
        countingSort(a);
        for(int i:a) System.out.println(i);
    }
    public static void countingSort(int[] a){
        if(a==null||a.length==0)return;
        int max=100;
        int[] bucket=new int[max];
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        for (int i = 1; i < max ; i++) {
            bucket[i]+=bucket[i-1];          //bucket存储的是比这个数字小的数字个数
        }

        int[] aux=a.clone();
        for (int i = 0; i < aux.length; i++) {
            int val=aux[i];
            a[--bucket[val]]=val;           //不太明白，还需琢磨
        }
    }
}
