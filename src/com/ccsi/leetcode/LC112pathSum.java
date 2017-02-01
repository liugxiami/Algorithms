package com.ccsi.leetcode;
import java.util.*;
/**
 * Created by gxliu on 2017/1/30.
 */
public class LC112pathSum {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        System.out.println(hasPathSum1(root,19));
    }
    //1
    public static boolean hasPathSum(TreeNode root, int sum) {
        Stack<Integer> path=new Stack<>();
        List<List<Integer>> res=new ArrayList<>();
        helper(root,path,res);
        for (List<Integer> list:res){
            int total=0;
            for(Integer i:list){
                total+=i;
            }
            if(total==sum)return true;
        }
        return false;
    }
    //记录了所有路径，太复杂了，浪费
    private static void helper(TreeNode curr,Stack<Integer> path,List<List<Integer>> res){
        path.push(curr.val);

        if(curr.left==null&&curr.right==null){
            res.add(new ArrayList<>(path));
        }else{
            if(curr.left!=null)helper(curr.left,path,res);
            if(curr.right!=null)helper(curr.right,path,res);
        }

        path.pop();
    }
    //2
    public static boolean hasPathSum1(TreeNode root,int sum){
        if(root==null)return false;

        sum-=root.val;
        //如果sum减到0了并且到了叶子节点，那么为真，否则继续recursion
        if(sum==0&&root.left==null&&root.right==null)return true;
        else{
            return hasPathSum1(root.left,sum)||hasPathSum1(root.right,sum);
        }
    }

    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(11);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(4);
        root.right.right.right=new TreeNode(1);
        return root;
    }
}
