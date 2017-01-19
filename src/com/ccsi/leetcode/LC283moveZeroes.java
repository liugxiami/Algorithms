package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/18.
 */
public class LC283moveZeroes {
    public static void main(String[] args) {
        LC283moveZeroes mz=new LC283moveZeroes();
        int[] nums={0,1,0,3,12};
        mz.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public void moveZeroes(int[] nums){
        if(nums==null||nums.length==0)return;
        int len=nums.length;
        int slow=0,fast=0;

        while(fast<len){
            if(nums[fast]!=0){
                nums[slow++]=nums[fast];
            }
            fast++;
        }

        while(slow<len){
            nums[slow++]=0;
        }
    }

}
