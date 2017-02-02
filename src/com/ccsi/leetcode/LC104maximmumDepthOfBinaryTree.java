package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/31.
 */
public class LC104maximmumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        System.out.println(maxDepth(root));
    }
    //1.此方法并非最佳
    public static int maxDepth(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    //2.用剪枝法，在此处是用定深DFS（传深度，外部定深度）
    public static int maxDepth1(TreeNode root){
        if(root==null)return 0;
        helper(root,0);
        return maxLevel;
    }

    private static int maxLevel=0;
    private static  void helper(TreeNode curr,int level){
        level+=1;
        if(curr.left==null&&curr.right==null){
            maxLevel=maxLevel>level?maxLevel:level;
        }

        if(curr.left!=null)helper(curr.left,level);
        if(curr.right!=null)helper(curr.right,level);
    }

    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        root.right.right.right=new TreeNode(8);
        return root;
    }
}
