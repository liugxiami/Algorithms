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

        //List<Integer> path1=findLongestPath(nodes[0],nodes);
        //List<Integer> path2=findLongestPath(nodes[path1.get(path1.size()-1)],nodes);

        List<Integer> path1=findLongestPathBFS(nodes[0],nodes);
        List<Integer> path2=findLongestPathBFS(nodes[path1.get(path1.size()-1)],nodes);

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
        path.push(root.val);                          //用stack比用list方便
        visited.add(root.val);                        //标记是否被访问过
        for(Node child:root.children){
            if(!visited.contains(child.val)){
                dfs(child,nodes,path,max,visited);    //BT总是在判断语句之后进入下一层，保证传入不为空。
            }
        }

        if(path.size()>max.size()){                   //返回时做点事
            max.clear();
            max.addAll(path);
        }

        path.pop();                                   //backtracking的套路
        visited.remove(root.val);
    }

    private List<Integer> findLongestPathBFS(Node root,Node[] nodes){
        List<Integer> res=new ArrayList<>();

        Queue<List<Node>> queue=new LinkedList<>();   //queue里面存的是node的list，不是平常的node；所以需要多些处理
        List<Node> init=new ArrayList<>();
        init.add(root);
        queue.offer(init);

        Set<Integer> visited=new HashSet<>();

        List<Node> result=new ArrayList<>();
        while(!queue.isEmpty()){
            Queue<List<Node>> tempQueue=new LinkedList<>(); //BFS中按层记录
            while(!queue.isEmpty()){
                List<Node> curr=queue.poll();
                Node currNode=curr.get(curr.size()-1);      //list中最后面的node

                result=curr;                                //更新最长路径上的nodes
                visited.add(currNode.val);

                for(Node n:currNode.children){
                    if(!visited.contains(n.val)){
                        List<Node> nextList=new ArrayList<>(curr);
                        nextList.add(n);
                        tempQueue.add(nextList);
                    }
                }
            }
            queue=tempQueue;
        }


        for (int i = 0; i < result.size(); i++) {
           res.add(result.get(i).val);
        }

        return res;
    }

    private Node createIfNotExist(Integer index,Node[] nodes ){
        if(nodes[index]==null){
            nodes[index]=new Node(index);
        }
        return nodes[index];
    }

    public static void main(String[] args) {
        int[][] edges={{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        LC310MinimumHeightTrees MHT=new LC310MinimumHeightTrees();
        List<Integer> result=MHT.findMinHeightTrees(6,edges);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
