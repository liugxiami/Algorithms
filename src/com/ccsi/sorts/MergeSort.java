package com.ccsi.sorts;

/**
 * Created by gxliu on 2016/11/6.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a={2,3,5,1,7,4};
        wrapper(a);
        for(int i:a) System.out.println(i);
    }
    public static void merge(int[] a,int li,int hi){
        if(li>=hi)return;
        int[] aux=a.clone();

        int mi=li+(hi-li)/2;
        int p=li,q=mi+1;
        for (int i = li; i <=hi; i++) {
            if(p==mi+1)a[i]=aux[q++];
            else if(q==hi+1)a[i]=aux[p++];
            else if(aux[p]<aux[q])a[i]=aux[p++];
            else a[i]=aux[q++];
        }
    }
    public static void sort(int[] a,int li,int hi){
        if(li>=hi)return;
        int mi=li+(hi-li)/2;
        sort(a,li,mi);
        sort(a,mi+1,hi);
        merge(a,li,hi);
    }
    public static void wrapper(int[] a){
        sort(a,0,a.length-1);
    }
}
