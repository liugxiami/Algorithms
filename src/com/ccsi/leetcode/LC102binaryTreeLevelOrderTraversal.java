package com.ccsi.leetcode;
import com.ccsi.tree.Tree;

import java.util.*;
/**
 * Created by gxliu on 2017/1/31.
 */
public class LC102binaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        List<List<Integer>> res=levelOrder(root);
    }
    //双
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Queue<TreeNode> next=new LinkedList<>();
            List<Integer> list=new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode temp=queue.poll();
                list.add(temp.val);
                if(temp.left!=null)next.offer(temp.left);
                if(temp.right!=null)next.offer(temp.right);
            }
            queue=next;
            res.add(0,list);
        }
        return res;
    }

    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(4);
        root.right.right.left=new TreeNode(9);
        //root.right.right.left.left=new TreeNode(9);
        return root;
    }
}
