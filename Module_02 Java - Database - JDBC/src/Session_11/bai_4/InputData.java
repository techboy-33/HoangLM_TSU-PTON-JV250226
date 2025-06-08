package Session_11.bai_4;

import java.util.Scanner;

public class InputData {
    public static String getString(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Please do not leave blank !");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int getInt (Scanner scanner, String suggest) {
        String input;
        do {
            System.out.print(suggest);
            input = scanner.nextLine();
            try {
                if (input.isEmpty()) {
                    System.out.println("Please do not leave blank !");
                } else if (Integer.parseInt(input) <= 0) {
                    System.out.println("Please enter a number greater than 0 !");
                } else {
                    break;
                }
            }catch (Exception e){
                System.out.println("Please enter an integer greater than 0 !");
            }
        }while (true);
        return Integer.parseInt(input);
    }

    public static double getPrice (Scanner scanner, String suggest) {
        String input;
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            try {
                if (input.isEmpty()) {
                    System.out.println("Please do not leave blank !");
                } else if (Integer.parseInt(input) < 0) {
                    System.out.println("Please enter price greater than 0 !");
                } else {
                    break;
                }
            }catch (Exception e){
                System.out.println("Please enter price greater than 0 !");
            }
        }while (true);
        return Double.parseDouble(input);
    }

}
