package lab12.labwork.racecondition.ex1;

public class Main {

    public static void main(String[] args) {

        InitialRaceCondition raceCondition = new InitialRaceCondition();

        Thread t1 = new Thread()
        {
            @Override
            public void run()
            {
                for(int i = 0; i < 10000; ++i)
                {
                    raceCondition.increase();
                }
            }
        };

        Thread t2 = new Thread()
        {
            @Override
            public void run()
            {
                for(int i = 0; i < 10000; ++i)
                {
                    raceCondition.increase();
                }
            }
        };

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        System.out.println(raceCondition.getVal());
    }
}
