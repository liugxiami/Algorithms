package com.ccsi.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by gxliu on 2016/11/11.
 */
public class ImplementComparator {
    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        students.add(new Student("Sean",85.5));
        students.add(new Student("Hannah",95.5));
        students.add(new Student("Ella",75.5));
        students.add(new Student("Kim",65.5));
        students.add(new Student("Tim",85.5));

        sortByName(students);

    }

    private static Comparator<Student> cmp=new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return Double.compare(o1.GPA,o2.GPA);
        }
    };

    public static void sortByGPA(List<Student> students){
        Collections.sort(students,cmp);
    }
    public static void sortByName(List<Student> students){
        Collections.sort(students);
    }
}

class Student implements Comparable<Student>{
    public String name;
    public double GPA;

    public Student(String name, double GPA) {
        this.name = name;
        this.GPA = GPA;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}