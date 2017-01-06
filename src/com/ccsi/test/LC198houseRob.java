package com.ccsi.test;

/**
 * Created by gxliu on 2017/1/5.
 * 动态规划
 */
public class LC198houseRob {
    public static void main(String[] args) {
        int[] nums={2,4,6,2,10,2,12,13};
        System.out.println(rob1(nums));
    }
    //1. 递推+缓存
    public static int rob(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int[] cache=new int[len];
        //初始状态
        cache[0]=nums[0];
        if(len==1)return cache[0];
        cache[1]=nums[1]>nums[0]?nums[1]:nums[0];
        //合适的循环
        for (int i = 2; i <len; i++) {
            cache[i]=Math.max(nums[i]+cache[i-2],cache[i-1]);
        }
        return cache[len-1];
    }

    //2.内存优化
    public static int rob1(int[] nums){
        if(nums==null||nums.length==0)return 0;
        //初始状态
        int len=nums.length;
        int first=nums[0];
        if(len==1)return first;
        int second=Math.max(nums[0],nums[1]);
        //合适的循环
        for (int i = 2; i < len ; i++) {
            int curr=Math.max(nums[i]+first,second);
            first=second;
            second=curr;
        }
        return second;
    }

    //3. 递归+缓存
    public static int rob2(int[] nums){
        int[] cache=new int[nums.length];
        rob1(nums,nums.length-1,cache);
        return cache[nums.length-1];
    }
    private static int rob1(int[] nums,int idx,int[] cache){
        if(idx==0){
            cache[0]=nums[0];
        }
        if(idx==1){
            cache[1]=nums[1]>nums[0]?nums[1]:nums[0];    //初始化状态
        }

        if(cache[idx]!=0)return cache[idx];    //为了保证不用重复计算
        cache[idx]=Math.max(nums[idx]+rob1(nums,idx-2,cache),rob1(nums,idx-1,cache));
        return cache[idx];
    }
}
