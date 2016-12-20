package com.ccsi.test;

import java.util.*;

/**
 * Created by gxliu on 2016/12/18.
 */
public class LRUCache1 {
    private LinkedHashMap<Integer,Integer> map;
    private int capacity;
    private int count;

    public LRUCache1(int capacity) {
        this.map = new LinkedHashMap<>();
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Integer value=map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }else return -1;
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        }else{
            if(count==capacity){
                map.remove(map.entrySet().iterator().next().getKey());
                count--;
            }
            map.put(key,value);
            count++;
        }
    }
    public void print(){
        Iterator iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Object key=iterator.next();
            System.out.println(key);
        }

    }

    public static void main(String[] args) {
        LRUCache1 LRU=new LRUCache1(4);
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
