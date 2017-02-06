package com.ccsi.leetcode;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by gxliu on 2017/2/5.
 */
public class LC7reverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1234567899));
    }
    public static int reverse(int x){
        int flag=1;
        if(x<0){
            flag=-1;
            x=-x;
        }

        long result=0;
        while(x>0){
            result=result*10+(x%10);
            x/=10;
            if(result>Integer.MAX_VALUE) return 0;
        }

        return (int)result*flag;
    }
}
