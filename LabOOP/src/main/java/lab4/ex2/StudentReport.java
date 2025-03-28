package lab4.ex2;

import java.util.stream.Stream;

public class StudentReport extends Report {

    @Override
    public void generate(Object[]... args)
    {
        Student[] student = (Student[]) args[0];

        for(int i = 0; i < student.length; i++)
        {
            int out_index = i + 1;
            builder.append(out_index + ". " + student[i].firstName() + " " + student[i].lastName() + "\n");
        }
    }
}
