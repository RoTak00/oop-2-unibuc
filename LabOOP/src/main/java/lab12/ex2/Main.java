package lab12.ex2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main (String[] args) throws InterruptedException {
        Queue<Message> queue = new ConcurrentLinkedQueue<>();
        String[] usernames = {"Daniel", "Robert", "DeathDemon72", "ManeleLaMaxim27", "AlinusBanus"};

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(int i = 0; i < usernames.length; i++) {
            int finalI = i;
            executorService.submit(()->{
                for(int j = 0; j < 3; ++j)
                {
                    queue.add(new Message("Message " + (j + 1), usernames[finalI]));

                    try
                    {
                        Thread.sleep(200);
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        executorService.shutdown();

        executorService.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Message log");
        queue.forEach(System.out::println);
    }
}
