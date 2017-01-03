package com.ccsi.test;

/**
 * Created by gxliu on 2017/1/2.
 */
public class LC134gasStation {
    public static int canCompleteCirtuit(int[] gas,int[] cost){
        int n=gas.length;

        if(n==1)return gas[0]-cost[0]>=0?0:-1;

        int total=0;
        for (int i = 0; i < n; i++) {
            cost[i]=gas[i]-cost[i];
            total+=cost[i];
        }

        if(total<0)return -1;

        total=0;
        int result=n;
        for (int i = 0; i < n; i++) {
            total+=cost[i];
            if(total<0){           //说明此站之前的站都不行，那么total归0，results设为最大值
                total=0;
                result=n;
            }else{
                result=Math.min(result,i);   //注意，保留的是归0之后的开始值
            }

        }
        return result;
    }

}
