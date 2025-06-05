package Lession_03;

import java.util.Scanner;

public class bai_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Hãy nhập vào một số bạn muốn kiểm tra : ");
        int n = scanner.nextInt();
        if (n < 2) {
            System.out.printf("%d không phải là số nguyên tố.", n);
        } else {
            int flag = 0;
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    flag += 1;
                }
            }
            if (flag == 1) {
                System.out.printf("%d là số nguyên tố", n);
            } else {
                System.out.printf("%d không phải là số nguyên tố.", n);
            }

        }
    }
}
