package Session_11.bai_3;

import java.util.Scanner;

public class InputData {
    public static String getString(Scanner scanner, String name) {
        String input = "";
        do {
            System.out.printf(name);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.printf("Vui lòng không để trống !");
            }
        } while (input.isEmpty());
        return input;
    }

    public static String getEmail(Scanner scanner, String name) {
        String input = "";
        do {
            System.out.printf(name);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Vui lòng không để trống !");
            } else if (!input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                System.out.println("Vui lòng nhập đúng định dạng email (abc@gmail.com)");
            } else {
                break;
            }
        } while (true);
        return input;
    }
}
