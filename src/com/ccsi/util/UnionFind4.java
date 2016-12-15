package com.ccsi.util;

import java.util.Scanner;

/**
 * Created by gxliu on 2016/12/11.
 */
public class UnionFind4 {
    private int[] id;
    private int[] rank;
    private int count;

    public UnionFind4(int N) {
        this.count=N;
        this.id=new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
        this.rank=new int[N];
        for (int i = 0; i < N; i++) {
            rank[i]=0;
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
    public int find(int v){
        while(v!=id[v]){
            v=id[v];
        }
        return v;
    }
    //height weighted union
    public void union(int p,int q){
        int pID=find(p);
        int qID=find(q);
        if(pID==qID)return;

        if(rank[pID]<rank[qID]){
            id[pID]=qID;
            rank[qID]=Math.max(rank[qID],rank[pID]+1);
        }else{
            id[qID]=pID;
            rank[pID]=Math.max(rank[pID],rank[qID]+1);
        }
        count--;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        UnionFind4 uf=new UnionFind4(N);
        while(scanner.hasNext()){
            int p=scanner.nextInt();
            int q=scanner.nextInt();
            if(uf.connected(p,q))continue;
            uf.union(p,q);
            System.out.println(p+" "+q);
        }
        System.out.println(uf.count+"Components");
    }
}
