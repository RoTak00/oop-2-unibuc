package lab4.ex2;

import java.util.ArrayList;
import java.util.List;

public class School {

    private Student[] students;
    private Classroom[] classrooms;
    private Schedule schedule;


    public School(Student[] students) {

        this.students = students;

        this.classrooms = new Classroom[2];
        this.classrooms[0] = new Classroom("R00");
        this.classrooms[1] = new Classroom("R01");

        this.schedule = new Schedule(this.classrooms);
    }

    public Student[] getStudents() {
        return students;
    }

    public Classroom[] getClassrooms() {
        return classrooms;
    }

    public Schedule getSchedule() {
        return schedule;
    }


}
