package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/5.
 */
public class LC19removeNthNodeFromEndList {
    public static void main(String[] args) {
        ListNode head=buildLinkList();
        ListNode res=removeNthFromEnd(head,3);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head,int n){
        if(head==null)return head;
        ListNode fast=head;
        ListNode slow=head;
        //fast先走n步
        while(n-->0){
            fast=fast.next;
        }
        //fast和slow同时走知道fast到结束
        while(fast!=null){
            fast=fast.next;
            slow= slow.next;
        }
        //删除slow当前node,一拷一跳
        slow.val=slow.next.val;
        slow.next=slow.next.next;
        return head;
    }

    public static ListNode buildLinkList(){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        return head;
    }
}
