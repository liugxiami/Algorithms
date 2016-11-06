package com.ccsi.search;

import java.util.*;

/**
 * Created by gxliu on 2016/11/6.
 */
public class HashSearch {
    private static int hashLength=13;
    private static List<Integer> list=new ArrayList<>(Arrays.asList(13,29,27,28,26,30,18));
    private static int[] hash=new int[hashLength];

    public static void main(String[] args) {
        for (int i = 0; i < list.size(); i++) {
            insertHash(hash,hashLength,list.get(i));  //将listdata插入hash数组
        }

        while (true){
            System.out.println("\nPlease input research data:");
            Scanner scanner=new Scanner(System.in);
            while (scanner.hasNext()){
                int result=Integer.parseInt(scanner.nextLine());
                int index=searchHash(hash,hashLength,result);
                if(index!=-1){
                    System.out.printf("data:"+result+" positon in list is:"+index+"\n");
                }
                else System.out.println("not found.");
            }
        }
    }
    //hashtable 检索数据
    public static int searchHash(int[] hash,int hashLength,int key){
        int hashAddress=key%hashLength;
        while(hash[hashAddress]!=0&&hash[hashAddress]!=key){
            hashAddress=(++hashAddress)%hashLength;
        }
        if(hash[hashAddress]==0)return -1;
        return hashAddress;
    }

    //创建hashtable key与value的对应关系，此次用的是取余结合开放寻址。
    public static void insertHash(int[] hash,int hashLength,int data){
        int hashAddress=data%hashLength;
        while(hash[hashAddress]!=0){
            hashAddress=(++hashAddress)%hashLength;
        }
        hash[hashAddress]=data;
    }
}
