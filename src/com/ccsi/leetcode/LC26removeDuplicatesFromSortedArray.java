package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/4.
 */
public class LC26removeDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,2,2,3,4,5,5,6,7,7};
        System.out.println(removeDuplicates(arr));
    }
    //相当于是快慢指针，慢指针用来记录结果数组，覆盖原先的数组，快指针在前面跑，并检查
    //当前是否与其前一个数相同（用新索引来更容易理解），相同则跳过，不同则交给慢指针。
    public static int removeDuplicates(int[] nums){
        if(nums==null||nums.length==0)return -1;
        int idx=0;
        for (int i=1; i < nums.length; i++) {
            if(nums[i]==nums[idx]) continue;
            nums[++idx]=nums[i];
        }
        return idx+1;
    }
}
