package com.ccsi.graph;

import java.util.*;

/**
 * Created by gxliu on 2016/12/15.
 */
public class Graph {
    public static class Node{
        String name;
        List<Node> children;

        public Node(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }
    }

    public void dfs(Node root){
        if(root==null)return;
        System.out.println(root.name);   //pre-order
        for(Node child:root.children){
            dfs(child);
        }
    }

    private Queue<String> pre=new LinkedList<>();
    private Queue<String> post=new LinkedList<>();
    private Stack<String> reversePost=new Stack<>();
    public void dfs1(Node root){
        if(root==null)return;
        pre.offer(root.name);      //preorder
        for(Node child:root.children){
            dfs(child);
        }
        post.offer(root.name);   //post-order
        reversePost.push(root.name);
    }

    //按层打印，双queue
    public void bfs(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            Queue<Node> nextQueue=new LinkedList<>();  //第二个queue
            while(!queue.isEmpty()){
                Node curr=queue.poll();
                System.out.print(curr.name+" ");
                for(Node child:curr.children){
                    nextQueue.offer(child);
                }
            }
            System.out.printf("\tlevel %d", level++);
            System.out.println();
            queue=nextQueue;

        }
    }

    private Set<String> set=new HashSet<>();
    public void graphDfs(Node root){
        if(root==null||set.contains(root.name))return;
        System.out.println(root.name);
        set.add(root.name);
        for(Node child:root.children){
            graphDfs(child);
        }
    }
    public void graphBfs(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        set.add(root.name);
        while(!queue.isEmpty()){
            Queue<Node> nextQueue=new LinkedList<>();
            while(!queue.isEmpty()){
                Node curr=queue.poll();
                System.out.print(curr.name+" ");
                for(Node child:curr.children){
                    if(!set.contains(child.name)){
                        nextQueue.offer(child);
                        set.add(child.name);
                    }
                }
            }
            System.out.println();
            queue=nextQueue;
        }
    }

    //shortest distance
    public int graphBfsShortest(Node root,String target){
        Queue<Node> queue=new LinkedList<>();
        int layer=0;
        queue.offer(root);
        set.add(root.name);
        while(!queue.isEmpty()){
            Queue<Node> nextQueue=new LinkedList<>();
            while(!queue.isEmpty()){
                Node curr=queue.poll();
                System.out.println(curr.name);
                if(curr.name==target){
                    return layer;
                }
                for(Node child:curr.children){
                    if(!set.contains(child.name)){
                        nextQueue.offer(child);
                        set.add(child.name);
                    }
                }
            }
            layer++;
            queue=nextQueue;
        }
        return -1;
    }

    public static void main(String[] args) {
        Node a=new Node("A");
        Node b=new Node("B");
        Node c=new Node("C");
        Node d=new Node("D");
        Node e=new Node("E");
        Node f=new Node("F");

//        a.children.add(b);
//        a.children.add(c);
//        a.children.add(d);
//        c.children.add(e);
//        c.children.add(f);
//
//        Graph g=new Graph();
//        g.bfs(a);

        a.children.add(d);
        a.children.add(f);
        b.children.add(c);
        c.children.add(b);
        c.children.add(d);
        d.children.add(c);
        d.children.add(a);
        d.children.add(e);
        e.children.add(d);
        e.children.add(f);
        f.children.add(a);
        f.children.add(e);

        Graph g=new Graph();
        System.out.println(g.graphBfsShortest(a,"A"));
    }
}
