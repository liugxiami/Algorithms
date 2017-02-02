package com.ccsi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2017/2/1.
 */
public class LC100sameTree {
    public static void main(String[] args) {
        TreeNode p=buildTree1();
        TreeNode q=buildTree2();
        System.out.println(isSameTree(p,q));
    }
    //1.DFS
    public static boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        if(p.val!=q.val)return false;
        else{
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
    }

    //2.BFS
    public static boolean isSameTree1(TreeNode p,TreeNode q){

        Queue<TreeNode> pTree=new LinkedList<>();
        Queue<TreeNode> qTree=new LinkedList<>();
        pTree.offer(p);
        qTree.offer(q);
        while(!pTree.isEmpty()&&!qTree.isEmpty()){
            TreeNode pTemp=pTree.poll();
            TreeNode qTemp=qTree.poll();

            if(pTemp==null&&qTemp==null)return true;
            if(pTemp==null||qTemp==null)return false;
            if(pTemp.val!=qTemp.val)return false;
            else{
                pTree.offer(pTemp.left);
                qTree.offer(qTemp.left);
                pTree.offer(pTemp.right);
                qTree.offer(qTemp.right);
            }
        }
        return true;
    }
    public static TreeNode buildTree1(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        return root;
    }

    public static TreeNode buildTree2(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        //root.right.right=new TreeNode(7);
        return root;
    }
}
