package lab9.ex1;

import java.awt.print.Printable;
import java.util.List;

public class PostOffice {

    public static void transfer(List<? extends Item> packages)
    {
        for (Item p : packages) {
            System.out.println("Sending " + p.toString());
        }
    }
}
