package com.ccsi.tree;

/**
 * Created by gxliu on 2017/2/20.
 */
public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode root=SerializationTree.buildTree();
        morrisPreOrder(root);
    }
    //in order
    public static void morrisInOrder(TreeNode root){
        if(root==null)return;
        TreeNode curr=root;
        TreeNode preCurr=null;

        while(curr!=null){
            if(curr.left==null){
                System.out.println(curr.val);
                curr=curr.right;
            }else{
                preCurr=curr.left;
                while(preCurr.right!=null&&preCurr.right!=curr){
                    preCurr=preCurr.right;
                }
                if(preCurr.right==null){
                    preCurr.right=curr;
                    curr=curr.left;
                }else{
                    preCurr.right=null;
                    System.out.println(curr.val);
                    curr=curr.right;
                }
            }

        }
    }
    //pre order
    public static void morrisPreOrder(TreeNode root){
        if(root==null)return;
        TreeNode curr=root;
        TreeNode preCurr=null;

        while(curr!=null){
            if(curr.left==null){
                System.out.println(curr.val);
                curr=curr.right;
            }else{
                preCurr=curr.left;
                while(preCurr.right!=null&&preCurr.right!=curr){
                    preCurr=preCurr.right;
                }
                if(preCurr.right==null){
                    System.out.println(curr.val);  //pre
                    preCurr.right=curr;
                    curr=curr.left;
                }else{
                    preCurr.right=null;
                    curr=curr.right;
                }
            }
        }
    }
}
