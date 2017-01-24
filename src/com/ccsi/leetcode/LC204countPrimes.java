package com.ccsi.leetcode;

import java.util.*;
/**
 * Created by gxliu on 2017/1/23.
 */
public class LC204countPrimes {
    public static void main(String[] args) {
        List<Integer> res=recordPrimes(100);
        res.forEach((n)-> System.out.printf("%d->",n));

        System.out.println();
        System.out.println(countPrimes(100));
    }
    public static List<Integer> recordPrimes(int n){
        boolean[] notPrime=new boolean[n+1];  //用primitive type
        int count=0;
        List<Integer> list=new ArrayList<>();
        for (int i = 2; i <=n ; i++) {
            if(notPrime[i])continue;
            count++;
            list.add(i);
            for (int j = 1; j*i <=n ; j++) {
                notPrime[j*i]=true;
            }
        }
        return list;
    }

    public static int countPrimes(int n){
        boolean[] notPrime=new boolean[n+1];  //用primitive type
        int count=0;
        for (int i = 2; i <=n ; i++) {
            if(notPrime[i])continue;
            count++;
            for (int j = 1; j*i <=n ; j++) {
                notPrime[j*i]=true;
            }
        }
        return count;
    }
}
