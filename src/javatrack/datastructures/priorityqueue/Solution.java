package javatrack.datastructures.priorityqueue;

import java.util.*;

/*
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED

Dan
Ashley
Shafaet
Maria
 */
class Student implements Comparable<Student> {
    private int token;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getToken() {
        return token;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int compareTo(Student that) {
        int first = Double.compare(that.cgpa, this.cgpa);
        if (first == 0) {
            int second = this.fname.compareToIgnoreCase(that.fname);
            if (second == 0) {
                return this.token - that.token;
            } else {
                return second;
            }
        } else {
            return first;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "token=" + token +
                ", fname='" + fname + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());

        //This comparator replaces Student.compareTo() method of Comparable, new in Java 8 so cool!
        Queue<Student> queue = new PriorityQueue<>(Comparator.comparingDouble(Student::getCgpa).reversed()
                .thenComparing(Student::getFname)
                .thenComparingInt(Student::getToken));

        while (totalEvents > 0) {
            String event = in.next();

            if ("ENTER".equals(event)) {
                String name = in.next();
                double cgpa = in.nextDouble();
                int token = in.nextInt();
                queue.add(new Student(token, name, cgpa));
            } else {
                queue.poll();
            }

            totalEvents--;
        }
        if (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                System.out.println(queue.poll().getFname());
            }
        } else {
            System.out.println("EMPTY");
        }
        in.close();
    }
}
