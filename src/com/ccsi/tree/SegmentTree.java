package com.ccsi.tree;

/**
 * Created by gxliu on 2016/12/16.
 * 求区间最小值，最大值，和等等，用线段树
 * 注意，无论是在建树还是在更新树，都要更新特征值，此步容易忘掉
 */
public class SegmentTree {
    public static void main(String[] args) {
        int[] arr={2,5,1,4,9,3};
        SegmentTree na=new SegmentTree(arr);
        na.update(2,10);
        System.out.println(na.minRange(0,3));
    }
    private class Node{
        int min;
        int start;
        int end;
        Node left;
        Node right;

        public Node(int min, int start, int end) {
            this.min = min;
            this.start = start;
            this.end = end;
        }
        public Node(int start,int end){
            this(Integer.MAX_VALUE,start,end);
        }
    }
    private Node root;
    private int[] numbers;
    public SegmentTree(int[] nums){
        if(nums==null||nums.length==0)root=null;
        numbers=nums;
        root=buildSegmentTree(nums,0,nums.length-1);
    }
    //与构建BSTtree类似，但有一步不同，就是更新特征值
    private Node buildSegmentTree(int[] nums,int start,int end){
        if(start==end)return new Node(nums[start],start,end);   //start==end 就是叶子节点，特征值就是相应数组里的值
        int mi=start+(end-start)/2;
        Node root=new Node(start,end);
        root.left=buildSegmentTree(nums,start,mi);
        root.right=buildSegmentTree(nums,mi+1,end);          //left 开始到mi和right则重mi+1开始到end，该性质在query时也要用到
        root.min=Math.min(root.left.min,root.right.min);    //更新特征值
        return root;
    }

    public void update(int i,int val){
        insert(i,val,root);
        numbers[i]=val;
    }

    private void insert(int i,int val,Node curr){
        if(curr.start==curr.end){
            curr.min=val;
            return;    //这个return不能省，为什么？
        }

        int mi=curr.start+(curr.end-curr.start)/2;
        if(i<=mi)insert(i,val,curr.left);
        else insert(i,val,curr.right);

        curr.min=Math.min(Math.min(curr.left.min,curr.right.min),val); //更新特征值
    }
    public int minRange(int i,int j){
        return query(i,j,root);
    }
    private int query(int start,int end,Node curr){
        if(curr.start==start&&curr.end==end)return curr.min;
        int mi=curr.start+(curr.end-curr.start)/2;
        if(start<=mi&&end<=mi)return query(start,end,curr.left);
        else if(start<=mi&&end>mi)return Math.min(query(start,mi,curr.left),query(mi+1,end,curr.right));
        else return query(start,end,curr.right);
    }
}
