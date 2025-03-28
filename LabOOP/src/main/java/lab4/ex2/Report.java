package lab4.ex2;


public abstract class Report {
    protected StringBuilder builder;

    public Report()
    {
        builder = new StringBuilder();
    }

    public abstract void generate(Object[]... args);

    public void print()
    {
        System.out.println(builder.toString());
    }
}
