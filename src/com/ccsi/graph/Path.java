package com.ccsi.graph;

import java.util.*;

/**
 * Created by gxliu on 2016/12/19.
 */
public class Path {
    private static class Node{
        String name;
        List<Node> children;
        List<Integer> weights;

        public Node(String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.weights = new ArrayList<>();
        }
    }

    private Set<String> set=new HashSet<>();   //isVisited
    private int min=Integer.MAX_VALUE;

    public int graphDFSmin(Node root,String target){
        graphDFSmin(root,target,0,0);
        return min;
    }
    private void graphDFSmin(Node curr,String target,int total,int weight){    //total==total weight; weight==currNode.weight
        total+=weight;

        if(target.equals(curr.name)){     //curr Node is the target
            //total+=weight;
            min=Math.min(min,total);
            return;
        }

        //total+=weight;
        set.add(curr.name);   //总是在进入下一层时加入set，标记为已访问
        for (int i = 0; i < curr.children.size(); i++) {   //此处用for loop而不用 foreach，因为与顺序有关
            Node temp=curr.children.get(i);                //arraylist 用get（index）
            int currWeight=curr.weights.get(i);
            if(!set.contains(temp.name)){
                graphDFSmin(temp,target,total,currWeight);
            }
        }
        set.remove(curr.name);  //note:remember remove  返回上一层是吐出
    }

    public int minimun(){
        return min;
    }

    public static void main(String[] args) {
        Node a=new Node("A");
        Node b=new Node("B");
        Node c=new Node("C");
        Node d=new Node("D");
        Node e=new Node("E");
        Node f=new Node("F");

        a.children.add(b);
        a.weights.add(1);
        a.children.add(c);
        a.weights.add(12);

        b.children.add(c);
        b.weights.add(9);
        b.children.add(d);
        b.weights.add(3);

        c.children.add(e);
        c.weights.add(5);

        d.children.add(c);
        d.weights.add(4);
        d.children.add(e);
        d.weights.add(13);
        d.children.add(f);
        d.weights.add(15);

        e.children.add(f);
        e.weights.add(4);

        Path p=new Path();
        p.graphDFSmin(a,"D");
        System.out.println(p.minimun());

    }
}
