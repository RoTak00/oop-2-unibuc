package lab3.ex2;

public class Main {
    public static void main(String[] args)
    {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle("red", 5);
        shapes[1] = new Rectangle("blue", 5, 4);
        shapes[2] = new Triangle("green", 10, 6);

        Shape.countShapeTypesOfArray(shapes);
        Shape.findAndPrintMaxAreaShape(shapes);

        Shape foundShape = Shape.findShapeByColor("blue", shapes);

        if(foundShape != null)
            System.out.println("Found shape with color blue " + foundShape.getType());
        else
            System.out.println("No shape with color blue found");

        for(Shape sh : shapes)
        {
            System.out.println("Shape with color " + sh.color + " (" + sh.getType() + ") has area " + sh.getArea());
        }
    }
}
