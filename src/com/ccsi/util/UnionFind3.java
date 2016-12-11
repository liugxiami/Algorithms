package com.ccsi.util;

/**
 * Created by gxliu on 2016/12/11.
 */
public class UnionFind3 {
    private int[] id;
    private int[] sz;    //额外建一个数组来保存树的大小
    private int count;

    public UnionFind3(int N) {
        this.count=N;
        this.id = new int[N];        //建树
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
        this.sz=new int[N];           //每课树大小都是1，刚开始
        for (int i = 0; i < N; i++) {
            sz[i]=1;
        }
    }

    public int count(){
        return this.count;
    }

    public boolean connected(int p,int q){
        int pID=find(p);
        int qID=find(q);
        return pID==qID;
    }

    public int find(int v){        //和quick union一样
        while(v!=id[v]){
            v=id[v];
        }
        return v;
    }
                                    //总是将小树接到大树的根上
    public void union(int p,int q){
        int pID=find(p);
        int qID=find(q);
        if(connected(p,q))return;

        if(sz[pID]<sz[qID]){
            id[pID]=qID;
            sz[qID]+=sz[pID];
        }else{
            id[qID]=pID;
            sz[pID]+=sz[qID];
        }
        count--;
    }
}
