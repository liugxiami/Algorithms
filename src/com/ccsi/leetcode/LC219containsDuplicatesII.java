package com.ccsi.leetcode;
import java.util.*;
/**
 * Created by gxliu on 2017/1/23.
 */
public class LC219containsDuplicatesII {
    public static boolean containsDuplicate(int[] nums,int k){
        if(nums==null||nums.length<=1)return false;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for (Integer i:map.keySet()) {
            int size=map.get(i).size();
            if(size>=2){
                for (int j = 1; j < size; j++) {
                    if((map.get(i).get(j)-map.get(i).get(j-1))>=k)return true;
                }
            }
        }
        return false;
    }
    public static boolean containsDuplicates1(int[] nums,int k){
        if(nums==null||nums.length==0)return false;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);   //精巧在set只保存i之前的k个数。
            }
        }
        return false;
    }
}
