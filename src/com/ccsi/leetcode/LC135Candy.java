package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/14.
 */
public class LC135Candy {
    public static void main(String[] args) {
        int[] ratings={1,3,5,4,3,1,4,6,2};
        System.out.println(candy(ratings));
    }
    //分别从左往右，从右往左迭代一遍，比前大则加1，否则为1；最终为两数组相应idx上的元素最大值。
    public static int candy(int[] ratings){
        if(ratings==null||ratings.length==0)return 0;
        int len=ratings.length;
        int[] leftNums=new int[len];
        int[] rightNums=new int[len];

        leftNums[0]=1;
        for (int i = 1; i < len; i++) {
            if(ratings[i]>ratings[i-1])leftNums[i]=leftNums[i-1]+1;
            else leftNums[i]=1;
        }

        rightNums[len-1]=1;
        for (int i = len-2; i >=0 ; i--) {
            if(ratings[i]>ratings[i+1])rightNums[i]=rightNums[i+1]+1;
            else rightNums[i]=1;
        }

        int sum=0;
        for (int i = 0; i < len; i++) {
            sum+=Math.max(leftNums[i],rightNums[i]);
        }
        return sum;

    }
}
