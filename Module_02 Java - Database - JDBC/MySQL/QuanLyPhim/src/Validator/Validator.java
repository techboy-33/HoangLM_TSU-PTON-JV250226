package Validator;

import utils.ConnectionDB;
import java.util.Scanner;

public class Validator {
    public static String getString(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Can not blank !");
            } else {
                break;
            }
        } while (true);
        return input;
    }

    public static int getInt(Scanner scanner, String suggest) {
        String input = "";
        do {
            input = getString(scanner, suggest);
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Can not parse number !");
            }
        } while (true);
    }

}
