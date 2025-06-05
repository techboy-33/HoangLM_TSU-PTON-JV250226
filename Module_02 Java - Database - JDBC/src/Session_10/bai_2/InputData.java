package Session_10.bai_2;

import java.util.ArrayList;
import java.util.Scanner;

public class InputData {
    public static String getString(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Vui lòng không để trống !");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int getInt (Scanner scanner, String suggest) {
        String input;
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            try {
                if (input.isEmpty()) {
                    System.out.println("Vui lòng không để trống !");
                } else if (Integer.parseInt(input) <= 0) {
                    System.out.println("Vui lòng nhập năm lớn hơn 0 !");
                } else {
                    break;
                }
            }catch (Exception e){
                System.out.println("Vui lòng nhập năm lớn hơn 0 !");
            }
        }while (true);
        return Integer.parseInt(input);
    }
}
