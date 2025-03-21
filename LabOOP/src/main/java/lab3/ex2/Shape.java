package lab3.ex2;

import java.util.HashMap;

abstract class Shape {
    public String color;
    public Shape(String color){
        this.color = color;
    }

    public abstract String getType();
    public abstract double getArea();


    public static void countShapeTypesOfArray(Shape[] shapes)
    {
        HashMap<String, Integer> shapesMap = new HashMap<String, Integer>();

        for(Shape shape : shapes)
        {
            if(shapesMap.containsKey(shape.getType()))
            {
                int count = shapesMap.get(shape.getType()) + 1;
                count++;
                shapesMap.put(shape.getType(), count);
            }
            else
            {
                shapesMap.put(shape.getType(), 1);
            }
        }

        for(String shape : shapesMap.keySet())
        {
            System.out.println(shape + " " + shapesMap.get(shape));
        }
    }

    public static void findAndPrintMaxAreaShape(Shape[] shapes)
    {
        Shape maxShape = shapes[0];

        for(Shape shape : shapes)
        {
            if(shape.getArea() > maxShape.getArea())
                maxShape = shape;
        }

        System.out.println("The " + maxShape.getType() + " in the array is the largest");
    }

    public static Shape findShapeByColor(String color, Shape[] shapes)
    {
        for(Shape shape : shapes)
        {
            if(shape != null && shape.color.equals(color))
            {
                return shape;
            }
        }

        return null;
    }
}
