package com.ccsi.sorts;

/**
 * Created by gxliu on 2016/11/8.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a={2,3,5,1,7,4,4,3,2,4,1};
        insertSort(a);
        for(int i:a) System.out.println(i);
    }

    public static void insertSort(int[] a){
        if(a==null||a.length<=1)return;
        for (int i = 1; i <a.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(a[j]<a[j-1])swap(a,j,j-1);
            }
        }
    }
    public static void swap(int[] a,int p,int q){
        int temp=a[p];
        a[p]=a[q];
        a[q]=temp;
    }
}
