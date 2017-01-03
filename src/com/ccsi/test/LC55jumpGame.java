package com.ccsi.test;

import com.ccsi.Main;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by gxliu on 2017/1/2.
 */
public class LC55jumpGame {
    //1.0 Philip
    public static boolean canJump(int[] nums){
        if(nums==null||nums.length==0)return true;

        int len=nums.length;

        int max=0;
        for (int i = 0; i < len; i++) {
            if(max<i)return false;
            if(nums[i]==0&&max==i)return false;
            max= Math.max(max,nums[i]+i);
            if(max>=len-1)return true;
        }
        return false;
    }
    //2.0 Timothy 更简洁还容易理解
    public static boolean canJump1(int[] nums){
        if(nums==null||nums.length==0)return true;

        int len=nums.length;

        int max=nums[0];
        for (int i = 1; i < max; i++) {
            max=Math.max(max,nums[i]+i);
            if(max>=len-1)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A={3,2,1,0,4};
        System.out.println(canJump(A));
    }
}
