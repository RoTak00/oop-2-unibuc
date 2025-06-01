package lab12.labwork.sol1;

public class RaceCondition {
    private int val = 0;

    public synchronized void increase() {
//        synchronized (this) {

            val++;
//        }

    }

    public int getVal() {
        return val;
    }
}
