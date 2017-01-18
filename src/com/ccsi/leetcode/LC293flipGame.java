package com.ccsi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxliu on 2017/1/17.
 */
public class LC293flipGame {
    public static void main(String[] args) {
        String s="++++";
        List<String> res=generatePossibleNextMove(s);
        res.stream().forEach(n-> System.out.println(n)); //lambda表达式
    }

    public static List<String> generatePossibleNextMove(String s){
        List<String> res=new ArrayList<>();
        if(s==null||s.length()<2) return res;

        char[] chars=s.toCharArray();
        int len=s.length();

        for (int i = 0; i < len - 1; i++) {   //因为里面要执行i+1,留出index空位，预防index out of boundary
            if(chars[i]=='+'&&chars[i+1]=='+'){
                chars[i]=chars[i+1]='-';
                res.add(new String(chars));
                chars[i]=chars[i+1]='+';   //注意执行完之后要变回来
            }
        }
        return res;
    }
}
