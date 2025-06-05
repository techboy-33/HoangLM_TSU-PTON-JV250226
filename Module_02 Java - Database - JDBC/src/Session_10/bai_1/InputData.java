package Session_10.bai_1;

import java.util.Scanner;

public class InputData {
    public static String getString(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Vui lòng không để trống");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int getInt(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            try {
                if (input.isEmpty()) {
                    System.out.println("Vui lòng không để trống");
                } else if (Integer.parseInt(input) < 0) {
                    System.out.println("Vui lòng nhập số nguyên >= 0 !");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên >= 0 !");
            }
        } while (true);
        return Integer.parseInt(input);
    }

    public static double getDouble (Scanner scanner,String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            try {
                if (input.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống");
                } else if (Double.parseDouble(input) < 0) {
                    System.out.println("Vui lòng nhập số thực >= 0 ");
                } else {
                    break;
                }
            }catch (Exception e){
                System.out.println("Vui lòng nhập số thực >= 0 ");
            }
        }while (true);
        return Double.parseDouble(input);
    }
}
