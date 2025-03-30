package ui;

import java.util.List;

public class UIHelper {

    public static void printMenu(List<String> options, int start)
    {
        for(int i = 0; i < options.size(); i++)
        {
            System.out.println((i + start) + ". " + options.get(i));
        }
    }

    public static void printLine()
    {
        System.out.println("--- --- --- --- --- ---");
    }

    public static void printTitle(String title)
    {
        System.out.println(" --- --- " + title + " --- ---");
    }
}
