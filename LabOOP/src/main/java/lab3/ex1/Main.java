package lab3.ex1;

public class Main {

    public static void main(String[] args)
    {
        Animal[] animals = new Animal[3];

        animals[0] = new Horse();
        animals[1] = new Chicken();
        animals[2] = new Chicken();

        for(int i=0; i<animals.length; i++)
        {
            System.out.print("" + i + ". " + animals[i].getClass() + " (" + animals[i].getName() + ") ");
            animals[i].makeSound();
        }
    }
}
