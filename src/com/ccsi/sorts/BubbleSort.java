package com.ccsi.sorts;

/**
 * Created by gxliu on 2016/11/8.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a={2,3,5,1,7,4,4,3,2,4,1};
        bubbleSort(a);
        for(int i:a) System.out.println(i);
    }
    public static void bubbleSort(int[] a){
        if(a==null||a.length<=1)return;
        int length=a.length;
        for (int i = length-1; i >0 ; i--) {
            boolean hasSwap=false;
            for (int j = 0; j < i; j++) {
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                    hasSwap=true;
                }
            }
            if(!hasSwap)break;   //如果数据已经排好序，就是说从头到尾（i）没有发生交换，那么后面就不用再冒泡了，提前结束，优化算法。
        }
    }
    public static void swap(int[] a,int p,int q){
        int temp=a[p];
        a[p]=a[q];
        a[q]=temp;
    }
}
