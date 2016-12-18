package com.ccsi.util;

/**
 * Created by gxliu on 2016/12/17.
 */
public class HashMap {
    public class Entry{
        int key;
        Object value;

        public Entry(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
    private Entry[] entries;
    private int capacity=3;
    private int count;

    public HashMap() {
        this.entries = new Entry[capacity];
        this.count = 0;
    }

    public int hashCode(int key){
        return (key*37+key%100/10)%capacity;
    }

    private void resize(){
        Entry[] oldEntries=entries.clone();
        capacity=oldEntries.length*2;
        entries=new Entry[capacity];
        for(Entry e:oldEntries){
            put(e.key,e.value);
        }
    }

    public void put(int key,Object value){
        int index=hashCode(key);

        if(count*2>=capacity){
            resize();
        }

        index%=capacity;
        while(true){
            if(entries[index]==null){
                entries[index]=new Entry(key,value);
                count++;
                return;
            }else if(entries[index].key!=key){
                index++;
            }else{
                entries[index]=new Entry(key,value);
                return;
            }
        }
    }

    private int indexOf(int key){
        int index=hashCode(key);

        int start=index;
        while(true){
            index%=capacity;
            if(entries[index]!=null&&entries[index].key==key){
                return index;
            }else index++;

            if(index==start)return -1;
        }

    }

    public void remove(int key){
        int index=indexOf(key);
        if(index==-1){
            return;
        }

        entries[index]=null;
        count--;
    }

    public boolean contains(int key){
       return indexOf(key)!=-1;
    }

    public boolean isEmpty(){
        return this.count==0;
    }

    public int size(){
        return this.count;
    }

    public static class Student{
        int num;
        String name;

        public Student(int num, String name) {
            this.num = num;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student s1=new Student(10,"Sean");
        Student s2=new Student(21,"Hannah");
        Student s3=new Student(32,"Ella");
        Student s4=new Student(43,"Huiying");

        HashMap map=new HashMap();
        map.put(s1.num,s1);
        map.put(s2.num,s2);
        map.put(s3.num,s3);
        map.put(s4.num,s4);

        System.out.println(map.size());
        map.remove(s1.num);
        System.out.println(map.contains(s2.num));
        System.out.println(map.size());

    }
}
