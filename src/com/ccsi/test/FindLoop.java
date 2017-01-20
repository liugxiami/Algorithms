package com.ccsi.test;

/**
 * Created by gxliu on 2017/1/18.
 */
public class FindLoop {
    public static void main(String[] args) {
        Node root=buildList();
        Node entry=getEnterCycle(root);
        System.out.println(entry.val);
    }
    public static Node getEnterCycle(Node root){
        if(root==null)return root;
        Node fast=root;
        Node slow=root;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)break;
        }

        //get cycle length
        int cycleLen=0;
        do{
            fast=fast.next;
            cycleLen++;
        }while(slow!=fast);

        Node temp=root;
        while(cycleLen-->0){
            temp=temp.next;
        }

        Node enterNode=root;
        while(temp!=enterNode){
            temp=temp.next;
            enterNode=enterNode.next;
        }

        return enterNode;
    }

    public static Node buildList(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n4;
        return n1;
    }

    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
