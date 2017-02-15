package com.ccsi.test;

/**
 * Created by gxliu on 2017/2/12.
 */
public class Sum1ToX {
    public static void main(String[] args) {
        System.out.println(sum1ToX1(100));
    }
    //1.loop
    public static int sum1ToX(int x){
        int sum=0;
        for (int i = 1; i <=x; i++) {
            sum+=i;
        }
        return sum;
    }
    //2.recursion
    public static int sum1ToX1(int x){
        if(x==1)return 1;
        return x+sum1ToX2(x-1);
    }
    //3.binary
    public static int sum1ToX2(int x){
        int[] arr=new int[x+1];
        for (int i = 0; i <= x; i++) {
            arr[i]=i;
        }
        return helper(arr,1,x);
    }
    private static int helper(int[] array,int li,int hi){
        if(li>hi)return 0;
        if(li==hi)return array[li];
        int mi=li+(hi-li)/2;
        return array[mi]+helper(array,li,mi-1)+helper(array,mi+1,hi);
    }
}
