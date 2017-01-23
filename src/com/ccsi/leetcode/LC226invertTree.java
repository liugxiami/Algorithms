package com.ccsi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2017/1/22.
 */
public class LC226invertTree {
    //DFS
    public static TreeNode invertTree(TreeNode root){
        if(root==null)return root;

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    //BFS
    public static TreeNode invertTree1(TreeNode root){
        if(root==null)return root;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            TreeNode temp=curr.left;
            curr.left=curr.right;
            curr.right=temp;
            if(curr.left!=null)queue.offer(curr.left);
            if(curr.right!=null)queue.offer(curr.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=LC235LCAofBST.buildTree();
        TreeNode res=invertTree1(root);

    }
}
