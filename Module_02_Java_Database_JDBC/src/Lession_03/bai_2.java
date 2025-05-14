package Lession_03;

import java.util.Scanner;

public class bai_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Cạnh 1 : ");
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            System.out.printf("Cạnh 2 : ");
            if (scanner.hasNextInt()) {
                int b = scanner.nextInt();
                System.out.printf("Cạnh 3 : ");
                if (scanner.hasNextInt()) {
                    int c = scanner.nextInt();
//                    Logic tính toán
                    if (a + b <= c || a + c <= b || b + c <= a || a <= 0 || b <= 0 || c <= 0) {
                        System.out.printf("Ba cạnh không tạo thành tam giác.");
                    } else {
                        if (a == b && b == c) {
                            System.out.printf("Đây là tam giác đều.");
                        } else if (a == b || a == c || b == c) {
                            System.out.printf("Đây là tam giác cân.");
                        } else if (a*a == b*b + c*c || b*b == a*a + c*c || c*c == a*a + b*b) {
                            System.out.printf("Đây là tam giác vuông.");
                        } else {
                            System.out.printf("Đây là tam giác thường.");
                        }
                    }



                } else {
                    System.out.printf("Thông tin nhập vào không chính xác !");
                }
            } else {
                System.out.printf("Thông tin nhập vào không chính xác !");
            }
        } else {
            System.out.printf("Thông tin nhập vào không chính xác !");
        }
    }
}
