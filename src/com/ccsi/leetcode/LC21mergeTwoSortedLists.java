package com.ccsi.leetcode;

import java.util.List;

/**
 * Created by gxliu on 2017/2/5.
 */
public class LC21mergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1=buildList1();
        ListNode l2=buildList2();
        ListNode res=mergeTwoLists1(l2,l1);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    //1.loop
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode dummyHead=new ListNode(-1);
        ListNode p=dummyHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }

        p.next=l1==null?l2:l1;   //必须做尾处理

        return dummyHead.next;
    }
    //2.recursion
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;

        ListNode temp;
        if(l1.val<l2.val){
            temp=l1;
            temp.next=mergeTwoLists1(l1.next,l2);
        }else{
            temp=l2;
            temp.next=mergeTwoLists1(l1,l2.next);
        }
        return temp;
    }

    public static ListNode buildList1(){
        ListNode root=new ListNode(1);
        root.next=new ListNode(3);
        root.next.next=new ListNode(5);
        root.next.next.next=new ListNode(7);
        root.next.next.next.next=new ListNode(9);
        return root;
    }
    public static ListNode buildList2(){
        ListNode root=new ListNode(2);
        root.next=new ListNode(4);
        root.next.next=new ListNode(6);
        return root;
    }
}
