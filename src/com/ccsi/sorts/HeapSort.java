package com.ccsi.sorts;

/**
 * Created by gxliu on 2016/11/9.
 */
public class HeapSort {
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    public static void buildHeap(int[] b){
        a=b;
        n=a.length-1;
        for (int i = n/2; i >=0 ; i--) {
            maxHeap(a,i);
        }
    }
    public static void maxHeap(int[] a,int i){
        left=2*i;
        right=2*i+1;
        if(left<=n&&a[left]>a[i]){
            largest=left;
        }else{
            largest=i;
        }

        if(right<=n&&a[right]>a[largest]){
            largest=right;
        }

        if(largest!=i){
            swap(a,i,largest);
            maxHeap(a,largest); //???
        }
    }

    public static void swap(int[] a,int p,int q){
        int temp=a[p];
        a[p]=a[q];
        a[q]=temp;
    }

    public static void sort(int[] c){
        a=c;
        buildHeap(a);

        for (int i = n; i >0 ; i--) {
            swap(a,0,i);                //将最大值放到数组最后
            n=n-1;
            maxHeap(a,0);                //剩下的在做maxheap，循环将最大值放到后面，倒数第二，第三。。。
        }
    }

    public static void main(String[] args) {
        int[] a1={4,1,3,2,16,9,10,14,8,7};
        sort(a1);
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]+ " ");
        }
    }
}
