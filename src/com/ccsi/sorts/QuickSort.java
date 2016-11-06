package com.ccsi.sorts;

/**
 * Created by gxliu on 2016/11/6.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a={2,3,5,1,7,4};
        quickSort(a,0,a.length-1);
        for(int i:a) System.out.println(i);
    }
    public static void quickSort(int[] a,int li,int hi){
        if(li>=hi)return;
        int pi=partition(a,li,hi);
        quickSort(a,li,pi);
        quickSort(a,pi+1,hi);
    }
    public static Integer partition(int[] a,int li,int hi){
        if(li>=hi)return null;
        int pivot=a[li];
        int p=li,q=hi+1;
        while(true){
            while(++p<=hi&&a[p]<pivot);
            while(--q>=li&&a[q]>pivot);
            if(p<q){
                swap(a,p,q);
            }else break;
        }
        swap(a,li,q);
        return q;
    }
    public static void swap(int[] a,int li,int hi){
        int temp=a[li];
        a[li]=a[hi];
        a[hi]=temp;
    }
}
