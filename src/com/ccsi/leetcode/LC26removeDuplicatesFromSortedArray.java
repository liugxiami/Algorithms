package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/4.
 */
public class LC26removeDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,4,5,5,6,7,7};
        System.out.println(removeDuplicates(arr));
    }
    public static int removeDuplicates(int[] nums){
        if(nums==null||nums.length==0)return -1;
        int idx=1;
        for (int i=1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1])nums[idx++]=nums[i];
        }
        return idx;
    }
}
