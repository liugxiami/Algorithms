package com.ccsi.test;


import java.util.List;

/**
 * Created by gxliu on 2017/1/9.
 */
public class LC23MergeKsortedList {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode mergeKList(ListNode[] lists){
        return mergeKList(lists,0,lists.length-1);
    }
    private static ListNode mergeKList(ListNode[] lists,int start,int end){
        if(start==end)return lists[start];

        int mid=(start+end)/2;
        ListNode node1=mergeKList(lists,start,mid);
        ListNode node2=mergeKList(lists,mid+1,end);

        ListNode node=new ListNode(0);
        ListNode keep=node;

        while(node1!=null&&node2!=null){
            if(node1.val<node2.val){
                node.next=node1;
                node1=node1.next;
            }else{
                node.next=node2;
                node2=node2.next;
            }
            node=node.next;
        }

        if(node1==null){
            node.next=node2;
        }else{
            node.next=node1;
        }

        return keep.next;
    }
}
