package com.ccsi.leetcode;


/**
 * Created by gxliu on 2017/1/22.
 */
public class LC235LCAofBST {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        TreeNode res=lowestCommonAncestor1(root,new TreeNode(0),new TreeNode(3));
        System.out.println(res.val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        //if(root==null||p==null||q==null)return null;
        if(root.val<p.val&&root.val<q.val)return lowestCommonAncestor(root.right,p,q);
        else if(root.val>p.val&&root.val>q.val) return lowestCommonAncestor(root.left,q,p);
        else return root;
    }
    public static TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q){
        TreeNode curr=root;

        while(curr!=null){
            if(curr.val<p.val&&curr.val<q.val)curr=curr.right;
            else if(curr.val>p.val&&curr.val>q.val)curr=curr.left;
            else return curr;
        }
        return null;
    }

    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(6);
        root.left=new TreeNode(2);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(9);
        root.left.right.left=new TreeNode(3);
        root.left.right.right=new TreeNode(5);
        return root;
    }
}
