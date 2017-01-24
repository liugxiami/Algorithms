package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/1/23.
 */
public class LC223rectangleArea {
    public static void main(String[] args) {
        System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
    }
    //1.顺序是left，bottom，right，top
    //2.判断是否是相交，逆反思维，判断left1>right2,right1<left2,bottom1>top2,top1<bottom2
    //3.相交的话，交点为（大的left,大的bottom），（小的right，小的top），求交叉面积
    //4.面积1+面积2-交叉面积
    //如果用left1，bottom1,right1,top1,left2,bottom2,right2,top2作参数，则更容易理解。
    public static int computeArea(int A,int B, int C,int D,int E,int F,int G,int H){
        int areaA=getArea(A,B,C,D);
        int areaB=getArea(E,F,G,H);
        int area=areaA+areaB;
        if(isIntersected(A,B,C,D,E,F,G,H)){
            int areaC=(Math.min(D,H)-Math.max(B,F))*(Math.min(C,G)-Math.max(A,E));
            area-=areaC;
        }
        return area;

    }

    private static boolean isIntersected(int A,int B, int C,int D,int E,int F,int G,int H){
        if(A>G)return false;
        if(C<E) return false;
        if(B>H) return false;
        if(D<F) return false;
        return true;
    }
    private static int getArea(int left,int bottom,int right,int top){
        return (top-bottom)*(right-left);
    }
}
