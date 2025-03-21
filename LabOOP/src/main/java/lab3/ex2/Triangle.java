package lab3.ex2;

public class Triangle extends Shape{
    public double base, height;
    Triangle(String color, double base, double height)
    {
        super(color);
        this.base = base;
        this.height = height;
    }

    public String getType()
    {
        return "Triangle";
    }

    public double getArea()
    {
        return base * height * 0.5;
    }
}
