package com.ccsi.test;

import java.util.*;

/**
 * Created by gxliu on 2017/2/14.
 */
public class NPeopleAndLamp {
    public static void main(String[] args) {
        List<Integer> res=new ArrayList<>();
        res=lampsOn1(100);
        res.forEach(v-> System.out.println(v));
    }
    //1.brute-force, two-loop,lamp%peoper==0->reverse,iterate boolean[] and find true.
    public static List<Integer> lampsOn(int num){
        if(num<=0)return null;
        boolean[] status=new boolean[num];
        for (int peo = 1; peo < num; peo++) {
            for (int lamp = 0; lamp < num; lamp++) {
                if(lamp%peo==0)status[lamp]=!status[lamp];
            }
        }
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if(status[i])res.add(i);
        }
        return res;
    }
    //2.用数学规律，归结为每个数的因素个数奇数偶数问题，所有完全平方数的因素个数为奇数个
    public static List<Integer> lampsOn1(int n){
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            int temp=i*i;
            if(temp<=n){
                res.add(temp);
            }else{
                break;
            }
        }
        return res;
    }
}
