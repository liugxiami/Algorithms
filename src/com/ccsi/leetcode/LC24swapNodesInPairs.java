package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/5.
 */
public class LC24swapNodesInPairs {
    public static void main(String[] args) {
        ListNode head=buildList();
        ListNode res=swapPairs(head);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode swapPairs(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;

        ListNode pre=dummyHead;
        ListNode curr=head;

        while(curr!=null&&curr.next!=null){
            ListNode next=curr.next.next;
            curr.next.next=curr;
            pre.next=curr.next;
            curr.next=next;

            pre=curr;
            curr=next;
        }

        return dummyHead.next;
    }

    public static ListNode buildList(){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        return head;
    }
}
