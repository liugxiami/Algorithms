package com.ccsi.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by gxliu on 2017/1/18.
 */
public class LC288validWordAbbr {
    Map<String,Set<String>> lookup;
    public LC288validWordAbbr(String[] dictinary){
        lookup=new HashMap<>();
        if(dictinary!=null){
            for(String str:dictinary){
                String abbr=getAbbr(str);
                if(!lookup.containsKey(abbr)){
                    lookup.put(abbr,new HashSet<>());
                }
                lookup.get(abbr).add(str);
            }
        }
    }

    private static String getAbbr(String str){
        if(str.length()<=2)return str;

        StringBuilder sb=new StringBuilder();
        sb.append(str.charAt(0))
                .append('[')
                .append(str.length()-2)
                .append(']')
                .append(str.charAt(str.length()-1));
        return sb.toString();
    }

    public boolean isUnique(String word){
        if(word.length()<=2)return !lookup.containsKey(word);
        String abbr=getAbbr(word);
        if(lookup.containsKey(abbr)){
//            if(lookup.get(abbr).contains(word)) return false;
//            else return true;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings={"dear","cart","false","make"};
        LC288validWordAbbr abbr=new LC288validWordAbbr(strings);
        System.out.println(abbr.isUnique("falle"));
    }
}
