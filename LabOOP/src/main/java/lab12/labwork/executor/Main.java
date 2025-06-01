package lab12.labwork.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Callable<Integer>> execList = new ArrayList<>();

        execList.add(() -> "apple".length());
        execList.add(() -> "orang".length());
        execList.add(() -> "hells".length());
        execList.add(() -> "dasdas".length());

        List<Future<Integer>> results = executorService.invokeAll(execList);

        for (Future<Integer> result : results) {
            System.out.println(result.get());
        }

        Runnable task = () -> System.out.println("I am a runnable");

        executorService.submit(task);

        executorService.shutdown();

    }




}
