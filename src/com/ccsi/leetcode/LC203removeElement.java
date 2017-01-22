package com.ccsi.leetcode;


/**
 * Created by gxliu on 2017/1/21.
 */
public class LC203removeElement {
    public static ListNode removeElements(ListNode head,int val){
        if(head==null)return head;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;

        ListNode p=dummyHead;
        while(p!=null){
            if (p.next!=null&&p.next.val==val){
            p.next=p.next.next;
            }
            else{
            p=p.next;
            }
        }

        return dummyHead.next;
    }
}

