package com.ccsi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxliu on 2017/1/15.
 */
public class LC339nestedListWeightSum {
    public static void main(String[] args) {
        Node root=buildTree();
        System.out.println(sum(root));
    }
    public static int sum(Node root){
        if(root==null)return -1;
        return dfs(root,1);
    }
    private static int dfs(Node curr,int level){
        if(curr.children==null)return curr.val*level;
        int sum=curr.val*level;
        for(Node child:curr.children){
            sum+=dfs(child,level+1);
        }
        return sum;
    }
    public static Node buildTree(){
        Node root=new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        root.children.get(1).children.add(new Node(7));
        root.children.get(1).children.add(new Node(8));
        return root;
    }
}
class Node{
    public int val;
    List<Node> children;

    public Node(int val) {
        this.val = val;
        children=new ArrayList<>();
    }
}
