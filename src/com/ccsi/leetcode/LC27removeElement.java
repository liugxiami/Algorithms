package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/4.
 */
public class LC27removeElement {
    public static void main(String[] args) {
        int[] nums={3,2,1,2,3,2,4};
        System.out.println(removeElement1(nums,2));
    }

    //方法1：not stable,but keep all of the elements
    public static int removeElement(int[] nums,int val){
        if(nums==null&&nums.length==0)return -1;
        int len=nums.length;
        int idx=0;
        while(idx<len){
            while(idx<len&&nums[idx]!=val)idx++;
            if(idx==len)return len;   //因为有2种可能，需要一一判断。到头了，return len
            if(nums[idx]==val){       //否则便是相同，那么和最后一位对调，len-1；
                swap(nums,idx,len-1);
                len--;
            }
        }
        return len;
    }
    private static void swap(int[] nums,int p,int q){
        if(p==q)return;
        int temp=nums[p];
        nums[p]=nums[q];
        nums[q]=temp;
    }

    //方法2: stable
    public static int removeElement1(int[] nums,int val){
        if(nums==null||nums.length==0)return -1;
        int len=nums.length;
        int newLen=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]!=val){
                nums[newLen++]=nums[i];
            }
        }
        return newLen;
    }

}
