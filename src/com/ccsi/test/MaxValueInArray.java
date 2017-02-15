package com.ccsi.test;

/**
 * Created by gxliu on 2017/2/12.
 */
public class MaxValueInArray {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,2,4};
        System.out.println(max3(arr));
    }
    //1.loop
    public static int max(int[] arr){
        if(arr==null||arr.length==0)return -1;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=max>arr[i]?max:arr[i];
        }
        return max;
    }
    //2.recursion
    public static int max1(int[] arr){
        if(arr==null||arr.length==0)return -1;
        return helper(arr,arr.length-1);
    }

    private static int helper(int[] arr,int idx){
        if(idx==0)return arr[0];
        return Math.max(arr[idx],helper(arr,idx-1));
    }
    //3.recursion
    private static int maxVal=Integer.MIN_VALUE;
    public static int max2(int[] arr){
        if(arr==null||arr.length==0)return -1;
        helper2(arr,arr.length-1);
        return maxVal;
    }
    private static void helper2(int[] arr,int idx){
        if(idx<0)return;
        maxVal=Math.max(maxVal,arr[idx]);
        helper2(arr,idx-1);
    }
    //4.binary
    public static int max3(int[] arr){
        if(arr==null||arr.length==0)throw new IllegalStateException("array should not be empty.");
        return helper3(arr,0,arr.length-1);
    }
    private static int helper3(int[] arr,int li,int hi){
        if(li==hi)return arr[li];
        int mi=li+(hi-li)/2;
        return Math.max(helper3(arr,li,mi),helper3(arr,mi+1,hi));
    }
}
