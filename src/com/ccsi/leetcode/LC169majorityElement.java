package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/26.
 */
public class LC169majorityElement {
    public static void main(String[] args) {
        int[] nums={1,2,1,3,1,2,1,4,1};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums){
        int major=0,count=0;
        for (int i = 0; i < nums.length; i++) {
            if(count==0){
                major=nums[i];
                count=1;
            }else if(major==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return major;
    }
}
