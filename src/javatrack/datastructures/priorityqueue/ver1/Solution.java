package javatrack.datastructures.priorityqueue.ver1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

class Student implements Comparable<Student>{
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    public int compareTo(Student s2) {
        return Comparator.comparingDouble(Student::getCGPA).reversed()
                .thenComparing(Student::getName)
                .thenComparingInt(Student::getID).compare(this, s2);
    }
}

class Priorities {

    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>();
        List<Student> students = new ArrayList<>();

        for(String event : events){
            if("SERVED".equals(event)) {
                queue.poll();
            } else if (event.startsWith("ENTER")){
                String[] data = event.split(" ");
                Student student = new Student(Integer.parseInt(data[3]), data[1], Double.parseDouble(data[2]));
                queue.add(student);
            } else {
                throw new RuntimeException("F*ck hacker rank and their ugly exercises");
            }
        }
        while(!queue.isEmpty()) {
            students.add(queue.poll());
        }
        return students;
    }
}

/**
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
 */
public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
