package com.ccsi.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2016/12/29.
 */
public class LC200NumIslands {
    private class point{
        int row;
        int col;

        public point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)return 0;
        int row=grid.length;
        int col=grid[0].length;

        Queue<point> queue=new LinkedList<>();
        boolean[][] flag=new boolean[row][col];
        int count=0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if(flag[r][c])continue;   //if visited, continue

                char ch=grid[r][c];
                if(ch=='1'){
                    queue.offer(new point(r,c));
                    while(!queue.isEmpty()){
                        point p=queue.poll();

                        if(canVisit(grid,flag,p.row-1,p.col,row,col)){
                            queue.offer(new point(p.row-1,p.col));
                        }
                        if(canVisit(grid,flag,p.row+1,p.col,row,col)){
                            queue.offer(new point(p.row+1,p.col));
                        }
                        if(canVisit(grid,flag,p.row,p.col-1,row,col)){
                            queue.offer(new point(p.row,p.col-1));
                        }
                        if(canVisit(grid,flag,p.row,p.col+1,row,col)){
                            queue.offer(new point(p.row,p.col+1));
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private boolean canVisit(char[][] grid,boolean[][] flag,int row,int col,int rowNum,int colNum){
        if(row<0||row>=rowNum||col<0||col>=colNum||flag[row][col])return false;
        flag[row][col]=true;
        return grid[row][col]=='1';
    }

    public static void main(String[] args) {
        char[][] grid={{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        LC200NumIslands is=new LC200NumIslands();
        System.out.println(is.numIslands(grid));
    }
}
