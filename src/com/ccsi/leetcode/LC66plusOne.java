package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/2/2.
 */
public class LC66plusOne {
    public static void main(String[] args) {
        int[] digits={9,9,9,7};
        int[] res=plusOne1(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] plusOne(int[] digits){
        if(digits==null||digits.length==0)return digits;
        int len=digits.length;
        int flag=0;

        for (int i = len-1; i >=0 ; i--) {
            int temp=digits[i]+flag;
            if(i==len-1)temp+=1;

            flag=temp/10;
            digits[i]=temp%10;
        }

        if(flag==1){
            int[] helper=new int[len+1];
            helper[0]=flag;
            for (int i = 0; i < len; i++) {
                helper[i+1]=digits[i];
            }
            return helper;
        }else return digits;
    }

    //a better method
    public static int[] plusOne1(int[] digits){
        if(digits==null||digits.length==0)return digits;

        int len=digits.length;
        for (int i = len-1; i >=0 ; i--) {
            if(digits[i]<9){
                digits[i]++;
                return digits;  //如果碰到任何一位上不是9，那么加1后必定不会进位，可以结束循环。
            }else digits[i]=0;
        }

        //如果循环完了还没return，说明有最后还有进位，必定是[1,0,0,0...]
        int[] res=new int[len+1];
        res[0]=1;
        return res;
    }
}
