package com.ccsi.test;

/**
 * Created by gxliu on 2017/1/19.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7};
        System.out.println(search2(a,8));
    }
    //O(n)
    public static boolean search1(int[] arr,int target){
        if(arr==null||arr.length==0)return false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target)return true;
        }

        return false;
    }
    //O(lg2n) loop
    public static boolean search2(int[] arr,int target){
        if(arr==null||arr.length==0)return false;
        int li=0,hi=arr.length-1;
        while(li<=hi){
            int mi=li+(hi-li)/2;
            if(arr[mi]==target)return true;
            else if(target<arr[mi])hi=mi-1;
            else li=mi+1;
        }
        return false;
    }
    //O(lg2n) recursion
    public static boolean search3(int[] arr,int target){
        if(arr==null||arr.length==0)return false;
        return helper(arr,target,0,arr.length-1);
    }
    private static boolean helper(int[] arr,int target,int li,int hi){
        if(li>hi)return false;
        int mi=li+(hi-li)/2;
        if(arr[mi]==target)return true;
        else if(target<arr[mi]) return helper(arr,target,li,mi-1);
        else return helper(arr,target,mi+1,hi);
    }
}
