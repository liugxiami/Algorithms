package com.ccsi.test;

/**
 * Created by gxliu on 2016/11/7.
 */
//一个乱序的数组，非常巨大，里面重复的数字很多，范围0-100，找出中间值

public class findMid {
    public static void main(String[] args) {
       int[] a={1,2,3,4,5,7,8,9,1,2,4,2,5,6,3,22};
        int mid=findMidVal(a);
        System.out.println(mid);
    }
    public static Integer findMidVal(int[] a){
        if(a==null||a.length==0)return null;
        int max=100;
        int[] bucket=new int[max];
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        int counter=a.length/2;
        for (int i = 0; i < max; i++) {
            int temp=bucket[i];
            while(temp-->0){
                counter--;
                if(counter==0)return i;
            }
        }
        return null;
    }

}
