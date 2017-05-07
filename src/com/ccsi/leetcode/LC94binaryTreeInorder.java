package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/5/5.
 */
public class LC94binaryTreeInorder {
    private List<Integer> result=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        inorder(root);
        return result;
    }
    //递归
    private void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }

    public List<Integer> inorderTraversal1(TreeNode root){
        if(root==null)return result;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;

        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else{
                curr=stack.pop();
                result.add(curr.val);
                curr=curr.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode  root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);

        LC94binaryTreeInorder inorderTra=new LC94binaryTreeInorder();
        List<Integer> res=inorderTra.inorderTraversal1(root);
        res.forEach(n-> System.out.println(n));
    }
}
