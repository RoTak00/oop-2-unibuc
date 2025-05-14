package lab9.ex1;

public class Box<T> {
    private T value;

    public Box(T value) {
        System.out.println("Created a box with value " + value);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void peek()
    {
        System.out.println("Value in the box is " + value);
    }



}
