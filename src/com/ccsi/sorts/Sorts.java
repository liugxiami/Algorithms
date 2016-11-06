package com.ccsi.sorts;


/**
 * Created by gxliu on 2016/11/4.
 */
public class Sorts {
    public static void main(String[] args) {
        int[] a={2,3,5,1,7,4};
        shellSort(a);
        for(int i:a) System.out.println(i);
    }
    //1.1 O(n*n)
    public static void selectionSort(int[] a){
        if(a==null||a.length==0)return;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]>a[j]){
                    swap(a,i,j);
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
                    swap(a,j,j+1);
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
                    swap(a,j,j-1);
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
}
