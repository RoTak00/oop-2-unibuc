package lab4.ex2;

public class SchoolSummaryReport extends Report {
    @Override
    public void generate(Object[]... args)
    {

        Student[] students = (Student[]) args[0];

        Classroom[] classrooms = (Classroom[]) args[1];

        Subject[] subjects = (Subject[]) args[2];

        builder.append("Students: \n");
        for(int i = 0; i < students.length; i++)
        {
            int out_index = i + 1;
            builder.append(out_index + ". " + students[i].firstName() + " " + students[i].lastName() + "\n");
        }

        builder.append("\nClassrooms: \n");
        for(int i = 0; i < classrooms.length; i++)
        {
            int out_index = i + 1;
            builder.append(out_index + ". " + classrooms[i].getId() + "\n");
        }

        builder.append("\nSchedule: \n");
        for(int i = 0; i < subjects.length; i++)
        {
            int out_index = i + 1;
            Subject sub = subjects[i];
            builder.append(out_index + ". " + sub.id() + " - " + sub.name() + " (" + sub.time() + " on " + sub.day() + ") in class " + sub.classroom().getId() + "\n");
        }

    }
}
