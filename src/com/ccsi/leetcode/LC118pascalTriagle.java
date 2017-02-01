package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/1/30.
 */
public class LC118pascalTriagle {
    public static void main(String[] args) {
        List<List<Integer>> res=new ArrayList<>();
        res=generate1(5);
    }
    //1.递推
    public static List<List<Integer>> generate(int numRows){
        int[][] matrix=new int[numRows][numRows];
        //初始化第一列
        for (int row = 0; row < numRows; row++) {
            matrix[row][0]=1;
        }
        //递推公式
        for (int row = 1; row < numRows; row++) {
            for (int col = 1; col < numRows; col++) {
                if(row==col)matrix[row][col]=1;
                else matrix[row][col]=matrix[row-1][col-1]+matrix[row-1][col];
            }
        }
        //将数组装进list
        List<List<Integer>> res=new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> list=new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                list.add(matrix[row][col]);
            }
            res.add(list);
        }
        return res;
    }
    //2.递推，直接操作List
    public static List<List<Integer>> generate1(int numRows){
        List<List<Integer>> res=new ArrayList<>();

        if(numRows<=0)return null;

        if(numRows>=1){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            res.add(temp);
        }

        if(numRows>=2){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            temp.add(1);
            res.add(temp);
        }

        if(numRows>=3){
            for (int row = 2; row < numRows; row++) {
                List<Integer> temp=new ArrayList<>();
                List<Integer> pre=res.get(row-1);
                temp.add(1);
                for (int col = 1; col < row; col++) {
                    temp.add(pre.get(col-1)+pre.get(col));
                }
                temp.add(1);
                res.add(temp);
            }

        }

        return res;

    }


}
