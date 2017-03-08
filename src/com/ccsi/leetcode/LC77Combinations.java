package com.ccsi.leetcode;
import java.util.*;

/**
 * Created by gxliu on 2017/2/25.
 */
public class LC77Combinations {
    public static void main(String[] args) {
        List<List<Integer>> res=combine(5,3);
    }
    public static List<List<Integer>> combine(int n,int k){
        List<List<Integer>> res=new ArrayList<>();
        if(n<k)return res;
        Stack<Integer> curr=new Stack<>();
        helper(res,curr,n,k,1);
        return res;
    }
    private static void helper(List<List<Integer>> res,Stack<Integer> curr,int n,int k,int level){
        if(curr.size()>k){
            return;
        }
        if(curr.size()==k){
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = level; i <=n; i++) {
            curr.push(i);
            helper(res,curr,n,k,i+1);
            curr.pop();
        }

    }
}
