package lab3.ex3;

public class Fan extends Appliance {
    public Fan(int power)
    {
        super(power);
    }

    public String getType()
    {
        return "Heating";
    }
}
