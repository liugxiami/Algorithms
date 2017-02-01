package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/31.
 */
public class LC104maximmumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root){
        if(root==null)return -1;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        //root.right.right.right=new TreeNode(8);
        return root;
    }
}
