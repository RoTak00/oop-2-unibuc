package lab9.ex1;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main (String[] args) {

        Box<Integer> intBox = new Box<>(5);

        intBox.peek();

        intBox.setValue(3);

        intBox.peek();

        Box<String> stringBox = new Box<>("Hello");
        stringBox.peek();

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("C");
        list.add("Scala");
        list.add("Rust");

        int n = 10;
        String nth = ListHelper.getNth(list, n);
        System.out.println("Element at index " + (n - 1) + " is " + nth);


        ItemManager<Book> bookManager = new ItemManager<>();

        bookManager.add(new Book(), "Robert's Book");
        bookManager.add(new Book(), "Robert's Other Book");
        bookManager.add(new Book(), "Book found on the floor");

        bookManager.list();

        List<Item> packages = new ArrayList<>();
        packages.add(new Laptop());
        packages.add(new Book());
        packages.add(new Book());

        PostOffice.transfer(packages);


        Queue<String> ticketPeople = new LinkedList<>();

        ticketPeople.add("Robert");
        ticketPeople.add("Daniel");
        ticketPeople.add("Ana");

        System.out.println(ticketPeople.peek());

        System.out.println(ticketPeople.remove() + " has passed");


        Deque<String> plates = new ArrayDeque<>();

        plates.push("White plate");
        plates.push("Black plate");
        plates.add("Red plate");
        plates.add("Green plate");

        System.out.println("Plate at top is " + plates.peekFirst());
        System.out.println("Plate at bottom is " + plates.peekLast());

    }
}