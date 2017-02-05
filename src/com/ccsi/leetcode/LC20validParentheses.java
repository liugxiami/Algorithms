package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/2/5.
 */
public class LC20validParentheses {
    public static void main(String[] args) {
        String s="(ad[b])e{fff}";
        System.out.println(isValid1(s));
    }
    //1.Map and Set, Stack
    public static boolean isValid(String s){
        if(s==null||s.length()==0)return false;

        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Set<Character> set=new HashSet<>();
        set.add('(');
        set.add(')');
        set.add('{');
        set.add('}');
        set.add('[');
        set.add(']');

        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c=s.charAt(i);
            if(set.contains(c)){
                if(!stack.isEmpty()&&stack.peek()==map.get(c)){
                    stack.pop();
                }else stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    //2.isPair and Stack
    public static boolean isValid1(String s){
        if(s==null||s.length()==0)return false;
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character temp=s.charAt(i);
            if("(){}[]".contains(String.valueOf(temp))){
                if(!stack.isEmpty()&&isPair(stack.peek(),temp)){
                    stack.pop();
                }else stack.push(temp);
            }
        }
        return stack.isEmpty();
    }
    private static boolean isPair(Character c1,Character c2){
        if(c1=='('&&c2==')')return true;
        if(c1=='{'&&c2=='}')return true;
        if(c1=='['&&c2==']')return true;
        return false;
    }
}
