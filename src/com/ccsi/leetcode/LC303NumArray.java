package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/17.
 */
public class LC303NumArray {
    int[] nums;
    int[] sums;
    public LC303NumArray(int[] nums){
        if(nums==null||nums.length==0)return;
        this.nums=nums;
        this.sums=new int[nums.length];
        sums[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i]=sums[i-1]+nums[i];
        }
    }
    public int sumRange(int i,int j){
        if(nums==null||nums.length==0)return 0;
        int min=i<j?i:j;
        int max=i<j?j:i;
        return sums[max]-sums[min]+nums[min];
    }
}
