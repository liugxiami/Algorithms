package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/4.
 */
public class LC28implementStrStr {
    public static void main(String[] args) {
        String haystack="returns the index of the first occurrence";
        String needle="occurrence";
        System.out.println(strStr1(haystack,needle));
    }

    //1.
    public static int strStr(String haystack,String needle){
        if(haystack==null||needle==null)return -1;
        if(haystack.length()==0||needle.length()==0)return -1;
        if(needle.length()>haystack.length())return -1;

        int idx=0;
        int hidx=0,nidx=0;
        int hlen=haystack.length(),nlen=needle.length();
        while(hidx<hlen-nlen&&nidx<nlen){
            while (hidx<hlen-nlen&&haystack.charAt(hidx)!=needle.charAt(nidx))hidx++;
            if(hidx>hlen-nlen)return -1;
            idx=hidx;
            while(hidx<hlen&&nidx<nlen&&haystack.charAt(hidx)==needle.charAt(nidx)){
                hidx++;
                nidx++;
            }

            if(nidx==nlen)return idx;  //此处的nidx+1了，因此不是nlen-1，而是nlen
            else{
                hidx=idx+1;
                nidx=0;
            }
        }
        return -1;
    }
    //2.substring() 比较jiand
    public static int strStr1(String haystack,String needle){
        if(haystack==null||needle==null)return -1;
        if(haystack.length()==0||needle.length()==0)return -1;
        if(haystack.length()<needle.length())return -1;
        int hlen=haystack.length(),nlen=needle.length();
        for (int i = 0; i+nlen <= hlen; i++) {             //此处是<=hlen
            String temp=haystack.substring(i,i+nlen);
            if(temp.contentEquals(needle))return i;
        }
        return -1;
    }

}
