package lab11.labwork;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main (String[] args) {

        Animal animal = new Animal()
        {
            @Override
            public void speak()
            {
                System.out.println("Woof!");
            }
        };

        animal.speak();

        System.out.println(animal.getClass().getName());



        IFunctionalInterface fint1 = new IFunctionalInterface() {
            @Override
            public void print(String message) {
                System.out.println(message + " from fint1");
            }
        };

        IFunctionalInterface fint2 = message -> System.out.println(message + " from fint2");

        fint2.print("Hahahaaa ");

        Predicate<String> predicate = s -> s.startsWith("H");

        List<String> strList = List.of("a", "b", "c");

        strList.stream().filter(predicate).forEach(System.out::println);

    }
}
