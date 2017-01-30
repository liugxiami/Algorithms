package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/29.
 */
public class LC165compareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.2","13.1"));
    }
    public static int compareVersion(String version1,String version2){
        String[] strVer1=version1.split("\\.");
        String[] strVer2=version2.split("\\.");
        if(Integer.compare(Integer.parseInt(strVer1[0]),Integer.parseInt(strVer2[0]))>0)return 1;
        else if(Integer.compare(Integer.parseInt(strVer1[0]),Integer.parseInt(strVer2[0]))<0)return -1;
        else{
            for (int i = 1; i < Math.min(strVer1.length,strVer2.length) ; i++) {
                String str1=strVer1[i];
                String str2=strVer2[i];

                int len=Math.max(str1.length(),str2.length());
                str1=numberFormat(str1,len);
                str2=numberFormat(str2,len);

                for (int j = 0; j < len; j++) {
                    if(str1.charAt(j)>str2.charAt(j))return 1;
                    else if(str1.charAt(j)<str2.charAt(j))return -1;
                    else continue;
                }
            }
            if(strVer1.length>strVer2.length)return 1;
            else if(strVer1.length<strVer2.length)return -1;
            else return 0;
        }
    }
    private static String numberFormat(String s,int len ){
        StringBuilder builder=new StringBuilder();
        int delta=len-s.length();

        builder.append(s);
        while(delta-->0){
            builder.append('0');
        }
        return builder.toString();
    }
}
