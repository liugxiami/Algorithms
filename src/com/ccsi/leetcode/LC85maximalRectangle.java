package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/11.
 */
public class LC85maximalRectangle {
    public static void main(String[] args) {
        char[][] matrix={{'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}};
        System.out.println(maxmalRectangle(matrix));
    }
    public static int maxmalRectangle(char[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        int rowNum=matrix.length;
        int colNum=matrix[0].length;

        //转换数组，转换成largest rectangle in histogram的数组
        int[][] aux=new int[rowNum][colNum];
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(row==0)aux[row][col]=matrix[row][col]-'0';
                else if(matrix[row][col]=='1'){
                    aux[row][col]=aux[row-1][col]+1;
                }else aux[row][col]=0;
            }
        }

        int max=Integer.MIN_VALUE;
        for (int row = 0; row < rowNum; row++) {
            int currMax=largest(aux[row]);
            max=max>currMax?max:currMax;
        }
        return max;
    }
    //same as LC84
    private static int largest(int[] heights){
        int max=Integer.MIN_VALUE;
        int len=heights.length;
        for (int i = 0; i < len; i++) {
            int li=i,hi=i;
            int curr=heights[i];
            while(li>=0&&heights[li]>=curr)li--;
            while(hi<len&&heights[hi]>=curr)hi++;
            int temp=curr*(hi-1-li);
            max=max>temp?max:temp;
        }
        return max;
    }
}

