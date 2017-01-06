package com.ccsi.test;

/**
 * Created by gxliu on 2017/1/5.
 */
public class LC64minPathSum {
    public static void main(String[] args) {
        int[][] grid={{1,2,4,2},
                {2,3,4,5},
                {3,2,1,4},
                {5,6,7,8}};
        System.out.println(minPathSum1(grid));
    }
    //1.递推+缓存
    public static int minPathSum(int[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0)return 0;

        int rowNum=grid.length;
        int colNum=grid[0].length;

        int[][] cache=new int[rowNum][colNum];   //缓存
        //初始化
        cache[0][0]=grid[0][0];
        for (int i = 1; i < rowNum; i++) {
            cache[i][0]=cache[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < colNum; i++) {
            cache[0][i]=cache[0][i-1]+grid[0][i];
        }
        //合适的循环
        for (int i = 1; i <rowNum ; i++) {
            for (int j = 1; j < colNum; j++) {
                cache[i][j]=Math.min(cache[i-1][j],cache[i][j-1])+grid[i][j];
            }
        }
        return cache[rowNum-1][colNum-1];
    }
    //2.内存优化
    public static int minPathSum1(int[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0)return 0;

        int rowNum=grid.length;
        int colNum=grid[0].length;

        int[] pre=new int[colNum];   //缓存
        //初始化
        pre[0]=grid[0][0];
        for (int i = 1; i < rowNum; i++) {
            pre[i]=pre[i-1]+grid[0][i];
        }
        int colSum=grid[0][0];
        //合适的循环
        for (int i = 1; i <rowNum ; i++) {
            int[] curr=new int[colNum];
            colSum+=grid[i][0];
            curr[0]=colSum;
            for (int j = 1; j < colNum; j++) {
                curr[j]=Math.min(pre[j],curr[j-1])+grid[i][j];
            }
            pre=curr;
        }
        return pre[colNum-1];
    }
}
