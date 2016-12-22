package com.ccsi.test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by gxliu on 2016/12/21.
 */
public class CourseSchedule {
    public class Course{
        int number;
        Set<Integer> pre;  //入度
        Set<Integer> dep;  //出度

        public Course(int number) {
            this.number = number;
            this.pre = new HashSet<>();
            this.dep = new HashSet<>();
        }
    }

    public boolean canFinish(int numCourses,int[][] prerequisites){
        if(numCourses==0||prerequisites==null||prerequisites.length==0)return true;

        final int COUNT=prerequisites.length;

        PriorityQueue<Course> courses=new PriorityQueue<>(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                if(o1.pre.size()>o2.pre.size())return 1;
                else if(o1.pre.size()==o2.pre.size())return 0;
                else return -1;
            }
        });
        Course[] array=new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            Course course=new Course(i);
            array[i]=course;
        }

        for (int i = 0; i < COUNT; i++) {
            int dependsOn=prerequisites[i][0];
            int depends=prerequisites[i][1];     //prerequisites就两元素，前一个是0号，当前元素，后一个是1号，依赖于元素，及father
            array[depends].pre.add(dependsOn);
            array[dependsOn].dep.add(depends);    //谁先谁后是互相依赖的，必定时一对出现
        }

        for (int i = 0; i < numCourses; i++) {
            courses.add(array[i]);                //把每一门课装进priorityQ
        }

        while(!courses.isEmpty()){
            Course c=courses.poll();
            if(c.pre.size()!=0){
                return false;                      //如果吐出来的，即排在最前面的课程的入度不为0，那么无法完成排课
            }
            for(int i:c.dep){
                array[i].pre.remove(c.number);
                courses.remove(array[i]);
                courses.add(array[i]);
            }
        }
        return true;
    }
}
