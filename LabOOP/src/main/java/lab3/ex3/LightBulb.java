package lab3.ex3;

public class LightBulb extends Appliance {
    public String color;
    public LightBulb(int power, String color)
    {
        super(power);
        this.color = color;
    }

    public String getType()
    {
        return "LightBulb";
    }
}
