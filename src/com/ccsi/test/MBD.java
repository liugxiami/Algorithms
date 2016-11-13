package com.ccsi.test;

/**
 * Created by gxliu on 2016/11/10.
 */
public class MBD {
    public static void main(String[] args) {
        System.out.println(mbdivider(100,75));
    }
    public static int mbdivider(int a,int b){
        return a%b==0?b:mbdivider(b,a%b);
    }
}
