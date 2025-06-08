package Session_11.bai_3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputData {
    public static String getString (Scanner scanner, String suggest) {
        String input ="";
        do {
            System.out.print(suggest);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Không được để trống !");
            }else {
                break;
            }
        }while (true);
        return input;
    }

    public static LocalDateTime getDate(Scanner scanner , String suggest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        do {
            System.out.print(suggest);
            String input = scanner.nextLine();
            try {
                return LocalDateTime.parse(input+ " 00:00",formatter);
            }catch (Exception e) {
                System.out.println("Xin hãy nhập đúng định dạng dd-MM-yyyy");
            }
        }while (true);
    }
}
