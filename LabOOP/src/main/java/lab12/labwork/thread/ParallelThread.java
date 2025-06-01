package lab12.labwork.thread;

public class ParallelThread extends Thread {

    private String orderId;

    public ParallelThread(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("[Thread] Started thread " + orderId);

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }


        System.out.println("[Thread] Finished thread " + orderId);
    }
}
