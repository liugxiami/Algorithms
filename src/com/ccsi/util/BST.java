package com.ccsi.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2016/12/6.
 */
public class BST<Key extends Comparable<Key>,Value> {
    private class Node{
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key, Value val,int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }
    private Node root;

    public int size(){
        return size(root);
    }
    private int size(Node root){
        if(root==null)return 0;
        else return root.N;
    }
    public Value get(Key key){
        return get(key,root);
    }
    private Value get(Key key,Node curr){
        if(curr==null)return null;
        int cmp=key.compareTo(curr.key);
        if(cmp<0)return get(key,curr.left);
        else if(cmp>0)return get(key,curr.right);
        else return curr.val;
    }

    public void put(Key key,Value val){
        root=put(key,val,root);
    }
    private Node put(Key key,Value val,Node curr){
        if(curr==null)return new Node(key,val,1);

        int cmp=key.compareTo(curr.key);
        if(cmp<0)curr.left=put(key,val,curr.left);
        else if(cmp>0)curr.right=put(key,val,curr.right);
        else curr.val=val;
        curr.N=size(curr.left)+size(curr.right)+1;

        return curr;
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node curr){
        if(curr.right==null)return curr;
        return max(curr.right);
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node curr){
        if(curr.left==null)return curr;
        return min(curr.left);
    }
    public Key floor(Key key){
        Node x=floor(key,root);
        if(x==null)return null;
        return x.key;
    }
    public Node floor(Key key,Node curr){
        if(curr==null)return null;
        int cmp=key.compareTo(curr.key);
        if(cmp==0)return curr;
        if(cmp<0)return floor(key,curr.left);
        Node t=floor(key,curr.right);
        if(t!=null)return t;
        else return curr;
    }
    public Key ceiling(Key key){
        Node x=ceiling(key,root);
        if(x==null)return null;
        else return x.key;
    }
    private Node ceiling(Key key,Node curr){
        if(curr==null)return null;
        int cmp=key.compareTo(curr.key);
        if(cmp==0)return curr;
        if(cmp>0)return ceiling(key,curr.right);
        Node t=ceiling(key,curr.left);
        if(t!=null)return t;
        else return curr;
    }
    public Key select(int k){
        return select(k,root).key;
    }
    private Node select(int k,Node curr){
        if(curr==null)return null;
        int t=size(curr.left);
        if(t>k)return select(k,curr.left);
        else if(t<k)return select(k-t-1,curr.right);
        else return curr;
    }
    public int rank(Key key){
        return rank(key,root);
    }
    private int rank(Key key,Node curr){
        if(curr==null)return 0;
        int cmp=key.compareTo(curr.key);
        if(cmp<0)return rank(key,curr.left);
        else if(cmp>0)return 1+size(curr.left)+rank(key,curr.right);
        else return size(curr.left);
    }

    public void delete(Key key){
        root=delete(key,root);
    }
    private Node delete(Key key,Node curr){
        if(curr==null)return null;
        int cmp=key.compareTo(curr.key);
        if(cmp<0)return delete(key,curr.left);
        else if(cmp>0)return delete(key,curr.right);
        else {
            if(curr.left==null)return curr.right;
            if(curr.right==null)return curr.left;
            Node x=curr;
            curr=min(x.right);
            curr.left=x.left;
            curr.right=deleteMin(x.right);
        }
        curr.N=size(curr.left)+size(curr.right)+1;
        return curr;
    }

    public void deleteMin(){    //almost same as put method
        root=deleteMin(root);
    }
    private Node deleteMin(Node curr){
        if(curr.left==null)return curr.right;
        curr.left=deleteMin(curr.left);
        curr.N=size(curr.left)+size(curr.right)+1;
        return curr;
    }
    public void deleteMax(){
        root=deleteMax(root);
    }
    private Node deleteMax(Node curr){
        if(curr.right==null)return curr.left;
        curr.right=deleteMax(curr.right);
        curr.N=size(curr.left)+size(curr.right)+1;
        return curr;
    }
    public Iterable<Key> keys(){
        return keys(min(),max());
    }
    private Iterable<Key> keys(Key li,Key hi){
        Queue<Key> queue=new LinkedList<>();
        keys(root,queue,li,hi);
        return queue;
    }
    private void keys(Node curr,Queue<Key> queue,Key li,Key hi){
        if(curr==null)return;
        int cmpli=li.compareTo(curr.key);
        int cmphi=hi.compareTo(curr.key);
        if(cmpli<0)keys(curr.left,queue,li,hi);
        if(cmpli<=0&&cmphi>=0)queue.offer(curr.key);   //inorder
        if(cmphi>0)keys(curr.right,queue,li,hi);
    }
}
