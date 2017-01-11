package com.ccsi.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by gxliu on 2017/1/10.
 */
public class CountObjects {
    public static void main(String[] args) {
        int[][] image=buildImage();
        System.out.println(countObject2(image));
    }


    public static int countObject(int[][] image){
        int rowNum=image.length;
        int colNum=image[0].length;
        int count=0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if(image[i][j]==1){
                    count++;
                    mark(image,rowNum,colNum,i,j); //DFS
                }
            }
        }
        return count;
    }
    //1.DFS
    private static void mark(int[][] image,int rowNum,int colNum,int row,int col){
        if(row<0||row>=rowNum||col<0||col>=colNum)return;

        if(image[row][col]==1){     //如果没有这个判断，会stackoverthrow。
            image[row][col]=2;

            mark(image,rowNum,colNum,row-1,col);
            mark(image,rowNum,colNum,row+1,col);
            mark(image,rowNum,colNum,row,col-1);
            mark(image,rowNum,colNum,row,col+1);
        }
    }
    //2.BFS
    private static int countObject1(int[][] image){
        int rowNum=image.length;
        int colNum=image[0].length;
        int count=0;
        Queue<Pointer> queue=new LinkedList<>();

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if(image[i][j]==1){
                    count++;
                    queue.offer(new Pointer(i,j));

                    while(!queue.isEmpty()){
                        Pointer curr=queue.poll();
                        int currRow=curr.row;
                        int currCol=curr.col;
                        image[currRow][currCol]=2;

                        if(children(image,currRow-1,currCol)&&image[currRow-1][currCol]==1)queue.offer(new Pointer(currRow-1,currCol));
                        if(children(image,currRow+1,currCol)&&image[currRow+1][currCol]==1)queue.offer(new Pointer(currRow+1,currCol));
                        if(children(image,currRow,currCol-1)&&image[currRow][currCol-1]==1)queue.offer(new Pointer(currRow,currCol-1));
                        if(children(image,currRow,currCol+1)&&image[currRow][currCol+1]==1)queue.offer(new Pointer(currRow,currCol+1));
                    }
                }
            }
        }
        return count;
    }
    //3.BFS
    private static int countObject2(int[][] image){
        int rowNum=image.length;
        int colNum=image[0].length;
        int count=0;
        Queue<Pointer> queue=new LinkedList<>();
        Set<Pointer> visited=new HashSet<>();   //利用set来记录已经, 也可以在Pointer类里加一个boolean属性accessed。

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                Pointer p=new Pointer(i,j);
                if(image[i][j]==1&&visited.add(p)){
                    count++;
                    queue.offer(p);

                    while(!queue.isEmpty()){
                        Pointer curr=queue.poll();
                        int currRow=curr.row;
                        int currCol=curr.col;
                        image[currRow][currCol]=2;

                        if(children(image,currRow-1,currCol)&&image[currRow-1][currCol]==1){
                            Pointer p1=new Pointer(currRow-1,currCol);
                            if(visited.add(p1)){
                                queue.offer(p1);
                            }
                        }
                        if(children(image,currRow+1,currCol)&&image[currRow+1][currCol]==1){
                            Pointer p2=new Pointer(currRow+1,currCol);
                            if(visited.add(p2)){
                                queue.offer(p2);
                            }
                        }
                        if(children(image,currRow,currCol-1)&&image[currRow][currCol-1]==1){
                            Pointer p3=new Pointer(currRow,currCol-1);
                            if(visited.add(p3)){
                                queue.offer(p3);
                            }
                        }
                        if(children(image,currRow,currCol+1)&&image[currRow][currCol+1]==1){
                            Pointer p4=new Pointer(currRow,currCol+1);
                            if(visited.add(p4)){
                                queue.offer(p4);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static boolean children(int[][] image,int row ,int cul){
        if(row>=0&&row<image.length&&cul>=0&&cul<image[0].length)return true;
        else return false;
    }

    static class Pointer{
        int row;
        int col;

        public Pointer(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static int[][] buildImage(){
        int rowNum=10;
        int colNum=10;
        int[][] matrix=new int[rowNum][colNum];
        for (int i = 1; i <=6 ; i++) {
            matrix[1][i]=1;
            matrix[6][i]=1;

            matrix[i][1]=1;
            matrix[i][6]=1;
        }

        for (int i = 3; i <= 8; i++) {
            matrix[3][i]=1;
            matrix[8][i]=1;

            matrix[i][3]=1;
            matrix[i][8]=1;
        }

        matrix[0][9]=1;
        return matrix;
    }
}
