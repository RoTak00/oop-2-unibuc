package lab3.ex2;

public class Circle extends Shape{
    public double radius;
    Circle(String color, double radius)
    {
        super(color);
        this.radius = radius;
    }

    public String getType()
    {
        return "Circle";
    }

    public double getArea()
    {
        return 2 * Math.PI * radius;
    }
}
