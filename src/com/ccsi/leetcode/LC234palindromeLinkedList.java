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

        ListNode mid=findMid(head);

        ListNode after=mid.next;          //后一段list从mid.next开始，保证后一段list是小于（1）等于前一段list。
        mid.next=null;                    //截断前一段list。

        after=LC206ReverseLinkedList.reverseList(after);  //调用同一个package的函数
        ListNode pre=head;

        while(pre!=null&&after!=null){
            if(pre.val!=after.val)return false;           //比较前后两list的值
            else{
                pre=pre.next;
                after=after.next;
            }
        }

        return true;

    }
    private static ListNode findMid(ListNode head){    //快指针从head还是head.next开始，结果一样。
        if(head==null||head.next==null)return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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
