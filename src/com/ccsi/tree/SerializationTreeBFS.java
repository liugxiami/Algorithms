package com.ccsi.tree;

import java.util.*;

/**
 * Created by gxliu on 2016/11/24.
 */
public class SerializationTreeBFS {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        int[] result=serialize(root);
        TreeNode root2=deserialize(result);
    }
    //反序列化
    public static TreeNode deserialize(int[] array){
        if(array==null||array.length==0)return null;
        TreeNode root=new TreeNode(array[0]);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        int idx=1;
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(array[idx]==Integer.MIN_VALUE){
                curr.left=null;
            }else{
                curr.left=new TreeNode(array[idx]);
                queue.offer(curr.left);
            }
            idx++;

            if(array[idx]==Integer.MIN_VALUE){
                curr.right=null;
            }else{
                curr.right=new TreeNode(array[idx]);
                queue.offer(curr.right);
            }
            idx++;
        }
        return root;
    }

    //基于BFS序列化树
    public static int[] serialize(TreeNode root){
        if(root==null)return null;

        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        result.add(root.val);

        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();

            if(curr.left!=null){
                queue.offer(curr.left);
                result.add(curr.left.val);
            }else{
                result.add(Integer.MIN_VALUE);
            }

            if(curr.right!=null){
                queue.offer(curr.right);
                result.add(curr.right.val);
            }else{
                result.add(Integer.MIN_VALUE);
            }
        }
        return SerializationTree.listToArray(result);
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(8);
        return root;
    }
}
