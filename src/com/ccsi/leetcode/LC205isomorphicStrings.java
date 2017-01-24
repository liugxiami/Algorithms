package com.ccsi.leetcode;
import java.util.*;
/**
 * Created by gxliu on 2017/1/23.
 */
public class LC205isomorphicStrings {
    public static void main(String[] args) {
        String s="egg";
        String t="aaa";
        System.out.println(isIsomorphic(s,t));
    }
    public static boolean isIsomorphic(String s,String t){
        if(s==null&&t==null)return true;
        if(s==null||t==null)return false;
        if(s.length()==0&&t.length()==0)return true;
        if(s.length()==0||t.length()==0)return false;
        if(s.length()!=t.length())return false;

        int len=s.length();
        Map<Character,Character> lookup=new HashMap<>();
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < len; i++) {
            if(!lookup.containsKey(s.charAt(i))){
                if(set.contains(t.charAt(i)))return false;
                lookup.put(s.charAt(i),t.charAt(i));
                set.add(t.charAt(i));
            }else{
                Character c=lookup.get(s.charAt(i));
                if(c!=t.charAt(i))return false;
            }
        }
        return true;
    }
}
