package com.ccsi.tree;

import java.util.*;

/**
 * Created by gxliu on 2016/11/21.
 */
public class Tree {
    public static void main(String[] args) {
        TreeNode root=buildTreeTopDown();
        System.out.println(countCompleteBinaryTreeNodes(root));
    }
    //count complete binary tree nodes
    //左深=右深，那么必是满二叉树，满二叉树算节点数；左深=右深（+1），递归。
    public static int countCompleteBinaryTreeNodes(TreeNode root){
        if(root==null)return 0;

        int leftHeight=0;
        TreeNode curr=root.left;
        while(curr!=null){
            leftHeight++;
            curr=curr.left;
        }

        int rightHeight=0;
        curr=root.right;
        while(curr!=null){
            rightHeight++;
            curr=curr.right;
        }

        if(leftHeight==rightHeight){
            return (1<<(leftHeight+1))-1;
        }else{
            return 1+countCompleteBinaryTreeNodes(root.left)+countCompleteBinaryTreeNodes(root.right);
        }

    }
    //count full binary tree nodes 满二叉树的节点数是2^高度-1，所以先算出高度，再数学方法算出节点数
    public static int countFullBinaryTreeNodes(TreeNode root){
        if(root==null)return 0;
        int height=0;
        TreeNode curr=root;
        while(curr!=null){
            height++;
            curr=curr.left;   //or curr.right,满二叉树的特点是任意节点的左右子树的深度（高度）是一样的。
        }
        return (1<<height)-1;
    }
    //count numbers of Nodes
    public static int countNodes(TreeNode root){
        if(root==null)return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    //backtracking
    public static void bt(List<List<TreeNode>> bag, Stack<TreeNode> path, TreeNode curr){
        //因为压栈是做过检查，不可能出现curr==null的情况，所以不要做判断
        path.push(curr);
        if(curr.left==null&&curr.right==null){
            bag.add(new ArrayList<>(path));
        }else{
            if(curr.left!=null)bt(bag,path,curr.left);
            if(curr.right!=null)bt(bag,path,curr.right);
        }
        path.pop();
    }
    //利用loop来实现backtracking，双queue来实现。
    public static List<List<TreeNode>> findAllPath(TreeNode root){
        List<List<TreeNode>> result=new LinkedList<>();   //返回用的result
        List<TreeNode> init=new LinkedList<>();           //起始path
        //准备两个queue，一个存node，一个存path
        Queue<List<TreeNode>> pathQueue=new LinkedList<>();
        Queue<TreeNode> nodeQueue=new LinkedList<>();

        init.add(root);
        //node和起始path offer进queue
        nodeQueue.offer(root);
        pathQueue.offer(init);
        //BFS相通的步骤
        while(!nodeQueue.isEmpty()){
            List<TreeNode> path=pathQueue.poll();    //都poll（）出来
            TreeNode temp=nodeQueue.poll();

            if(temp.left==null&&temp.right==null){   //如果到叶子节点了，也就是找到路径了，做点什么事呢？
                result.add(path);
            }else{
                if(temp.left!=null){                 //如果没结束，那么要更新path
                    List<TreeNode> newPath=new LinkedList<>(path);
                    newPath.add(temp.left);          //更新path
                    pathQueue.offer(newPath);        //再进queue
                    nodeQueue.offer(temp.left);
                }
                if(temp.right!=null){                //同上
                    List<TreeNode> newPath=new LinkedList<>(path);
                    newPath.add(temp.right);
                    pathQueue.offer(newPath);
                    nodeQueue.offer(temp.right);
                }
            }
        }
        return result;
    }
    //BFS
    public static void BFS(TreeNode root){
        //if(root==null)return; 无须判断，因为不会有null传进来
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.println(temp.val);

            if(temp.left!=null)queue.offer(temp.left);
            if(temp.right!=null)queue.offer(temp.right);
        }
    }
    //recursion DFS
    public static void DFS(TreeNode curr){
        if(curr==null)return;
        System.out.println(curr.val);    //pre-order DFS
        DFS(curr.left);                  //如果没有前面的if(curr==null)return;此处需要判断是否为空。
        //System.out.println(curr.val);  //in-order DFS
        DFS(curr.right);
        //System.out.println(curr.val);  //post-order DFS
    }
    //Loop DFS 写法与BFS基本一样，用stack替代了queue，并且right和left颠倒了位置
    public static void loopDFS(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.println(temp.val);
            if(temp.right!=null)stack.push(temp.right); //pre-order right 和 left颠倒了位置
            if(temp.left!=null)stack.push(temp.left);

        }
    }
    //从上往下build树
    public static TreeNode buildTreeTopDown(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        //root.right.right=new TreeNode(7);
        return root;
    }
    //从下往上build树
    public static TreeNode buildTreeBottomUp(){
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        TreeNode n7=new TreeNode(7);
        TreeNode n2=new TreeNode(2,n4,n5);
        TreeNode n3=new TreeNode(3,n6,n7);
        TreeNode root= new TreeNode(1,n2,n3);
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

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
