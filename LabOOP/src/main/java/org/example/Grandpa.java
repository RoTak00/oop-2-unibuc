package org.example;

public class Grandpa extends Person{

    public String name;

    public Grandpa(String name)
    {
        super(70);
        this.name = name;
    }

    public void speak()
    {
        System.out.println("I am " + name + " and I am grandpa");
    }
}
