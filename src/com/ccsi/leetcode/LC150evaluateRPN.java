package com.ccsi.leetcode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Stack;

/**
 * Created by gxliu on 2017/1/11.
 * 150. Evaluate Reverse Polish Notation
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 */
public class LC150evaluateRPN {
    public static void main(String[] args) {
        String[] tokens={"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens){
        if(tokens==null||tokens.length==0)return 0;

        Stack<Integer> stack=new Stack<>();

        for (String token:tokens){
            if(isOperator(token)){
                int second=stack.pop();
                int first=stack.pop();
                int third=calculate(first,second,token);
                stack.push(third);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private static int calculate(int first,int second,String op){
        switch (op){
            case "+":
                return first+second;
            case "-":
                return first-second;
            case "*":
                return first*second;
            case "/":
                return first/second;
        }
        return 0;
    }
    private static boolean isOperator(String s){
        return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
    }
}
