package Lession_02;

import java.util.Scanner;

public class bai_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.printf("Nhập vào 1 số nguyên từ 1 đến 12 (tương ứng với tháng) : ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            switch (n) {
                case (1):
                    System.out.printf("Tháng 1 có 31 ngày");
                    break;
                case (2):
                    System.out.printf("Tháng 2 có 28 hoặc 29 ngày");
                    break;
                case (3):
                    System.out.printf("Tháng 3 có 31 ngày");
                    break;
                case (4):
                    System.out.printf("Tháng 4 có 30 ngày");
                    break;
                case (5):
                    System.out.printf("Tháng 5 có 31 ngày");
                    break;
                case (6):
                    System.out.printf("Tháng 6 có 30 ngày");
                    break;
                case (7):
                    System.out.printf("Tháng 7 có 31 ngày");
                    break;
                case (8):
                    System.out.printf("Tháng 8 có 31 ngày");
                    break;
                case (9):
                    System.out.printf("Tháng 9 có 30 ngày");
                    break;
                case (10):
                    System.out.printf("Tháng 10 có 31 ngày");
                    break;
                case (11):
                    System.out.printf("Tháng 11 có 30 ngày");
                    break;
                case (12):
                    System.out.printf("Tháng 12 có 31 ngày");
                    break;
                default:
                    System.out.printf("Tháng không hợp lệ");
            }
        } else {
            System.out.printf("Dữ liệu nhập vào không phải là số");
        }
    }
}
