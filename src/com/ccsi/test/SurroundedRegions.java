package com.ccsi.test;

import javafx.geometry.Pos;

/**
 * Created by gxliu on 2016/12/14.
 * union find
 */
public class SurroundedRegions {
    public class Position{
        public int r;
        public int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public class UFElement{
        public Position key;
        public Position parent;
        public int rank;
        public boolean canFlip;

        public UFElement(Position key, Position parent) {
            this.key = key;
            this.parent = parent;
            this.rank = 0;
            this.canFlip = true;
        }
    }
    private UFElement[][] items;    //与传进来的数组一致
    private int count=0;

    private void makeSet(char[][] grid){
        int col_len=grid[0].length;
        items=new UFElement[grid.length][col_len];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < col_len; c++) {
                if(grid[r][c]=='o'){
                    items[r][c]=new UFElement(new Position(r,c),new Position(r,c));
                    count++;
                }
            }
        }
    }

    private Position find(Position num){      //进来的是key，找根（key==parent）
        UFElement curr=items[num.r][num.c];   //UFElement有两position，一个是key，一个是parent
        UFElement ele=curr;
        while(true){
            Position key=curr.key;
            Position parent=curr.parent;      //通过key的传递找到根
            if(parent.r==key.r&&parent.c==key.c){
                ele.parent=parent;            //路径压缩，为以后find的更快。直接将该元素链接到根上
                return parent;
            }
            curr=items[parent.r][parent.c];    //传递的关键步骤，让parent作为key，找到一下一个element。
        }
    }

    private void union(Position p1,Position p2){
        Position parent1=find(p1);
        Position parent2=find(p2);
        if(parent1!=parent2){
            UFElement pEle1=items[parent1.r][parent1.c];
            UFElement pEle2=items[parent2.r][parent2.c];
            if(pEle1.rank<pEle2.rank){
                pEle1.parent=parent2;
            }else if(pEle1.rank>pEle2.rank){
                pEle2.parent=parent1;
            }else{
                pEle1.parent=parent2;
                pEle2.rank++;
            }
            pEle2.canFlip&=pEle1.canFlip;
            pEle1.canFlip&=pEle2.canFlip;       //两元素，只要有一个是不能flip，那么就都不能flip
            count--;
        }
    }
    public void solve(char[][] grid){
        if(grid==null||grid.length==0)return;
        int col_len=grid[0].length;
        if(col_len==0)return;

        makeSet(grid);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < col_len; c++) {
                if(grid[r][c]=='o'){
                    if(r+1>=grid.length||c+1>=col_len||r==0||c==0){
                        Position parent=find(new Position(r,c));
                        items[parent.r][parent.c].canFlip=false;
                    }
                    if(r+1<grid.length&&grid[r+1][c]=='o')
                        union(new Position(r,c),new Position(r+1,c));
                    if(c+1<col_len&&grid[r][c+1]=='o')
                        union(new Position(r,c),new Position(r,c+1));
                }
            }
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < col_len; c++) {
                if(grid[r][c]=='o'){
                    Position parent=find(new Position(r,c));
                    if(items[parent.r][parent.c].canFlip){
                        grid[r][c]='x';
                    }
                }
            }
        }
    }
}
