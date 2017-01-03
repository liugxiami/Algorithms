package com.ccsi.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by gxliu on 2017/1/2.
 */
public class LC452findMinArrow {

    public static int findMinArrowShots(int[][] points){
        if(points==null||points.length==0||points[0].length==0)return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] pointA, int[] pointB) {
                if(pointA[0]==pointB[0])return pointA[1]-pointB[1];
                else return pointA[0]-pointB[0];
            }
        });    //对二维数组排序，按第一个数字排，如果相等则按第二位排

        int minimunArrows=1;    //最少一枚箭
        int arrowLimit=points[0][1];   //第一组的末端
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]<arrowLimit){
                arrowLimit=Math.min(arrowLimit,points[i][1]);   //贪心算法保留最小的末端
            }else{
                minimunArrows++;
                arrowLimit=points[i][1];                         //新建一只箭
            }
        }
        return minimunArrows;
    }

    public static void main(String[] args) {
        int[][] points={{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShots(points));
    }
}
