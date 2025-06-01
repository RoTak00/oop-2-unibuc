package lab12.labwork.sol2;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {
    private AtomicInteger val = new AtomicInteger(0);

    public synchronized void increase() {
        val.incrementAndGet();
    }

    public int getVal() {
        return val.get();
    }
}
