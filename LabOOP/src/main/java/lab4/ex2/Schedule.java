package lab4.ex2;


public class Schedule {
    private Subject[] subjects;

    Schedule(Classroom[] classrooms)
    {
        subjects = new Subject[4];

        subjects[0] = new Subject("E1", "Mathematics", 2, "12:00", classrooms[0]);

        subjects[1] = new Subject("E2", "Computer Science", 2, "14:00", classrooms[0]);

        subjects[2] = new Subject("S1", "Biology", 1, "12:00", classrooms[1]);

        subjects[3] = new Subject("S2", "Chemistry", 1, "13:00", classrooms[0]);


    }

    public Subject[] getSubjects() {
        return subjects;
    }
}
