package com.ccsi.leetcode;

import com.ccsi.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2017/1/31.
 */
public class LC111minimunDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        System.out.println(minDepth(root));
    }
    //该recursion有问题
    public static int minDepth(TreeNode root){
        if(root==null)return -1;
        int level=-1;
        int[] minLevel=new int[1];
        minLevel[0]=Integer.MAX_VALUE;
        helper(root,level,minLevel);   //Pass integer by reference，用只有一个元素的数组来传递就可以了，
        return minLevel[0];
    }
    //注意，Integer or int 不能传递数值，取巧可以用一个元素的数组。那么如果string的话用stringB
    private static void helper(TreeNode curr,int level,int[] minLevel){

        level=level+1;
        if(curr.left==null&&curr.right==null){
            minLevel[0]=minLevel[0]>level?level:minLevel[0];
        }
        //此处没有else
        if(curr.left!=null)helper(curr.left,level,minLevel);
        if(curr.right!=null)helper(curr.right,level,minLevel);
    }
    //用BFS做好
    public static int minDepth1(TreeNode root){
        if(root==null)return -1;
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> level=new LinkedList<>();
        queue.offer(root);
        level.offer(0);
        int minD=Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            Integer currLevel=level.poll();

            if(temp.left==null&&temp.right==null){
                minD=Math.min(minD,currLevel);
            }else{
                if(temp.left!=null){
                    queue.offer(temp.left);
                    level.offer(currLevel+1);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                    level.offer(currLevel+1);
                }
            }
        }
        return minD;
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(11);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right.left=new TreeNode(13);
        root.right.left.left=new TreeNode(10);
        root.right.right=new TreeNode(4);
        root.right.right.right=new TreeNode(1);
        root.right.right.right.right=new TreeNode(9);
        return root;
    }
}
