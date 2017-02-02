package com.ccsi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2017/2/1.
 */
public class LC101symmetricTree {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        System.out.println(isSymmetric1(root));
    }
    //1.DFS
    public static boolean isSymmetric(TreeNode root){
        if(root==null)return true;
        if(root.left==null&&root.right==null)return true;
        if(root.left==null||root.right==null)return false;
        return helper(root.left,root.right);
    }
    private static boolean helper(TreeNode leftTree,TreeNode rightTree){
        if(leftTree==null&&rightTree==null)return true;
        if(leftTree==null||rightTree==null)return false;
        if(leftTree.val!=rightTree.val)return false;
        else {
            return helper(leftTree.left,rightTree.right)&&helper(leftTree.right,rightTree.left);
        }
    }
    //2.BFS
    public static boolean isSymmetric1(TreeNode root){
        if(root==null)return true;
        if(root.left==null&&root.right==null)return true;
        if(root.left==null||root.right==null)return false;

        Queue<TreeNode> leftQueue=new LinkedList<>();
        Queue<TreeNode> rightQueue=new LinkedList<>();

        leftQueue.offer(root.left);
        rightQueue.offer(root.right);

        while(!leftQueue.isEmpty()&&!rightQueue.isEmpty()){
            TreeNode leftTemp=leftQueue.poll();
            TreeNode rightTemp=rightQueue.poll();

            if(leftTemp==null&&rightTemp==null)return true;
            if(leftTemp==null||rightTemp==null)return false;
            if(leftTemp.val!=rightTemp.val)return false;
            else{
                leftQueue.offer(leftTemp.left);
                rightQueue.offer(rightTemp.right);
                leftQueue.offer(leftTemp.right);
                rightQueue.offer(rightTemp.left);
            }
        }
        return true;  //是该true？
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(3);
        //root.right.right.right=new TreeNode(3);
        return root;
    }
}
