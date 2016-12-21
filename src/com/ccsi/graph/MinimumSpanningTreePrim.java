package com.ccsi.graph;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.omg.CORBA.TRANSACTION_REQUIRED;

/**
 * Created by gxliu on 2016/12/20.
 */
public class MinimumSpanningTreePrim {
    private static final int V=5;

    //find the vertex with mini key value from the set of vertices not yet included in MST
    public int minKey(int[] keys, boolean[] mstSet){
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for (int i = 0; i < V; i++) {
            if(mstSet[i]==false&&keys[i]<min)
            {
                min=keys[i];
                min_index=i;
            }
        }
        return min_index;
    }

    public void printMST(int[] parent,int n,int graph[][]){
        System.out.println("Edge    Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i]+"-"+i+"      "+graph[i][parent[i]]);
        }
    }

    public void primMST(int[][] graph){
        int[] parent=new int[V];  //Store constructed MST
        int[] keys=new int[V];     //Key values used to pick minimum weight edge in cut
        boolean[] mstSet=new boolean[V]; //To represent set of vertices not yet included in MST;

        for (int i = 0; i < V; i++) {
            keys[i]=Integer.MAX_VALUE;
            mstSet[i]=false;              //initialize all keys as infinite
        }

        keys[0]=0;   //make key 0 so that this vertex is picked as first vertex
        parent[0]=-1; //first cod node is always root of MST

        //The MST will have V vertices
        for (int count = 0; count < V -1; count++) {
            int u=minKey(keys,mstSet);
            mstSet[u]= true;
            for (int v = 0; v <V; v++) {
                if(graph[u][v]!=0&&mstSet[v]==false&&graph[u][v]<keys[v]){
                    parent[v]=u;
                    keys[v]=graph[u][v];
                }
            }
        }
        printMST(parent,V,graph);
    }

    public static void main(String[] args) {
        MinimumSpanningTreePrim t = new MinimumSpanningTreePrim();
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                     {2, 0, 3, 8, 5},
                                     {0, 3, 0, 0, 7},
                                     {6, 8, 0, 0, 9},
                                     {0, 5, 7, 9, 0},
                                    };

        // Print the solution
        t.primMST(graph);
    }
}
