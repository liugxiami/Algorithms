package com.ccsi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gxliu on 2017/1/21.
 */
public class LC242validAnagram {
    public static void main(String[] args) {
        String s="anagram";
        String t="nagarams";
        System.out.println(isAnagram1(s,t));
    }
    //1.map<String,Integer>
    public static boolean isAnagram(String s,String t){
        if(s==null&&t==null)return true;
        if(s==null||t==null)return false;
        if(s.length()==0&&t.length()==0)return true;
        if(s.length()==0||t.length()==0)return false;
        if(s.length()!=t.length())return false;
        int len=s.length();
        Map<Character,Integer> lookup=new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(!lookup.containsKey(c)) lookup.put(c,1);
            else {
                lookup.put(c,lookup.get(c)+1);
            }
        }

        for (int i = 0; i < len; i++) {
            char c=t.charAt(i);
            if(lookup.containsKey(c)){
                int count=lookup.get(c);
                count=count-1;
                lookup.put(c,count);
                if(lookup.get(c)==0)lookup.remove(c);
            }else return false;
        }
        return lookup.isEmpty();
    }
    //2.array[26]
    public static boolean isAnagram1(String s,String t){
        if(s.length()!=t.length())return false;
        int len=s.length();

        int[] map=new int[26];   //every element's value in map is 0;
        for (int i = 0; i < len; i++) {
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(map[i]!=0)return false;
        }
        return true;
    }
}
