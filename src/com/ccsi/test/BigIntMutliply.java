package com.ccsi.test;

/**
 * Created by gxliu on 2017/1/8.
 */
public class BigIntMutliply {
    public static void main(String[] args) {
        String a="12345678";
        String b="87654321";
        System.out.println(bigIntMutiply(a,b));
    }

    private static String  bigIntMutiply(String X,String Y){
        String result="";
        int len=Math.max(X.length(),Y.length());
        X=numberFormat(X,len);
        Y=numberFormat(Y,len);

        if(len<=4){
            return String.format("%d",Integer.parseInt(X)*Integer.parseInt(Y));
        }

        int len1=len/2;
        int len2=len-len1;

        String A=X.substring(0,len1);
        String B=X.substring(len1);
        String C=Y.substring(0,len1);
        String D=Y.substring(len1);

        String AC=bigIntMutiply(A,C);
        String AD=bigIntMutiply(A,D);
        String BC=bigIntMutiply(B,C);
        String BD=bigIntMutiply(B,D);

        String ADBC=add(AD,BC);

        if(BD.length()>len2){
            ADBC=add(ADBC,BD.substring(0,BD.length()-len2));
        }

        if(ADBC.length()>len2){
            AC=add(AC,ADBC.substring(0,ADBC.length()-len2));
        }

        result=AC+ADBC.substring(ADBC.length()-len2)+BD.substring(BD.length()-len2);
        return result;
    }

    private static String add(String a,String b){
        int len=Math.max(a.length(),b.length());
        String result="";
        int flag=0;
        a=numberFormat(a,len);
        b=numberFormat(b,len);
        for (int i = len-1; i >= 0; i--) {
            int t=flag+(a.charAt(i)-'0')+(b.charAt(i)-'0');
            flag=t/10;
            t%=10;
            result=String.format("%d%s",t,result);
        }
        return flag==1?String.format("%d%s",1,result):result;
    }

    private static String numberFormat(String s,int len){
        StringBuffer temp=new StringBuffer();
        int delta=len-s.length();
        while(delta-->0){
            temp.append("0");
        }
        temp.append(s);
        return temp.toString();
    }
}
