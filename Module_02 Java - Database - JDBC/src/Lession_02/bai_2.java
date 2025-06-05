package Lession_02;

import java.util.Scanner;

public class bai_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập số nguyên từ 1 đến 7 : ");
        System.out.println(" 1 : Chủ nhật \n 2 : Thứ 2 \n 3 : Thứ 3 \n 4 : Thứ 4 \n 5 : Thứ 5 \n 6 : Thứ 6 \n 7 : Thứ 7");
        int number = scanner.nextInt();
        switch (number) {
            case (1):
                System.out.printf("Chủ nhật");
                break;
            case (2):
                System.out.printf("Thứ hai");
                break;
            case (3):
                System.out.printf("Thứ ba");
                break;
            case (4):
                System.out.printf("Thứ tư");
                break;
            case (5):
                System.out.printf("Thứ năm");
                break;
            case (6):
                System.out.printf("Thứ sáu");
                break;
            case (7):
                System.out.printf("Thứ bảy");
                break;
            default:
                System.out.printf("Số nhập vào không hợp lệ");
                break;
        }
    }
}
