package Lession_01;

import java.util.Scanner;

public class Bai_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều dài : ");
        float height = scanner.nextFloat();
        System.out.print("Nhập chiều rộng : ");
        float width = scanner.nextFloat();

        float area = width * height;
        float circumference  = (width + height) * 2;

        System.out.printf("Diện tích: %.2f %n", area);
        System.out.printf("Chu vi: %.2f", circumference);
    }
}
