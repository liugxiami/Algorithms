package com.ccsi.leetcode;

import java.util.Arrays;

/**
 * Created by gxliu on 2017/2/1.
 */
public class LC88mergeSortedArray {
    public static void main(String[] args) {
        int[] nums1={1,3,5,7,9,11,12,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] nums2={2,4,6,8};
        merge(nums1,0,nums2,4);
        for (int i = 0; i < 4; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1,int m, int[] nums2,int n){
        if(n==0)return;
        if(m==0){
            for (int i = 0; i < n; i++) {
                nums1[i]=nums2[i];
            }
        }
        else {
            int p=m-1;
            int q=n-1;
            int idx=m+n-1;
            while(p>=0&&q>=0){
                if(nums1[p]>nums2[q])nums1[idx--]=nums1[p--];
                else nums1[idx--]=nums2[q--];
            }

            if(p==0)while(q>=0)nums1[idx--]=nums2[q--];
            if(q==0)while(p>=0)nums1[idx--]=nums1[p--];
        }
    }
}
