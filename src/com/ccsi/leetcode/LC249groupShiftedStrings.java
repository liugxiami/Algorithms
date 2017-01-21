package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/1/20.
 */
public class LC249groupShiftedStrings {
    public static void main(String[] args) {
        String[] strings={"abc","def","ac","a","b","df","aaaaf"};
        List<List<String>> result=groupStrings(strings);
        result.forEach((n)-> System.out.println(n));
    }

    public static List<List<String>> groupStrings(String[] strings){
        List<List<String>> result=new ArrayList<>();
        if(strings==null||strings.length==0)return result;

        Map<String,List<String>> map=new HashMap<>();
        for(String str:strings){
            String key=getKey(str);
            if(!map.containsKey(key))map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }

        for(String key:map.keySet()){
            List<String> list=map.get(key);
            result.add(list);
        }
        return result;
    }

    private static String getKey(String str){
        if(str.length()==1)return String.valueOf(0);

        StringBuilder builder=new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            int diff=str.charAt(i)-str.charAt(i-1);
            diff=diff>0?diff:diff+26;
            builder.append(String.valueOf(diff));
        }
        return builder.toString();
    }
}
