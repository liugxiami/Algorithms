package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/14.
 */
public class LC42TrapingRainWater {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));

    }
    //两遍遍历，一个从左到右，找最高的左短板；一个从右到左，找最高的右短板总；math.min(左[idx]，右[idx])。
    //最后记录下盛水量的总值，此时的盛水总量包括了基座，要减去元素数组。
    public static int trap(int[] height){
        if(height==null||height.length==0)return 0;
        int len=height.length;

        int[] leftNum=new int[len];
        int[] rightNum=new int[len];

        int max=height[0];
        leftNum[0]=height[0];
        for (int i = 1; i < len; i++) {
            leftNum[i]=height[i]>max?height[i]:max;
            max=height[i]>max?height[i]:max;
        }

        max=height[len-1];//归位
        rightNum[len-1]=height[len-1];
        for (int i = len-2; i >=0 ; i--) {
           rightNum[i]=height[i]>max?height[i]:max;
           max=height[i]>max?height[i]:max;
        }

        int[] num=new int[len];
        int res=0;
        for (int i = 0; i < len; i++) {
            num[i]=Math.min(leftNum[i],rightNum[i])-height[i];
            res+=num[i];
        }

        return res;
    }
}
