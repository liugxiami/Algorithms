package com.ccsi.test;

import java.util.*;

/**
 * Created by gxliu on 2016/12/28.
 */
public class LC310MinimumHeightTrees {

    class Node{
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public List<Integer> findMinHeightTrees(int n,int[][] edges){
        List<Integer> res=new LinkedList<>();
        if(n==0)return res;

        int len=edges.length;
        if(len==0){
            if(n==1){
                res.add(0);
                return res;
            }
        }

        //create graph
        Node[] nodes=new Node[n];
        for(int i=0;i<len;i++){
            nodes[edges[i][0]]=createIfNotExist(edges[i][0],nodes);
            nodes[edges[i][1]]=createIfNotExist(edges[i][1],nodes);
            nodes[edges[i][0]].children.add(nodes[edges[i][1]]);
            nodes[edges[i][1]].children.add(nodes[edges[i][0]]);
        }

        List<Integer> path1=findLongestPath(nodes[0],nodes);
        List<Integer> path2=findLongestPath(nodes[path1.get(path1.size()-1)],nodes);

        int size=path2.size();
        if(size%2==0){
            res.add(path2.get(size/2-1));
        }
        res.add(path2.get(size/2));
        return res;
    }

    private List<Integer> findLongestPath(Node root,Node[] nodes){
        Stack<Integer> path=new Stack<>();
        List<Integer> max=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        dfs(root,nodes,path,max,visited);
        return max;
    }

    private void dfs(Node root,Node[] nodes,Stack<Integer> path,List<Integer> max,Set<Integer> visited){
        path.push(root.val);
        visited.add(root.val);
        for(Node child:root.children){
            if(!visited.contains(child)){
                dfs(child,nodes,path,max,visited);
            }
        }

        if(path.size()>max.size()){
            max.clear();
            max.addAll(path);
        }

        path.pop();
        visited.remove(root.val);
    }

    private Node createIfNotExist(Integer index,Node[] nodes ){
        if(nodes[index]==null){
            nodes[index]=new Node(index);
        }
        return nodes[index];
    }


}
