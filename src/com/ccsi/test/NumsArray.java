package com.ccsi.test;

/**
 * Created by gxliu on 2016/12/1.
 */
//线段树 segment tree
public class NumsArray {
    public static void main(String[] args) {
        int[] arr={2,5,1,4,9,3};
        NumsArray na=new NumsArray(arr);
        na.update(3,10);
        System.out.println(na.sumRange(0,4));
    }
    private static class Node{
        int start;
        int end;
        int sum;    //特征值
        Node left;
        Node right;
        public Node(int start,int end,int sum){
            this.start=start;
            this.end=end;
            this.sum=sum;
        }
        public Node(int start,int end){
            this(start,end,0);
        }
    }
    private Node root;
    private int[] numbers;
    private Node buildTree(int[] nums,int start,int end){
        if(start==end)return new Node(start,end,nums[start]);
        Node root=new Node(start,end);       //必须声明一个root，非实例参数root；
        int mi=start+(end-start)/2;
        root.left=buildTree(nums,start,mi);
        root.right=buildTree(nums,mi+1,end);
        root.sum=root.left.sum+root.right.sum;   //须将每个节点上的sum计算出来
        return root;
    }

    public NumsArray(int[] nums) {
        if(nums==null||nums.length==0)root=null;
        this.root = buildTree(nums,0,nums.length-1);
        numbers=nums;
    }

    void update(int i, int val){
        int delta=val-numbers[i];
        insert(i,delta,root);     //将差值传进去比较方便
        numbers[i]=val;           //并更新数组
    }

    void insert(int i,int delta,Node curr){
        if(curr.start==curr.end){
            curr.sum=curr.sum+delta;
            return;
        }

        curr.sum=curr.sum+delta;
        int mi=curr.start+(curr.end-curr.start)/2;
        if(i<=mi)insert(i,delta,curr.left);
        else insert(i,delta,curr.right);
    }
    public int sumRange(int i, int j) {
        return query(i,j,root);
    }
    private int query(int start,int end,Node curr){
        if(curr.start==start&&curr.end==end)return curr.sum;
        int mi=curr.start+(curr.end-curr.start)/2;
        if(start<=mi&&end<=mi){
            return query(start,end,curr.left);
        }else if(start<=mi&&end>mi){
            return query(start,mi,curr.left)+query(mi+1,end,curr.right);
        }else{
            return query(start,end,curr.right);
        }
    }
}
