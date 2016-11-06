package com.ccsi.sorts;

import java.util.List;

/**
 * Created by gxliu on 2016/11/6.
 */
public class MergeSortList {
    public static void main(String[] args) {

    }

    class ListNode{
        public int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    private static ListNode head=null;
    private static ListNode tail=null;
    private static int size=0;

    public MergeSortList(int[] a) {
        if(a==null||a.length==0)return;
        for(int i:a){
            if(size==0){
                head=new ListNode(i);
                tail=head;
            }else {
                tail.next=new ListNode(i);
                tail=tail.next;
            }
            size++;
        }
    }

    public static void merge(ListNode head){
        if(size==0||size==1)return;
        ListNode mi=findMid(head);

    }
    public static ListNode findMid(ListNode head){
        if(size==0||size==1)return head;
        ListNode slow=head;
        ListNode fast=head;
        if(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}

