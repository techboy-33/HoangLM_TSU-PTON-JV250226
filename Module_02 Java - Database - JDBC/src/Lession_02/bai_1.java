package Lession_02;

import java.util.Scanner;

public class bai_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Hãy nhập số nguyên bạn muốn kiểm tra : ");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            if ( number == 0) {
                System.out.printf("Số không phải là số chẵn cũng không phải là số lẻ");
            } else {
                System.out.printf("Số %d là số chẵn", number);
            }
        } else {
            System.out.printf("Số %d là số lẻ", number);
        }
    }
}
