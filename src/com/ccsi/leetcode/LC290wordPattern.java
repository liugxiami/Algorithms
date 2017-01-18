package com.ccsi.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by gxliu on 2017/1/17.
 */
public class LC290wordPattern {
    public static void main(String[] args) {
        String pattern="abba";
        String str="dog dog dog dog";
        System.out.println(wordPattern(pattern,str));
    }

    public static boolean wordPattern(String pattern,String str){
        if(pattern==null&&str==null)return true;
        if(pattern==null||str==null)return false;
        if(pattern.length()==0&&str.length()==0)return true;
        if(pattern.length()==0||str.length()==0)return false;
        String[] strings=str.split(" ");
        int len=strings.length;
        if(pattern.length()!=len)return false;

        Map<Character,String> lookup=new HashMap<>();
        Set<String> keyWords=new HashSet<>();
        for (int i = 0; i < len; i++) {
            char c=pattern.charAt(i);
            if(lookup.containsKey(c)){
                if(!lookup.get(c).equals(strings[i]))return false;
            }else if(keyWords.contains(strings[i])){
                return false;
            }
            lookup.put(c,strings[i]);
            keyWords.add(strings[i]);
        }
        return true;
    }
}
