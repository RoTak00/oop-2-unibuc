package lab3.ex2;

public class Rectangle extends Shape{
    public double width, height;
    Rectangle(String color, double width, double height)
    {
        super(color);
        this.width = width;
        this.height = height;
    }

    public String getType()
    {
        return "Rectangle";
    }

    public double getArea()
    {
        return width * height;
    }
}
