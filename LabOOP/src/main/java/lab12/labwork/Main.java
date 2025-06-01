package lab12.labwork;

import lab12.labwork.runnable.ParallelRunnable;
import lab12.labwork.thread.ParallelThread;

public class Main {

    public static void main (String[] args) {
        System.out.println("Started main");

//        ParallelThread task1 = new ParallelThread("o_001");
//        ParallelThread task2 = new ParallelThread("o_002");
//        ParallelThread task3 = new ParallelThread("o_003");
//        ParallelThread task4 = new ParallelThread("o_004");
//
//        task1.start();
//        task2.start();
//        task3.start();
//        task4.start();

        ParallelRunnable pr1 = new ParallelRunnable("0_001");
        ParallelRunnable pr2 = new ParallelRunnable("0_002");

        Thread t1 = new Thread(pr1);
        Thread t2 = new Thread(pr2);

        t1.start();
        t2.start();

    }
}
