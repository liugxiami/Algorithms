package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/1/26.
 */
public class LC170twoSumIII {
    List<Integer> data=new ArrayList<>(); //用来保存加入的元素
    Map<Integer,Boolean> cache=new HashMap<>(); //用来保存查看过的元素是否有两数之和
    Boolean isChanged=false;              //很重要，新加元素之后，得重新查，因为可能原来查过为false的在加入新元素之后又存在了。

    public void add(int num){
        data.add(num);
        isChanged=true;
    }

    public boolean find(int value){
        Set<Integer> setDiff=new HashSet<>(); //twoSum，用set的方法来做时的套路
        if(!cache.containsKey(value)||(isChanged&&cache.get(value)==false)){
            //该处的cache.get(value)==false必须写，cache可能为false也可能为true（查过之后）
            for (int i = 0; i < data.size(); i++) {
                int temp=value-data.get(i);           //setDiff中保存的是target和检查过的元素差值
                if(setDiff.contains(data.get(i))){    //检查setDiff中是否包含当前迭代的元素
                    cache.put(value,true);
                }else {
                    cache.put(value,false);
                }
                setDiff.add(temp);
            }
        }
        isChanged=false;
        return cache.get(value);
    }
}
