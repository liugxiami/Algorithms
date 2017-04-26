package com.ccsi.test;

import java.util.HashMap;

/**
 * Created by gxliu on 2017/4/7.
 */
public class LRUCache {
    public class Entry{
        int key;
        int value;
        Entry pre,next;

        public Entry(int key,int value) {
            this.key=key;
            this.value = value;
            this.pre=null;
            this.next=null;
        }
    }

    Entry root,tail;
    HashMap<Integer,Entry> map;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        root=null;
        tail=null;
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Entry curr=map.get(key);
            if(curr.pre==null){
                root=root.next;
            }else{
                curr.pre.next=curr.next;
            }

            if(curr.next!=null){
                curr.next.pre=curr.pre;
            }

            tail.next=curr;
            curr.pre=tail;
            curr.next=null;
            tail=curr;

            map.remove(key);
            return curr.value;
        }else return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Entry curr=map.get(key);
            if(curr.pre==null){
                root=root.next;
            }else{
                curr.pre.next=curr.next;
            }

            if(curr.next!=null){
                curr.next.pre=curr.pre;
            }

            map.remove(key);
            count--;
        }else{
            if(count==capacity){
                map.remove(root.key);
                root=root.next;
                root.pre=null;
                count--;
            }
        }

        Entry curr=new Entry(key,value);
        if(root==null){
            root=curr;
            tail=curr;
        }else{
            tail.next=curr;
            curr.pre=tail;
            curr.next=null;
            tail=curr;
        }

        map.put(key,curr);
        count++;
    }

    public void print(){
        while(root!=null){
            System.out.println(root.value);
            root=root.next;
        }
    }

    public static void main(String[] args) {
        LRUCache LRU=new LRUCache(4);
        LRU.put(1,10);
        LRU.put(2,20);
        LRU.put(3,30);
        LRU.put(4,40);
        LRU.get(1);
        LRU.put(5,50);
        LRU.put(6,60);
        LRU.print();
    }
}
