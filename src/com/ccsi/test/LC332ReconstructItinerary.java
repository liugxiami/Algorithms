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
        visit("JFK");
        return path;
    }

    void visit(String airport){
        if(targets.containsKey(airport)&&!targets.get(airport).isEmpty()){
            visit(targets.get(airport).poll());
        }
        path.add(0,airport);
    }
}
