package com.ccsi.leetcode;

import com.ccsi.util.HashMap;

import java.util.*;

/**
 * Created by gxliu on 2017/1/15.
 */
public class LC325maxSubArrayLen {
    public static void main(String[] args) {
        int[] nums={1,-1,4,5};
        System.out.println(maxSubArrayLen(nums,9));
    }
    public static int maxSubArrayLen(int[] nums,int k){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        for (int i = 1; i < len; i++) {
            nums[i]+=nums[i-1];
        }
        Map<Integer,Integer> lookup=new java.util.HashMap<>();

        lookup.put(0,-1);
        int maxLen=0;
        for (int i = 0; i < len; i++) {
            if(!lookup.containsKey(nums[i])){
                lookup.put(nums[i],i);
            }

            int diff=nums[i]-k;
            if(lookup.containsKey(diff)){
                maxLen=Math.max(maxLen,i-lookup.get(diff));
            }

        }
        return maxLen;
    }
}
