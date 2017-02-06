package com.ccsi.leetcode;

import java.util.HashSet;
import java.util.*;
import java.util.Set;

/**
 * Created by gxliu on 2017/2/5.
 */
public class LC1twoSum {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int[] res=TwoSum(nums,9);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] TwoSum(int[] nums,int target){
        int[] result =new int[2];
        if(nums==null||nums.length<2)return result;
        Map<Integer,Integer> delta=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff=target-nums[i];
            if(delta.containsKey(nums[i])){
                result[0]=delta.get(nums[i]);
                result[1]=i;
                break;
            }else{
                delta.put(diff,i);
            }
        }
        return result;
    }
}
