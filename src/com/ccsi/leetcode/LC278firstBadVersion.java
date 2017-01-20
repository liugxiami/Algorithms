package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/19.
 */
public class LC278firstBadVersion extends VersionControl {
    //1.recursion
    public int firstBadVersion(int n){
        return helper(1,n);
    }
    private int helper(int li,int hi){
        if(li>hi)return li;
        int mi=li+(hi-li)/2;
        if(isBadVersion(mi))return helper(li,mi-1);
        else return helper(mi+1,hi);
    }
    //2.loop
    public int firstBadVersion1(int n){
        int li=1,hi=n;
        while(li<=hi){
            int mi=li+(hi-li)/2;
            if(isBadVersion(mi))hi=mi-1;
            else li=mi+1;
        }
        return li;
    }
}
class VersionControl{
    public boolean isBadVersion(int version){
        return true;
    }
}