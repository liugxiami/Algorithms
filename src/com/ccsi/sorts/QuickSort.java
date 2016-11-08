package com.ccsi.sorts;

import java.util.Random;

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
        //int pi=partition(a,li,hi);
        int pi=partitionRandom(a,li,hi);
        quickSort(a,li,pi-1);
        quickSort(a,pi+1,hi);
    }
    //method 1 前后指针
    public static Integer partition(int[] a,int li,int hi){
        if(li>=hi)return null; //此步不需要了，前面已经做过判断
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
    //method 2 快慢指针，random Pivot的方法
    public static Integer partitionRandom(int[] a,int li,int hi){
        int ran=new Random().nextInt(hi-li)+li;
        swap(a,li,ran);

        int pivot=a[li];
        int idx=li+1;
        for (int i = li+1; i <=hi ; i++) {
            if(a[i]<pivot)swap(a,idx++,i);
        }
        swap(a,li,idx-1);
        return idx-1;
    }
    public static void swap(int[] a,int li,int hi){
        int temp=a[li];
        a[li]=a[hi];
        a[hi]=temp;
    }
}
