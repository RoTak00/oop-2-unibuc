package ui;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid number. Try again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String getString(String message) {
        System.out.print(message);
        while (!scanner.hasNextLine()) {
            System.out.print("Invalid string. Try again: ");
            scanner.next();
        }
        return scanner.nextLine();
    }
}
