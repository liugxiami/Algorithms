package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/29.
 */
public class LC160intersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode headA=buildListA();
        ListNode headB=buildListB();
        ListNode res=getIntersectionNode1(headA,headB);
        System.out.println(res==null?"null":res.val);
    }
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null||headB==null)return null;
        ListNode P1=headA;
        ListNode P2=headB;

        int lenA=0,lenB=0;
        while(P1!=null){
            lenA++;
            P1=P1.next;
        }

        while(P2!=null){
            lenB++;
            P2 = P2.next;
        }

        P1=headA;
        P2=headB;
        if(lenA>=lenB){
            int delta=lenA-lenB;
            while(delta-->0){
                P1=P1.next;
            }

            while(lenB-->0){
                if(P1.val==P2.val)return P1;
                P1 = P1.next;
                P2=P2.next;
            }
            return null;
        }else {
            int delta=lenB-lenA;
            while(delta-->0){
                P2=P2.next;
            }

            while(lenA-->0){
                if(P1.val==P2.val)return P1;
                P1 = P1.next;
                P2=P2.next;
            }
            return null;
        }
    }
    public static ListNode getIntersectionNode1(ListNode headA,ListNode headB){
        if(headA==null||headB==null)return null;
        ListNode P1=headA;
        ListNode P2=headB;

        while(P1.next!=null&&P2.next!=null){
            if(P1.val==P2.val)return P1;

            P1=P1.next;
            P2=P2.next;

            if(P1.next==null&&P2.next==null)return null;
            if(P1.next==null)P1.next=headB;          //须用.next，如果P为null，则没有P.next
            if(P2.next==null)P2.next=headA;
        }
        return null;
    }

    public static ListNode buildListA(){
        ListNode root=new ListNode(10);
        root.next=new ListNode(9);
        root.next.next=new ListNode(5);
        root.next.next.next=new ListNode(4);
        root.next.next.next.next=new ListNode(3);
        return root;
    }
    public static ListNode buildListB(){
        ListNode root=new ListNode(8);
        root.next=new ListNode(7);
        root.next.next=new ListNode(6);
        root.next.next.next=new ListNode(2);
        root.next.next.next.next=new ListNode(1);
        //root.next.next.next.next.next=new ListNode(3);
        return root;
    }
}
