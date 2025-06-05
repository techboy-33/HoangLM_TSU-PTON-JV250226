package Lession_02;

import java.util.Scanner;

public class bai_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Hãy nhập vào 1 số nguyên dương : ");
        int n = scanner.nextInt();
        int sum = 0;
        if (n <= 0) {
            System.out.printf("Số nhập vào không hợp lệ");
        } else {
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.printf("tổng các số từ 1 đến %d = %d", n, sum);
        }
    }
}
