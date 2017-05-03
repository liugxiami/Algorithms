package com.ccsi.test;

/**
 * Created by gxliu on 2017/1/8.
 */
public class BigIntMutliply {
    public static void main(String[] args) {
        String a="12345678";
        String b="87654321";
        System.out.println(bigIntMultiply(a,b));
    }

    private static String bigIntMultiply(String X,String Y){
        int len=Math.max(X.length(),Y.length());

        //小到一定程度后，直接用int的乘法计算，注意将其解析成int，完了之后再转成string。
        if(len<=4){
            return String.format("%d",Integer.parseInt(X)*Integer.parseInt(Y));
        }

        String result="";
        //将两数拉平，较小的数前面用0填平
        X=numberFormat(X,len);
        Y=numberFormat(Y,len);

        int len1=len/2;      //前一半的长度
        int len2=len-len1;   //后一半的长度，相当于前一半*10^len2

        String A=X.substring(0,len1);
        String B=X.substring(len1);
        String C=Y.substring(0,len1);
        String D=Y.substring(len1);

        //乘法法则，分块处理
        String AC=bigIntMultiply(A,C);
        String AD=bigIntMultiply(A,D);
        String BC=bigIntMultiply(B,C);
        String BD=bigIntMultiply(B,D);

        //处理AD+BC
        String ADBC=add(AD,BC);

        //BD的位数长于len2之后，前面的几位要加到ADBC里面去。
        if(BD.length()>len2){
            ADBC=add(ADBC,BD.substring(0,BD.length()-len2));
        }
        //ADBC的位数要是长于len2的话，要将前面的几位加到AC里面去。
        if(ADBC.length()>len2){
            AC=add(AC,ADBC.substring(0,ADBC.length()-len2));
        }
        //再将AC和ADBC的后len2位和BD的后len2位concatenate起来，这就是结果。
        result=AC+ADBC.substring(ADBC.length()-len2)+BD.substring(BD.length()-len2);
        return result;
    }

    //大数加法，也和重要
    private static String add(String a,String b){
        int len=Math.max(a.length(),b.length());
        String result="";
        int flag=0;  //进位
        //同前的大数乘法，先拉平
        a=numberFormat(a,len);
        b=numberFormat(b,len);
        //从后往前一对一相加，注意进位。
        for (int i = len-1; i >= 0; i--) {
            int t=flag+(a.charAt(i)-'0')+(b.charAt(i)-'0');
            flag=t/10;
            t%=10;
            //数组与字符串的融合
            result=String.format("%d%s",t,result);
        }
        return flag==1?String.format("%d%s",1,result):result;
    }

    //将两数拉平，在短的数前面用0填补
    private static String numberFormat(String s,int len){
        StringBuffer temp=new StringBuffer();
        int delta=len-s.length();
        //注意这步，非常有用。
        while(delta-->0){
            temp.append("0");
        }
        temp.append(s);
        return temp.toString();
    }
}
