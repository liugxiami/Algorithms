package com.ccsi.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by gxliu on 2017/1/12.
 */
public class LC78Subsets {
    public static List<List<Integer>> result=new ArrayList<>();

    //1.classic recursion
    public static List<List<Integer>> subsets(int[] nums){
        if(nums==null||nums.length==0)return result;
        int len=nums.length;
        helper(nums,len,0,new Stack<Integer>());
        return result;
    }

    private static void helper(int[] nums,int len,int idx,Stack<Integer> subset){
        if(idx>=len){
            result.add(new ArrayList<>(subset));
            return;
        }

        helper(nums,len,idx+1,subset);

        subset.push(nums[idx]);
        helper(nums,len,idx+1,subset);
        subset.pop();
    }
    
    //2.bit-manipulation
    public static List<List<Integer>> subsets1(int[] nums){
        if(nums==null||nums.length==0)return result;
        
        int len=nums.length;
        for (int i = 0; i < Math.pow(2, len); i++) {
            int j=i;
            List<Integer> subset=new ArrayList<>();
            for (int k = 0; k < len&&j>0; k++) {
                if((j&1)==1){
                    subset.add(nums[k]);
                }
                j>>>=1;
            }
            result.add(subset);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3};
        subsets1(nums);
    }
}
