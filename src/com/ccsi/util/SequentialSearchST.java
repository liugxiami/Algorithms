package com.ccsi.util;

/**
 * Created by gxliu on 2016/12/5.
 */
public class SequentialSearchST<Key,Value> {

    private class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value vla, Node next) {
            this.key = key;
            this.val = vla;
            this.next = next;
        }
    }

    private Node first;
    private int count;

    public Value get(Key key){
        for(Node n=first; n!=null; n=n.next){
            if(key.equals(n.key)){
                return n.val;
            }
        }
        return null;
    }

    public void put(Key key,Value val){
        for(Node n=first;n!=null;n=n.next){
            if(key.equals(n.key)){
                n.val=val;
            }
        }
        first=new Node(key,val,first);  //头上加新node，并指向原来的first；
        this.count++;
    }

    public int size(){
        return count;
    }

    public Key[] keys(){
        Key[] res=(Key[])new Object[count];
        Node curr=first;
        for(int i=0;i<count;i++){
            res[i]=curr.key;
            curr=curr.next;
        }
        return res;
    }

    public boolean delete(Key key){
        Node dummyHead=new Node(null,null,first);
        for(Node n=dummyHead;n!=null;n=n.next){
            if(n.next.key.equals(key)){
                n.next=n.next.next;
                count--;
                return true;
            }
        }
        return false;
    }
}
