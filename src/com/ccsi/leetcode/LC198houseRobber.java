package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/24.
 */
public class LC198houseRobber {
    public static void main(String[] args) {
        int[] nums={1,3,2,5,7,3,9,10};
        System.out.println(rob2(nums));
    }
    //1.递推 O（n）
    public static int rob(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int[] cache=new int[len];
        cache[0]=nums[0];
        if(len==1)return cache[0];
        cache[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            cache[i]=Math.max(cache[i-1],cache[i-2]+nums[i]);
        }
        return cache[len-1];
    }
    //2. 内存优化
    public static int rob1(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int first=nums[0];
        if(len==1)return first;
        int second=Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            int temp=Math.max(second,nums[i]+first);
            first=second;
            second=temp;
        }
        return second;
    }
    //3.recursion
    public static int rob2(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int[] cache=new int[len+1];
        return helper(nums,len,cache);
    }
    private static int helper(int[] nums,int idx,int[] cache){
        if(idx==1)return nums[0];
        if(idx==2)return Math.max(nums[0],nums[1]);

        if(cache[idx]!=0)return cache[idx];
        cache[idx]=Math.max(helper(nums,idx-1,cache),helper(nums,idx-2,cache)+nums[idx-1]);
        return cache[idx];
    }
}
