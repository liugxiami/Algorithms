package com.ccsi.graph;

/**
 * Created by gxliu on 2016/12/20.
 */
public class Floyd {
    public static int floydLength(int[][] graph){
        int len=graph.length;
        int[][] aux=graph.clone();

        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    aux[i][j]=Math.min(aux[i][j],aux[i][k]+aux[k][j]);
                }
            }
        }
        return aux[0][len-3];
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

        System.out.println(floydLength(graph));
    }
}
