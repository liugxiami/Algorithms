package com.ccsi.graph;

/**
 * Created by gxliu on 2016/12/19.
 */
public class Dijkstra {

    public static int dijkstraLength(int[][] graph){
        int len=graph.length;

        int[] dis;
        boolean[] book=new boolean[len];  //记录是否已经确定

        dis=graph[0].clone();    //辅助数组

        for (int i = 0; i < len; i++) {
            int min=Integer.MAX_VALUE;
            int idx=-1;
            for (int j = 0; j < len; j++) {     //找最小值
                if(!book[j]&&dis[j]<min){
                    min=dis[j];
                    idx=j;
                }
            }

            book[idx]=true;                     //确定最短
            for (int j = 0; j < len; j++) {
                if(!book[j]){
                    dis[j]=Math.min(dis[j],dis[idx]+graph[idx][j]);    //关键步骤，
                }
            }
        }
        return dis[len-3];
    }

    public static void main(String[] args) {
        int len=6;
        int[][] graph=new int[len][len];
        int M=100000;
        graph[0]=new int[]{0,1,12,M,M,M};
        graph[1]=new int[]{M,0,9,3,M,M};
        graph[2]=new int[]{M,M,0,M,5,M};
        graph[3]=new int[]{M,M,4,0,13,15};
        graph[4]=new int[]{M,M,M,M,0,4};
        graph[5]=new int[]{M,M,M,M,M,0};

        System.out.println(dijkstraLength(graph));
    }
}
