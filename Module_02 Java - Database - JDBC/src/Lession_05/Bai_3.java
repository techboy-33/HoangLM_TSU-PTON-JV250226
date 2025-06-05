package Lession_05;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập input : ");
        String input = scanner.nextLine();
        System.out.println(input.replaceAll("[0-9]", "*"));
    }
}
