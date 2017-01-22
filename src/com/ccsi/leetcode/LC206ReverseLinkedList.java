package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/21.
 */
public class LC206ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        ListNode res=reverseList(head);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode reverseList(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode p=head;
        ListNode curr=head.next;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=p;
            p=curr;
            curr=next;
        }

        head.next=null;
        head=p;

        return head;
    }
}
