package com.ccsi.sorts;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by gxliu on 2016/11/13.利用快排的思想来做.
 */
public class StringsSort {
    public static void main(String[] args) {
        String[] strings={"ABC","AB","AC","BCD","AAA","BACDE","CD"};
        stringSort(strings);
        for(String s:strings){
            System.out.println(s);
        }
    }
    public static void stringSort(String[] strings){
        if(strings==null||strings.length<=1)return;
        int len=strings.length;
        sort(strings,0,len-1);
    }
    public static void sort(String[] strings,int start,int end){
        if(start>=end)return;
        int pivotIndex=partition(strings, start, end, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String start=(String)o1;
                String end=(String)o2;
                int p=0,q=0;
                while(p<start.length()&&q<end.length()){
                    if(start.charAt(p)>end.charAt(q))return 1;
                    else if(start.charAt(p)<end.charAt(q))return -1;
                    else{
                        p++;
                        q++;
                    }
                }
                if(p==start.length()&&q==end.length())return 0;
                else if(p==start.length())return -1;
                else return 1;
            }
        });
        sort(strings,start,pivotIndex-1);
        sort(strings,pivotIndex+1,end);
    }
    public static int partition(String[] strings, int start, int end, Comparator cmp){
        int ran=new Random().nextInt(end-start)+start;
        swap(strings,start,ran);
        String pivot=strings[start];
        int idx=start+1;
        for (int i = start+1; i <= end; i++) {
            if(cmp.compare(strings[i],pivot)<0){
                swap(strings,i,idx++);
            }
        }
        swap(strings,start,idx-1);
        return idx-1;
    }

    public static void swap(String[] strings,int p,int q){
        if(p==q)return;
        String temp=strings[p];
        strings[p]=strings[q];
        strings[q]=temp;
    }
}
