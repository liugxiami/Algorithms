package com.ccsi.leetcode;

import java.util.*;


/**
 * Created by gxliu on 2017/2/25.
 */
public class LC39CombinationSumI {
    public static void main(String[] args) {
        int[] nums={1,3,7,5,4,6,2};
        List<List<Integer>> res=combineSum(nums,10);
    }

    public static List<List<Integer>> combineSum(int[] nums, int target){
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0)return res;

        Arrays.sort(nums);
        int len=nums.length;
        Stack<Integer> curr=new Stack<>();

        if(target<0)return res;

        helper(res,curr,nums,0,len,target);
        return res;
    }
    private static void helper(List<List<Integer>> res,Stack<Integer> curr,int[] nums,int idx,int length,int target){
        if(target<0)return;

        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < length; i++) {
            curr.push(nums[i]);
            target-=nums[i];
            helper(res,curr,nums,i+1,length,target);
            target+=nums[i];
            curr.pop();
        }
    }
}
