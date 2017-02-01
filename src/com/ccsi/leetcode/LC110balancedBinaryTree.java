package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/31.
 */
public class LC110balancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        System.out.println(isBalanced1(root));
    }
    //1.通常递归
    public static boolean isBalanced(TreeNode root){
        if(root==null)return true;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        if(Math.abs(leftHeight-rightHeight)>1)return false;
        else return isBalanced(root.left)&&isBalanced(root.right);
    }
    private static int height(TreeNode curr){
        if(curr==null)return -1;
        return 1+Math.max(height(curr.left),height(curr.right));
    }
    //2.还是递归,九章
    public static boolean isBalanced1(TreeNode root){
        return maxHeight(root)!=-1;
    }
    private static int maxHeight(TreeNode root){
        if(root==null)return 0;
        int leftHeight=maxHeight(root.left);
        int rightHeight=maxHeight(root.right);
        if(leftHeight==-1||rightHeight==-1||Math.abs(leftHeight-rightHeight)>1)return -1;
        else return 1+Math.max(leftHeight,rightHeight);
    }

    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(4);
        root.right.right.left=new TreeNode(9);
        //root.right.right.left.left=new TreeNode(9);
        return root;
    }
}
