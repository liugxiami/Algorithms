package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/29.
 */
public class LC157readNCharGiveRead4 {
    //buf是用来存储读进来的数！！！！
    public static int read(char[] buf,int n){
        int top=-1,r=0;
        do{
            char[] temp=new char[4];
            r=read4(temp);
            int len=r<n?r:n;  //n小的时候，说明是n先结束，文件还有，但不用再读了。
            for (int i = 0; i < len; i++) {
                buf[++top]=temp[i];
            }
            n-=r;
        }while(n>0&&r==4);   //如果r<4了，说明文件已经被读到结尾了

        return top+1;
    }
    private static int read4(char[] chars){
        return chars.length; //不对，这个chars是用来储存都进来的数据
    }
}

