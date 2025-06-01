package lab12.labwork.runnable;

public class ParallelRunnable implements Runnable{
    private String orderId;

    public ParallelRunnable(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run()
    {
        System.out.println("[Runnable] Started runnable " + orderId);

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }


        System.out.println("[Runnable] Finished runnable " + orderId);
    }
}
