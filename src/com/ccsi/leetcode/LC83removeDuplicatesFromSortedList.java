package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/2.
 */
public class LC83removeDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(3);
        ListNode res = delelteDuplicates(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode delelteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) curr.next = curr.next.next; //curr指针没跳
            else curr = curr.next;
        }
        return head;
    }
}
