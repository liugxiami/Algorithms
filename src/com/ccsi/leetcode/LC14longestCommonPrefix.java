package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/5.
 */
public class LC14longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs={"abcdefg","cccjjj","abcdepp","abcdefp"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs){
        if(strs==null&&strs.length==0)return "";
        int maxLen=strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            maxLen=strs[i].length()>maxLen?maxLen:strs[i].length();
            for (int j = 0; j < maxLen; j++) {
               if(strs[i].charAt(j)!=strs[0].charAt(j)){
                   maxLen=j;
                   break;
               }
            }
        }
        return maxLen==0?"":strs[0].substring(0,maxLen);
    }
}
