package com.ccsi.leetcode;
import java.util.*;
/**
 * Created by gxliu on 2017/1/30.
 */
public class LC119pascalTriangleII {
    public static void main(String[] args) {
        List<Integer> res=getRow(4);
        res.forEach(n-> System.out.println(n));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        res.add(1);
        if(rowIndex==0)return res;
        res.add(1);
        if(rowIndex==1)return res;

        //注意，从后往前更新，更新时用set
        for (int row = 2; row <=rowIndex; row++) {
            for (int col = row-1; col >0 ; col--) {
                res.set(col,res.get(col)+res.get(col-1));
            }
            res.add(1);
        }
        return res;
    }
}
