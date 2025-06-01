package lab12.labwork.racecondition.ex2.sol1;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionSolution1 {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 1000; ++i)
            {
                list.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 1000; ++i)
            {
                list.add(i);
            }
        });

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println(list.size());

    }
}
