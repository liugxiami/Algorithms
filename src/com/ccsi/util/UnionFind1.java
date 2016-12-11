package com.ccsi.util;

import java.util.Scanner;

/**
 * Created by gxliu on 2016/12/10.
 */
//quick find
public class UnionFind1 {
    private int[] id;   //分量id（以触点作为索引）
    private int count;  //分量数量

    public UnionFind1(int N) {
        this.count = N;
        id=new int[N];
        for (int i = 0; i < N; i++) {    //利用构造函数建立分量，自己通自己，共N组
            id[i]=i;
        }
    }
    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    //quick find
    public int find(int v){              //找到相通的（刚开始是自己）
        return id[v];
    }

    public void union(int p,int q){      //如果两触点指向相同的另外一个触点，什么也不做，否则，迭代一遍分量，将每个一组分量指向pID的都指向qID
        int pID=find(p);
        int qID=find(q);

        if(pID==qID)return;

        for (int i = 0; i < id.length; i++) {
            if(id[i]==pID)id[i]=qID;
        }
        count--;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        UnionFind1 uf=new UnionFind1(N);
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
