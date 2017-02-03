package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/2.
 */
public class LC38countAndSay {
    public static void main(String[] args) {
        int n=211;
        System.out.println(CountAndSay(n));
    }

    public static String CountAndSay(int n){
        if(n<0)n=-n;
        StringBuilder builder=new StringBuilder();

        int count=0;
        int digit=-1;

        while (n>0){
            int temp=n%10;
            if(temp!=digit){
                if(digit!=-1){   //排除掉第一次
                    builder.append(digit).append(count);
                }
                digit=temp;
                count=1;
            }else{
                count++;
            }

            n/=10;    //循环必要因素
        }

        builder.append(digit).append(count); //注意：最前面的（即最后计算的）在loop里没append到builder上去。

        return builder.reverse().toString();
    }
}
