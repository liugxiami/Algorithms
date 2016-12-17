package com.ccsi.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by gxliu on 2016/12/15.
 */
public class Permutation {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        Permutation p=new Permutation();
        ArrayList<ArrayList<Integer>> results=p.subsets(nums);

    }
    public ArrayList<ArrayList<Integer>> subsets(int[] nums){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;

        Arrays.sort(nums);
        DFS(result,new Stack<>(),nums,0);
        return result;
    }
    //不带重复元素的所有子集
    public void DFS(ArrayList<ArrayList<Integer>> res, Stack<Integer> cur, int[] nums, int start){
        cur.push(nums[start]);
        res.add(new ArrayList<>(cur));
        for(int i=start;i<nums.length-1;i++){
            DFS(res,cur,nums,i+1);
        }
        cur.pop();
    }
}
