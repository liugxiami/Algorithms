package com.ccsi.util;

import java.util.Scanner;

/**
 * Created by gxliu on 2016/12/11.
 */
//quick union
public class UnionFind2 {
    private int[] id;   //分量id（以触点作为索引）
    private int count;  //分量数量

    public UnionFind2(int N) {
        this.count = N;
        id=new int[N];
        for (int i = 0; i < N; i++) {    //利用构造函数建立分量，建树（相当于数）
            id[i]=i;
        }
    }
    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    public int find(int v){              //找到相通的（刚开始是自己）;通过改变索引来一步一步往下找；索引等不等于value；
        while(v!=id[v]){
            v=id[v];
        }
        return v;
    }
    //quick union
    public void union(int p,int q){      //如果两触点指向相同的另外一个触点，什么也不做，否则，将其中一颗树接到另外一颗树根上。
        int pID=find(p);                 //union总是将一颗树接到另一颗树的根上
        int qID=find(q);

        if(pID==qID)return;

        id[pID]=qID;
        count--;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        UnionFind2 uf=new UnionFind2(N);
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
