package com.ccsi.test;

import java.util.Random;

/**
 * Created by gxliu on 2016/11/12.
 */
public class BoysGirlsQuickSort {
    public static void main(String[] args){
        int[] boys={3,2,4,1,5};
        int[] girls={4,2,1,3,5};
        sort(boys,girls);
        for(int i:boys) System.out.println(i);

        System.out.println();

        for(int i:girls) System.out.println(i);
    }

    public static void sort(int[] boys,int[] girls){
        if(boys==null||girls==null||boys.length!=girls.length)return;
        int len=boys.length;
        innerSort(boys,girls,0,len-1);
    }
    public static void innerSort(int[] boys,int[] girls,int start,int end){
        if(start>=end)return;
        int index=partition(boys,girls,start,end);
        innerSort(boys,girls,start,index-1);
        innerSort(boys,girls,index+1,end);
    }
    public static int partition(int[] boys,int[] girls,int start,int end){
        int ran=new Random().nextInt(end-start)+start;
        swap(boys,start,ran);
        int pivot=boys[start];

        int idx=start;
        int pivotIndex=-1;
        for (int i = start; i <=end ; i++) {
            if(girls[i]<=pivot){
                swap(girls,idx++,i);
                if(girls[idx-1]==pivot)pivotIndex=idx-1;
            }
        }
        swap(girls,pivotIndex,idx-1);

        int flag=girls[idx-1];
        int idex=start+1;
        for (int i = start+1; i <=end; i++) {
            if(boys[i]<flag)swap(boys,idex++,i);
        }
        swap(boys,start,idex-1);
        return idex-1;
    }
    public static void swap(int[] a,int p,int q){
        if(p==q)return;
        int temp=a[p];
        a[p]=a[q];
        a[q]=temp;
    }
}
