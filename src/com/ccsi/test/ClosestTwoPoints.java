package com.ccsi.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by gxliu on 2017/1/9.
 */
public class ClosestTwoPoints {
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Point[] p=new Point[6];
        p[0]=new Point(2,3);
        p[1]=new Point(12,30);
        p[2]=new Point(40,50);
        p[3]=new Point(5,1);
        p[4]=new Point(12,10);
        p[5]=new Point(3,4);

        System.out.println("The smallest distance is "+closest(p));
    }
    public static double closest(Point[] points){
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x==o2.x)return o1.y-o2.y;
                else return o1.x-o2.x;
            }
        });

        return closest(points,0,points.length-1);
    }
    private static double closest(Point[] points,int start,int end){
        if(end-start<=3){
            return bruceForce(points,start,end);
        }

        int mid=(start+end)/2;
        Point midPoint=points[mid];

        double d1=closest(points,start,mid);
        double d2=closest(points,mid+1,end);

        double minD=Math.min(d1,d2);

        Point[] newStrip=new Point[end-start+1];
        int idx=0;
        for (int i = start; i <=end ; i++) {
            if(Math.abs(points[i].x-midPoint.x)<minD){
                newStrip[idx++]=points[i];
            }
        }

        minD=Math.min(minD,closest(newStrip,0,idx-1));

        return minD;
    }

    private static double bruceForce(Point[] points,int start,int end){
        double min=Integer.MAX_VALUE;
        for (int i = start; i < end-1; i++) {
            for (int j = start+1; j <end ; j++) {
                min=Math.min(min,distance(points[i],points[j]));
            }
        }
        return min;
    }
    private static double distance(Point p1,Point p2){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }
}
