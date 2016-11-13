package com.ccsi.test;

public class BoyGirlPair {
    public static void main(String[] args) {
        int[] boys={3,2,4,1,5};
        int[] girls={4,2,1,3,5};
        sort(boys,girls);
        for(int i:boys) System.out.println(i);

        System.out.println();

        for(int i:girls) System.out.println(i);
    }
    public static void sort(int[] boys,int[] girls){
        if(boys==null||girls==null||girls.length!=boys.length)return;
        int[] aux=boys.clone();
        int len=aux.length;
        for (int i = 0; i < len; i++) {
            int pivot=aux[i];
            int p=-1,q=len;
            while(true){
                while(++p<len&&girls[p]<pivot);
                while(--q>=0&&girls[q]>pivot);
                if(p<q){
                    swap(girls,p,q);
                }else break;
            }
            if(q!=i)boys[q]=aux[i];
        }
    }

    public static void swap(int[] a,int p,int q){
        int temp=a[p];
        a[p]=a[q];
        a[q]=temp;
    }
}
