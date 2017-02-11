package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/11.
 */
public class LC84largestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights){
        if(heights==null||heights.length==0)return 0;
        int len=heights.length;
        int max=Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int curr=heights[i];
            int li=i,hi=i;
            while(li>=0&&heights[li]>=curr)li--;
            while(hi<len&&heights[hi]>=curr)hi++;
            int temp=curr*(hi-1-li);
            max=max>temp?max:temp;
        }
        return max;
    }
}

