package com.ccsi.sorts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxliu on 2016/11/13.
 */
public class StringSortWithBuckets {
    public static void main(String[] args) {
        String[] strings={"ABC","AB","AC","BCD","AAA","BACDE","CD"};
        stringSort(strings);
        for(String s:strings){
            System.out.println(s);
        }
    }
    public static void stringSort(String[] strings){
        if(strings==null||strings.length<=1)return;
        int len=strings.length;
        innerSort(strings,0,len-1,0);
    }
    public static void innerSort(String[] strings,int start,int end,int idx){
        if(start>=end)return;

        int max=27;
        List<String>[] bucket=new ArrayList[max];
        for (int i = 0; i < max; i++) {
            bucket[i]=new ArrayList<>();
        }

        boolean needMoreSort=false;
        for (int i = start; i <=end; i++) {     //从start到end，不是0到size（），递归调用时要更新start和end，重新排的是start和end之间的
            String str=strings[i];
            if(strings[i].length()<=idx){
                bucket[0].add(str);
            }else{
                bucket[str.charAt(idx)-'A'+1].add(str);
                needMoreSort=true;
            }
        }

        if(!needMoreSort)return;

        int idex=0;
        for (int i = 0; i < max; i++) {
            int count=0;
            while(count<bucket[i].size()){
                strings[start+idex++]=bucket[i].get(count++);   //更新该桶里start和end之间的数，不是每次都更新所有的。
            }

            if(start+idex>end)break;
        }

        for (int i = 0; i < max; i++) {
            if(bucket[i].size()>0){           //必须是>0,否则start不能确定
                innerSort(strings,start,start+bucket[i].size()-1,idx+1);
                start+=bucket[i].size();
                bucket[i].clear();
            }
        }
    }
}
