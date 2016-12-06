package com.ccsi.util;

/**
 * Created by gxliu on 2016/12/5.
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        this.keys = (Key[])new Comparable[capacity];
        this.values = (Value[])new Object[capacity];
        N = 0;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public Value get(Key key){
        if(isEmpty())return null;
        int i=rank(key);
        if(i<N&&keys[i].compareTo(key)==0)return values[i];
        else return null;
    }
    //关键步骤，利用rank找到位置并更新（如果存在），否则就插入。其实也就是排序的一个过程。
    //rank无论如何会返回表中小于它的键的数量
    public void put(Key key,Value val){
        int i=rank(key);
        if(i<N&&keys[i].compareTo(key)==0){
            values[i]=val;
            return;
        }
        else{
            if(N==keys.length){
                resize(keys.length*2);
            }

            for (int j = N; j >i; j--) {
                keys[j]=keys[j-1];
                values[j]=values[j-1];
            }
            keys[i]=key;
            values[i]=val;
            N++;
        }
    }

    public boolean delete(Key key){
        int i=rank(key);
        if(i<N&&keys[i].compareTo(key)==0){
            for (int j = i; j < N; j++) {
                keys[j]=keys[j+1];
                values[j]=values[j+1];
            }
            N--;
            if(N<keys.length/4)resize(keys.length/2);
            return true;
        }
        return false;
    }

    public int rank(Key key){
        return rank(key,0,N-1);
    }

    private int rank(Key key,int li,int hi){    //rank函数返回的是index 或者说比key值小的key的数量
        if(li>hi)return li;
        int mi=li+(hi-li)/2;
        int cmp=key.compareTo(keys[mi]);
        if(cmp==0)return mi;
        else if(cmp<0)return rank(key,li,mi-1);
        else return rank(key,mi+1,hi);
    }

    private void resize(int k){
        Key[] tempKeys=(Key[]) new Comparable[k];
        Value[] tempValues=(Value[])new Object[k];
        for (int i = 0; i < N; i++) {
            tempKeys[i]=keys[i];
            tempValues[i]=values[i];
        }
        keys=tempKeys;
        values=tempValues;
    }
}
