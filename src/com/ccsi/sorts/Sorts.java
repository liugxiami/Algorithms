package com.ccsi.sorts;


/**
 * Created by gxliu on 2016/11/4.
 */
public class Sorts {
    //1.1 O(n*n)
    public static void selectionSort(int[] a){
        if(a==null||a.length==0)return;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
    }
    //1.2 O(n*n)
    public static void bubbleSort(int[] a){
        if(a==null||a.length==0)return;
        for (int i = a.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    //1.3 O(n*n)
    public static void insertionSort(int[] a){
        if(a==null||a.length==0)return;
        for (int i = 1; i < a.length ; i++) {
            for (int j = i; j >0 ; j--) {
                if(a[j]<a[j-1]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
        }
    }
    //1.4 shellSort 就是insertionsort的改进型
    public static void shellSort(int[] a){
        if(a==null||a.length==0)return;
        int length=a.length;
        int gap=length/2;

        while(gap>0){
            for (int i = gap; i < length; i++) {
                for (int j = i; j >0 ; j-=gap) {
                    if(j-gap>=0&&a[j-gap]>a[j])swap(a,j-gap,j);
                    else break;
                }
            }
            gap/=2;
        }
    }
    public static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    //2 mergeSort
    public static void merge(int[] a,int li,int hi){
        if(li>=hi)return;
        int[] aux=new int[hi-li+1];
        for (int i = li; i <=hi ; i++) {
            aux[i-li]=a[i];
        }

        int mi=(hi-li)/2;
        int p=0,q=mi+1;

        for (int i = li; i <= hi; i++) {
            if(p==mi+1)a[i]=aux[q++];
            else if(q==aux.length)a[i]=aux[p++];
            else if(aux[p]<aux[q])a[i]=aux[p++];
            else a[i]=aux[q++];
        }
    }

    public static void mergeSort(int[] a,int li,int hi){
        if(li>=hi) return;
        int mi=li+(hi-li)/2;
        mergeSort(a,li,mi);
        mergeSort(a,mi+1,hi);
        merge(a,li,hi);
    }
    public static void wrapper(int[] a){
        mergeSort(a,0,a.length-1);
    }
    //3 quickSort
    public static int partition(int[] a,int li,int hi){
        int pivot=a[li];
        int p=li,q=hi+1;
        while(true){
            while(++p<=hi&&a[p]<pivot);
            while(--q>li&&a[q]>pivot);
            if(p<q){
                int temp=a[p];
                a[p]=a[q];
                a[q]=temp;
            }else break;
        }
        int t=a[li];
        a[li]=a[q];
        a[q]=t;
        return q;
    }
    public static void quickSort(int[] a,int li,int hi){
        if(li>=hi)return;
        int pi=partition(a,li,hi);
        quickSort(a,li,pi);
        quickSort(a,pi+1,hi);
    }
    public static void wrapper2(int[] a){
        quickSort(a,0,a.length-1);
    }
}
