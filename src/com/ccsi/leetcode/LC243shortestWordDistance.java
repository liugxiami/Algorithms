package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/1/20.
 */
public class LC243shortestWordDistance {
    public static void main(String[] args) {
        String[] words={"practice","makes","perfect","coding","makes"};
        System.out.println(shortestDistance(words,"coding","makes"));
    }
    public static int shortestDistance(String[] words,String word1,String word2){
        if(words==null||words.length==0)return -1;

        Map<String,List<Integer>> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])) map.put(words[i],new ArrayList<>());
            map.get(words[i]).add(i);
        }

        List<Integer> w1=map.get(word1);
        List<Integer> w2=map.get(word2);

        return minDiff(w1,w2);
    }
    private static int minDiff(List<Integer> w1,List<Integer> w2){
        int miniDis=Integer.MAX_VALUE;
        int p=0,q=0;

        while(p<w1.size()&&q<w2.size()){
            int diff=Math.abs(w1.get(p)-w2.get(q));
            miniDis=Math.min(miniDis,diff);

            if(w1.get(p)<w2.get(q))p++;
            else q++;
        }
        return miniDis;
    }
}
