package com.ccsi.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gxliu on 2017/1/23.
 */
public class LC217containsDuplicate {
    public static boolean containsDuplicate(int[] nums){
        if(nums==null||nums.length<=1)return false;
        Set<Integer> lookup=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!lookup.add(nums[i]))return true;
        }
        return false;
    }
    public static boolean containsDuplicates1(int[] nums){
        if(nums==null||nums.length<=1)return false;
        Arrays.sort(nums);             //O(nlg2n)
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1])return true;
        }
        return false;
    }
}
