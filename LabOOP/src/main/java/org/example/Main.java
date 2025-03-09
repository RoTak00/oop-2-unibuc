package org.example;

public class Main {
    public static void main(String[] args) {
        float a_float = 10.0f;

        System.out.print(a_float);

        Person p1 = new Person(10);

        p1.print();

        Grandpa g1 = new Grandpa("Danny");

        p1.speak();
        g1.speak();

    }
}

