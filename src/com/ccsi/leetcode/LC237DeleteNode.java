package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/21.
 */
public class LC237DeleteNode {
    public static void deleteNode(ListNode node){
        if(node==null)return;
        ListNode next=node.next;
        if(next!=null){
            node.val=next.val;
            node.next=next.next;
        }else node=null;
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
