package Lession_05;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hãy nhập email : ");
        String email = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("Email hợp lệ.");
        }else {
            System.out.println("Email không hợp lệ.");
        }
    }
}
