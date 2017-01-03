package com.ccsi.test;

import java.util.Stack;

/**
 * Created by gxliu on 2017/1/2.
 */
public class LC402removeKdigits {
    //1.0
    public static String removeKdigits(String num,int k){
        int len=num.length()-k;
        char[] stk=new char[num.length()];  //建一个栈(用数组来表示为后面除0方便，否则直接用stack来也可以)
        int top=0;                          //表示最顶上
        for (int i = 0; i < num.length(); i++) {
            char c=num.charAt(i);
            while(top>0&&stk[top-1]>c&&k>0){
                top-=1;
                k-=1;
            }

            stk[top++]=c;
        }
        int idx=0;
        while(idx<len&&stk[idx]=='0')idx++;          //除去前面的n个0，如果有的话
        return idx==len?"0":new String(stk,idx,len-idx);
    }
    //2.0
    public static String removeKdigits1(String num,int k){

        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char c=num.charAt(i);
            while(!stack.isEmpty()&&stack.peek()>c&&k>0){
                stack.pop();
                k-=1;
            }
            stack.push(c);
        }

        while(stack.get(0)=='0'){
            stack.remove(0);
        }
        String result="";
        while(!stack.isEmpty()){
            result=stack.pop()+result;
        }
        return result;
    }

    public static void main(String[] args) {
        String s="0001432219";
        System.out.println(removeKdigits(s,3));
    }
}
