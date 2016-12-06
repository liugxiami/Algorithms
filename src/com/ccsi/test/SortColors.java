package com.ccsi.test;

import java.util.Random;

/**
 * Created by gxliu on 2016/11/9.
 */
public class SortColors {

    public static void main(String[] args) {
        int[] a={1,1,2,0,1,2,0,1,2,0,1,1,2,2,2,0,1};
        //int[] a={1,2,0};
        //bucketSortColors(a);
        quick3way(a);
        for(int i:a){
            System.out.println(i);
        }
    }
    //O(N^2)
    public static void sortColors(int[] nums){
        if(nums==null||nums.length<=1)return;
        int pivot=1;
        int p=0,q=nums.length-1;
        for (int i = 0; i <=q; i++) {
            if(nums[i]<pivot&&i>p)swap(nums,i--,p++);
            while(nums[i]>pivot&&i<q)swap(nums,i--,q--);
        }
    }
    //quick3way
    public static void quick3way(int[] nums){
        if(nums==null||nums.length<=1)return;
        sort(nums,0,nums.length-1);
    }
    private static void sort(int[] nums,int start,int end){
        if(start>=end)return;
        int ran=new Random().nextInt(end-start)+start;
        swap(nums,start,ran);
        int pivot=nums[start];
        int lt=start,ht=end,idx=start+1;
        while(idx<=ht){
            if(nums[idx]<pivot)swap(nums,idx++,lt++);
            else if(nums[idx]>pivot)swap(nums,idx,ht--);
            else idx++;
        }
        sort(nums,start,lt-1);
        sort(nums,ht+1,end);
    }
    public static void swap(int[] a,int p,int q){
        if(p!=q) {
            int temp = a[p];
            a[p] = a[q];
            a[q] = temp;
        }
    }
    //bucketsort o[n]有点作弊的感觉，但效率非常高。三颜色有0，1，2代表，所以只要一个3个元素的数组就够了。
    public static void bucketSortColors(int[] nums){
        if(nums==null||nums.length<=1)return;

        int[] bucket=new int[3];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }

        int idx=0;
        for (int i = 0; i < bucket.length; i++) {
            int count=bucket[i];
            while(count-->0){
                nums[idx++]=i;
            }
        }
    }
}
