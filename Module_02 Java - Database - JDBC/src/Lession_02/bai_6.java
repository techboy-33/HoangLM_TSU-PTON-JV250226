package Lession_02;

import java.util.Scanner;

public class bai_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Hãy nhập vào chữ số nguyên : ");
        int n = 0;
        int sum = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            if (n < 0) {
                n = -n;
            }
            String strN = Integer.toString(n);
            int length = strN.length();
            for (int i = 0; i < length; i++) {
                sum += Integer.parseInt(String.valueOf(strN.charAt(i)));
            }
            System.out.printf("Tổng các chữ số là : %d", sum);
        } else {
            System.out.printf("Dữ liệu nhập vào không hợp lệ. ");
        }



    }
}
