package com.ccsi.sorts;

public class MergeSortList {
    private static ListNode head=null;
    private static ListNode tail=null;

    public boolean isEmpty(){
        return head==null;
    }

    public ListNode add(int val){
        if(head==null){
            head=new ListNode(val);
            tail=head;
        }else{
            tail.next=new ListNode(val);
            tail=tail.next;
        }
        return head;
    }

    public void display(){
        System.out.println("List items from first to last:");
        ListNode curr=head;
        while(curr!=null){
            curr.displayNode();
            curr=curr.next;
        }
    }

    public ListNode getFirst(){
        return head;
    }

    public ListNode mergeSort(ListNode originalHead) {
        if(originalHead==null||originalHead.next==null)return originalHead;

        ListNode a=originalHead;
        ListNode b=originalHead.next;  //由于后面截断a用的是next，须从next开始，否则前后两半分布不均匀

        while(b!=null&&b.next!=null){   //找中点，分成a，b两lists；
            originalHead=originalHead.next;
            b=b.next.next;
        }
        b=originalHead.next;
        originalHead.next=null;
        return merge(mergeSort(a),mergeSort(b));
    }

    public ListNode merge(ListNode a,ListNode b){
        ListNode dummyHead=new ListNode(Integer.MAX_VALUE);
        ListNode c=dummyHead;
        while(a!=null&&b!=null){
            if(a.val<b.val){
                c.next=a;
                a=a.next;
            }else{
                c.next=b;
                b=b.next;
            }
            c=c.next;
        }
        c.next=(a==null)?b:a;
        head=dummyHead.next;
        return dummyHead.next;
    }
}
class ListNode{
    public int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
    public void displayNode(){
        System.out.println("["+this.val+"]");
    }
}

