package com.ccsi.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2016/12/12.
 */
public class AVLTree {
    class AvlNode{
        Comparable element;
        AvlNode left;
        AvlNode right;
        int height;

        public AvlNode(Comparable element, AvlNode left, AvlNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = Math.max(height(left),height(right))+1;
        }
    }

    AvlNode root;

    public AVLTree() {
        root=null;
    }

    private int height(AvlNode t){
        return t==null?-1:t.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void printTree(){
        if(isEmpty()){
            System.out.println("Empty tree!");
        }else{
            printTree(root);
        }
    }
    //inorder DFS
    private void printTree(AvlNode curr){
        if(curr==null)return;
        printTree(curr.left);
        System.out.println(curr.element);
        printTree(curr.right);
    }
    //BFS
    public void layerPrint(){
        Queue<AvlNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            AvlNode curr=queue.poll();
            System.out.print(curr.element+" ");
            if(curr.left!=null)queue.offer(curr.left);
            if(curr.right!=null)queue.offer(curr.right);
        }
    }

    public void insert(Comparable x){
        root=insert(x,root);
    }

    private AvlNode insert(Comparable x,AvlNode t){
        if(t==null){
            t=new AvlNode(x,null,null);
        }else if(x.compareTo(t.element)<0){
            t.left=insert(x,t.left);
            if(height(t.left)-height(t.right)>=2){
                if(x.compareTo(t.left.element)<0){
                    t=rotateWithLeftChild(t);
                }else{
                    t=doubleWithLeftChild(t);
                }
            }
        }else if(x.compareTo(t.element)>0){
            t.right=insert(x,t.right);
            if(height(t.right)-height(t.left)>=2){
                if(x.compareTo(t.right.element)>0){
                    t=rotateWithRightChild(t);
                }else{
                    t=doubleWithRightChild(t);
                }
            }
        }
        t.height=Math.max(height(t.left),height(t.right))+1;
        return t;
    }
    private AvlNode rotateWithLeftChild(AvlNode root){
        AvlNode newRoot=root.left;
        root.left=newRoot.right;
        newRoot.right=root;
        root.height=Math.max(height(root.left),height(root.left))+1;
        newRoot.height=Math.max(height(newRoot.left),height(newRoot.right))+1;
        return newRoot;
    }
    private AvlNode rotateWithRightChild(AvlNode root){
        AvlNode newRoot=root.right;
        root.right=newRoot.left;
        newRoot.left=root;
        root.height=Math.max(height(root.left),height(root.right))+1;
        newRoot.height=Math.max(height(newRoot.left),height(newRoot.right))+1;
        return newRoot;
    }
    private AvlNode doubleWithLeftChild(AvlNode root){
        AvlNode t=rotateWithRightChild(root.left);
        return rotateWithLeftChild(root);
    }
    private AvlNode doubleWithRightChild(AvlNode root){
        AvlNode t=rotateWithLeftChild(root.right);
        return rotateWithRightChild(root);
    }
    public static void main(String[] args) {

        AVLTree t = new AVLTree();
        final int NUMS = 30;
        final int GAP = 37;

        System.out.println("Checking... (no more output means success)");

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
            System.out.print(i + " ");
            t.insert(new Integer(i));
        }

        System.out.println();
        if (NUMS < 40) {
            t.printTree();
            t.layerPrint();
        }

    }
}
