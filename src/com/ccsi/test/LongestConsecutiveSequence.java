package com.ccsi.test;

import java.util.*;

/**
 * Created by gxliu on 2016/12/14.
 */
public class LongestConsecutiveSequence {

    public class UFElement{
        public int key;
        public int parent;
        public int rank;
        public int size;

        public UFElement(int key, int parent) {
            this.key = key;
            this.parent = parent;
            this.rank = 0;
            this.size = 1;
        }
    }
    private Map<Integer,UFElement> items=new HashMap<>();
    private int max=1;

    private void makeSet(int[] nums){
        for(Integer n:nums){
            items.put(n,new UFElement(n,n));
        }
    }

    private int find(int num){
        UFElement curr=items.get(num);
        UFElement ele=curr;
        while(true){
            int parent=curr.parent;
            if(parent==curr.key){
                ele.parent=parent;
                return parent;
            }
            curr=items.get(parent);
        }
    }
    private void union(int num1,int num2){
        int parent1=find(num1);
        int parent2=find(num2);
        if(parent1!=parent2){
            UFElement pEle1=items.get(parent1);
            UFElement pEle2=items.get(parent2);
            if(pEle1.rank<pEle2.rank){
                pEle1.parent=parent2;
                pEle2.size+=pEle1.size;
            } else if (pEle1.rank > pEle2.rank) {
                pEle2.parent=parent1;
                pEle1.size+=pEle2.size;
            }else{
                pEle1.parent=parent2;
                pEle2.size+=pEle1.size;
                pEle2.rank++;
            }
            max=Math.max(max,Math.max(pEle1.size,pEle2.size));
        }
    }
    public int longestConsecutive(int[] nums){
        makeSet(nums);
        for (Integer num:nums){
            if(items.containsKey(num+1)){
                union(num,num+1);
            }
            if(items.containsKey(num-1)){
                union(num,num-1);
            }
        }
        return max;
    }
}
