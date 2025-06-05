package Lession_01;

import java.util.Scanner;

public class Bai_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hãy nhập bán kính hình tròn ");
        double r = scanner.nextInt();
        double s = Math.PI*r*r;
        System.out.printf("Diện tích hình tròn có bán kính %.2f là %.2f ", r, s);
    }
}
