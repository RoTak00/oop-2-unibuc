package lab9.ex1;

public class Laptop extends Item {

    public Laptop()
    {
        this.type = "Laptop";
    }

    @Override
    public void use()
    {
        System.out.println("You are typing on the laptop");
    }



}
