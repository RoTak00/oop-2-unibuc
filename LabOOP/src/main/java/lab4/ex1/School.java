package lab4.ex1;

import java.util.ArrayList;
import java.util.List;

public class School {

    private List<Student> students;
    private List<Classroom> classrooms;
    private Schedule schedule;


    public School(String name, List<Student> students) {
        this.students = students;

        this.classrooms = new ArrayList<>();
        this.classrooms.add(new Classroom("R00"));
        this.classrooms.add(new Classroom("R01"));
        this.classrooms.add(new Classroom("R10"));
        this.classrooms.add(new Classroom("R11"));
        this.classrooms.add(new Classroom("R20"));

        this.schedule = new Schedule();
    }

}
