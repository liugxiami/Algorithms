package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/25.
 */
public class LC189rotateArray {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        rotate(nums,4);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    //双反转，先大反转，然后0到k-1小反转，k到len-1小反转
    public static void rotate(int[] nums,int k){
        if(nums==null||nums.length==0)return;
        int len=nums.length;
        //大反转
        int p=-1,q=len;
        while(++p<--q){
            swap(nums,p,q);
        }
        //小反转1
        p=-1;
        q=k;
        while(++p<--q){
            swap(nums,p,q);
        }
        //小反转2
        p=k-1;
        q=len;
        while(++p<--q){
            swap(nums,p,q);
        }

    }
    private static void swap(int[] nums,int p,int q){
        if(p>=q)return;
        int temp=nums[p];
        nums[p]=nums[q];
        nums[q]=temp;
    }
}
