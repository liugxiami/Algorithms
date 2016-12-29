package com.ccsi.test;

import java.util.*;

/**
 * Created by gxliu on 2016/12/28.
 */
public class LC332ReconstructItinerary {
    Map<String,PriorityQueue<String>> targets=new HashMap<>();
    List<String> path=new LinkedList<>();

    public List<String> findItinerary(String[][] tickets){
        for (String[] ticket:tickets) {
            if(!targets.containsKey(ticket[0])){
                targets.put(ticket[0],new PriorityQueue<>());
            }
            targets.get(ticket[0]).add(ticket[1]);
        }
        visit1("JFK");
        return path;
    }

    void visit(String airport){
        //path.add(airport);
        if(targets.containsKey(airport)&&!targets.get(airport).isEmpty()){
            visit(targets.get(airport).poll());
        }
        path.add(0,airport);    //在递归返回时加入到list的头上，最后排出序。
    }

    void visit1(String airport){
        while(airport!=null){
            path.add(airport);
            airport=targets.get(airport).poll();
        }
    }

    public static void main(String[] args) {
        //String[][] tickets={{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String[][] tickets={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        LC332ReconstructItinerary lc=new LC332ReconstructItinerary();
        List<String> itinerary=lc.findItinerary(tickets);
        for (int i = 0; i < itinerary.size(); i++) {
            System.out.println(itinerary.get(i));
        }
    }
}
