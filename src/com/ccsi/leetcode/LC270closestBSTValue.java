package com.ccsi.leetcode;

import com.ccsi.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2017/1/19.
 */
public class LC270closestBSTValue {
    //1.loop
    public static int closestValue(TreeNode root,double target){
        TreeNode curr=root;
        double minDiff=Double.MAX_VALUE;
        int result=0;

        while(curr!=null){
            double diff=Math.abs(curr.val-target);
            if(minDiff>diff){
                minDiff=diff;
                result=curr.val;
            }

            if(curr.val==target)return curr.val;
            else if(target<curr.val)curr=curr.left;
            else curr=curr.right;
        }
        return result;
    }
    //2.recursion
    public static int closestValue1(TreeNode root,double target){
        double minDiff=Double.MAX_VALUE;
        int result=0;
        return helper(root,target,minDiff,result);
    }
    private static int helper(TreeNode curr,double target,double minDiff,int result){
        if(curr==null)return result;

        double diff=Math.abs(curr.val-target);
        if(diff<minDiff){
            minDiff=diff;
            result=curr.val;
        }

        if(target==curr.val)return curr.val;
        else if(target<curr.val)return helper(curr.left,target,minDiff,result);
        else return helper(curr.right,target,minDiff,result);

    }
    //3.bfs
    public static int closestValue2(TreeNode root,int target){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        double minDiff=Double.MAX_VALUE;
        int result=0;

        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            int diff=Math.abs(curr.val-target);
            if(diff<minDiff){
                minDiff=diff;
                result=curr.val;
            }

            if(target<curr.val&&curr.left!=null)queue.offer(curr.left);
            if(target>curr.val&&curr.right!=null)queue.offer(curr.right);
            //if(target==curr.val)return curr.val;
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root=buildTree();
        System.out.println(closestValue2(root,15));
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(15);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(8);
        root.right.left=new TreeNode(12);
        root.right.right=new TreeNode(18);
        return root;
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
