package com.ccsi.leetcode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * Created by gxliu on 2017/1/22.
 */
public class LC257binaryTreePath {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        List<String> res=binaryTreePath(root);
        res.forEach((s)-> System.out.println(s));
    }
    public static List<String> binaryTreePath(TreeNode root){
        List<List<Integer>> bag=new ArrayList<>();
        Stack<TreeNode> path=new Stack<>();
        bt(bag,path,root);

        List<String> res=new ArrayList<>();
        for (int i = 0; i < bag.size(); i++) {
            List<Integer> list=bag.get(i);
            StringBuilder builder=new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                Integer p=list.get(j);
                builder.append(String.valueOf(p));
                if(j!=list.size()-1){
                    builder.append("->");
                }
            }
            res.add(builder.toString());
        }
        return res;
    }
    private static void bt(List<List<Integer>> bag, Stack<TreeNode> path, TreeNode curr){
        path.push(curr);

        if(curr.left==null&&curr.right==null){      //碰到叶子节点了，做点什么
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < path.size(); i++) {
                list.add(path.get(i).val);
            }
            bag.add(list);
        }else{                                       //否则，递归。
            if(curr.left!=null)bt(bag,path,curr.left);
            if(curr.right!=null)bt(bag,path,curr.right);
        }

        path.pop();
    }
    private static TreeNode buildTree(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        return root;
    }
}

