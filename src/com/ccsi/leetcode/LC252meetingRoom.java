package com.ccsi.leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
import java.util.Comparator;

/**
 * Created by gxliu on 2017/1/20.
 */
public class LC252meetingRoom {
    public static void main(String[] args) {
        Interval[] intervals=new Interval[4];
        intervals[0]=new Interval(1,3);
        intervals[1]=new Interval(4,5);
        intervals[2]=new Interval(6,7);
        intervals[3]=new Interval(7,9);

        System.out.println(canAttendMeetings(intervals));

    }
    public static boolean canAttendMeetings(Interval[] intervals){
        if(intervals==null||intervals.length==0)return false;
        Map<Integer,Integer> map=new TreeMap<>();

        for(Interval i:intervals){
            if(map.containsKey(i.start))return false;
            map.put(i.start,i.end);
        }

        int preEnd=-1;
        for(Integer start:map.keySet()){    //greedy
            if(start<preEnd)return false;
            int end=map.get(start);
            if(end>preEnd)preEnd=end;
        }
        return true;
    }
    //2.用Arrays.sort（）函数
    public static boolean canAttendMeetings1(Interval[] intervals){
        if(intervals==null||intervals.length==0)return false;
        int len=intervals.length;
        //Arrays.sort(intervals,(m1,m2)->Integer.compare(m1.start,m2.start));
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start,o2.start);
            }
        });

        for (int i = 1; i < len; i++) {
            if(intervals[i-1].end>intervals[i].start)return false;
        }
        return true;
    }
}
class Interval{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public  Interval(){
        this.start=0;
        this.end=0;
    }
}
