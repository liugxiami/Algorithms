package com.ccsi.sorts;

/**
 * Created by gxliu on 2016/11/13.
 */
public class HeapSort1 {
    public static void main(String[] args) {
        int[] a={2,3,5,1,7,4,4,3,2,4,1};
        heapSort(a);
        for(int i:a) System.out.println(i);
    }

    //maxHeap
    public static void heapSort(int[] nums){
        if(nums==null||nums.length<=1)return;
        int len=nums.length;
        for (int i = (len-1)/2; i >=0 ; i--) {
            max_heapify(nums,i,len-1);
        }

        for (int i = len-1; i >0 ; i--) {
            swap(nums,0,i);
            max_heapify(nums,0,i-1);
        }
    }
    public static void max_heapify(int[] nums,int start,int end){
        int parent=start;
        int son=parent*2+1;
        while(son<=end){
            if(son+1<=end&&nums[son+1]>nums[son])son++; //如果两个孩子都存在，比较两个儿子的大小，取大儿子
            if(nums[parent]>nums[son])return;           //如果父亲大，不变
            else{                                       //如果儿子大，交换一下
                swap(nums,parent,son);
                parent=son;
                son=parent*2+1;
            }
        }
    }
    public static void swap(int[] nums,int p,int q){
        if(p==q)return;
        int temp=nums[p];
        nums[p]=nums[q];
        nums[q]=temp;
    }
}
