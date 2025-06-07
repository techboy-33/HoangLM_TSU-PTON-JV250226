package Session_10.bai_4;

import java.util.Scanner;

public class InputData {
    public static String getString(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.print(suggest);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Không được bỏ trống !");
            } else {
                break;
            }
        } while (true);
        return input;
    }

    public static int getInt(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.print(suggest);
            input = scanner.nextLine();
            try {
                if (input.isEmpty()) {
                    System.out.println("Không được bỏ trống !");
                } else if (Integer.parseInt(input) <= 0) {
                    System.out.println("Không được nhỏ hơn hoặc bằng 0 !");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập một số nguyên dương hợp lệ!");
            }
        } while (true);
        return Integer.parseInt(input);
    }
}
