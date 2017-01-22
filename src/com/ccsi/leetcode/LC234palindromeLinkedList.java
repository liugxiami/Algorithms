package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/21.
 */
public class LC234palindromeLinkedList {
    public static void main(String[] args) {
        ListNode head=buildLinkedList();
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head){
        if(head==null||head.next==null)return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode after=reverseList(slow);
        ListNode pre=head;

        while(pre!=null&&after!=null){
            if(pre.val!=after.val)return false;
            else{
                pre=pre.next;
                after=after.next;
            }
        }

        return true;

    }
    private static ListNode reverseList(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode pre=head;
        ListNode curr=head.next;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        head.next=null;
        head=pre;

        return head;
    }

    public static ListNode buildLinkedList(){
        ListNode root=new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(2);
        root.next.next.next.next=new ListNode(1);
        //root.next.next.next.next.next=new ListNode(1);
        return root;
    }
}
