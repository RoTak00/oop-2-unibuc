package lab3.ex3;

public abstract class Appliance implements Switchable {
    protected int power;
    protected boolean status;

    public Appliance(int power) {
        this.power = power;
        this.status = false;
    }

    public void turnOn() {
        if (!status) {
            status = true;
            System.out.println(getType() + " turned  ON");
        }
    }

    public void turnOff() {
        if (status) {
            status = false;
            System.out.println(getType() + " turned OFF");
        }
    }

    public boolean getStatus() {
        return status;
    }

    public void toggle() {
        if (status) turnOff();
        else turnOn();
    }

    public void toggle(boolean newStatus)
    {
        if(newStatus) turnOn();
        else turnOff();
    }

    public abstract String getType();
}
