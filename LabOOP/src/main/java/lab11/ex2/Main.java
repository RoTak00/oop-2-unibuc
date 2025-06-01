package lab11.ex2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        ICustomPredicate<Integer> pred = n -> n % 5 != 0;

        ICustomConsumer<Integer> cons = n -> System.out.print(n + "! ");

        ICustomFunction<Integer, Integer> fn = n -> n % 7;

        ICustomBifunction<Boolean, Integer, Integer> bfn = (a, b) -> a > b;

        numbers.stream().filter(pred::test).map(fn::apply).forEach(cons::consume);

        int a = 3;
        int b = 7;
        Boolean is_bigger = bfn.apply(a, b);

        if(is_bigger)
        {
            System.out.println("a is bigger than b");
        }
        else
        {
            System.out.println("a is smaller than b");
        }

    }
}
