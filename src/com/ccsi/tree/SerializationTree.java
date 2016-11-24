package com.ccsi.tree;

import java.util.*;

/**
 * Created by gxliu on 2016/11/23.
 */
public class SerializationTree {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        int[][] matrix=new int[2][];
        matrix=serializeTree(root);
        TreeNode root2=deSerialize(matrix);
        System.out.println(Tree.sameDFS(root,root2));
    }
    //反序列化
    public static TreeNode deSerialize(int[][] matrix){
        int[] pre=matrix[0];
        int[] in=matrix[1];
        TreeNode root=null;
        root=helper(pre,0,pre.length-1,in,0,in.length-1);
        Tree.BFS(root);
        return root;
    }
    //关键，反序列化的辅助函数
    public static TreeNode helper(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart>preEnd)return null;
        int pivot=pre[preStart];
        TreeNode root=new TreeNode(pivot);

        int i=inStart;
        for (; i <=inEnd; i++) {
            if(pivot==in[i])break;   //找出该根节点在inorder中的位置
        }

        //x-(preStart+1)=i-1-inStart==>x=i-inStart+preStart;
        //思路：不管是在preorder还是在inorder的数组中，左子树节点的数目必定是一样多的，右子树同理
        root.left=helper(pre,preStart+1,i-inStart+preStart,in,inStart,i-1);
        root.right=helper(pre,i-inStart+preStart+1,preEnd,in,i+1,inEnd);
        return root;
    }
    //serialize a tree to s 2D array
    //序列化到2维数组
    public static int[][] serializeTree(TreeNode root){
        int[][] result=new int[2][];
        List<Integer> pre=new ArrayList<>();
        preOrder(pre,root);
        result[0]=listToArray(pre);
        List<Integer> in=new ArrayList<>();
        inOrder(in,root);
        result[1]=listToArray(in);
        return result;
    }
    //preOrder 序列化
    public static void preOrder(List<Integer> result,TreeNode root){
        if(root==null)return;
        result.add(root.val);
        preOrder(result,root.left);
        preOrder(result,root.right);
    }
    //inorder 序列化
    public static void inOrder(List<Integer> result,TreeNode root){
        if(root==null)return;
        inOrder(result,root.left);
        result.add(root.val);
        inOrder(result,root.right);
    }
    //将list转换成数组
    public static int[] listToArray(List<Integer> a){
        if(a==null||a.size()==0)return null;
        int[] result=new int[a.size()];
        int i=0;
        for (Integer val:a){
            result[i++]=val;
            System.out.print(val+" ");
        }
        System.out.println();
        return result;
    }
    //build a tree
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        return root;
    }
}

