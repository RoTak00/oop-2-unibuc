package lab4.ex2;


public class Main {

    public static void main(String[] args) {

        Student[] students = new Student[4];
        students[0] = new Student("Dan", "Popa");
        students[1] = new Student("Tudor", "Diaconu");
        students[2] = new Student("Andreea", "Daniel");
        students[3] = new Student("Sara", "Toulouse");

        School sch = new School(students);

        StudentReport sr = new StudentReport();
        sr.generate(sch.getStudents());
        sr.print();

        SchoolSummaryReport srr = new SchoolSummaryReport();
        srr.generate(sch.getStudents(), sch.getClassrooms(), sch.getSchedule().getSubjects());
        srr.print();


    }
}
