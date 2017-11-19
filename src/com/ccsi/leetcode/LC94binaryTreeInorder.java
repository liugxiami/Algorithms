package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/5/5.
 */
public class LC94binaryTreeInorder {
    private List<Integer> result=new ArrayList<>();
    public List<Integer> inorderTraversa2(TreeNode root){
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

    //Philip
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> result=new ArrayList<>();   //保存结果
        if(root==null)return result;

        Stack<TreeNode> stack=new Stack<>();      //用stack来做
        TreeNode curr=root;

        while(!stack.isEmpty()||curr!=null){      //很重要
            if(curr==null){
                curr=stack.peek();
            }else{
                stack.push(curr);
                while(curr.left!=null){
                    curr=curr.left;
                    stack.push(curr);
                }
            }
            //左树访问完了之后
            result.add(curr.val);//访问中
            stack.pop();
            curr=curr.right;     //跑到右边去
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
