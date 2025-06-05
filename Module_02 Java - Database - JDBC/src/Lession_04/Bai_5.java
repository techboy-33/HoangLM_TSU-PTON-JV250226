package Lession_04;

import java.util.Scanner;

public class Bai_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập só hàng : ");
        int row = scanner.nextInt();
        System.out.print("Nhập số cột : ");
        int col = scanner.nextInt();
        scanner.nextLine();
        int [][] array = new int [row][col];
        System.out.println("Nhập các phần tử cho mảng (theo từng hàng): ");
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập phần tử hàng %d cột %d : ", i + 1, j + 1);
                array[i][j] = scanner.nextInt();
                if (array[i][j] % 2 == 0) {
                    evenSum += array[i][j];
                } else {
                    oddSum += array[i][j];
                }
            }
        }
        System.out.printf("Tổng các số chẵn là : %d \n", evenSum);
        System.out.printf("Tổng các số lẽ là : %d", oddSum);
    }
}
