package Lession_01;

import java.util.Scanner;

public class Bai_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tử số của phân số đầu tiên : ");
        int a = scanner.nextInt();
        System.out.print("Nhập mẫu số của phân số đầu tiên : ");
        int b = scanner.nextInt();
        System.out.print("Nhập tử số của phân số thứ 2 : ");
        int c = scanner.nextInt();
        System.out.print("Nhập mẫu số của phân số thứ 2 : ");
        int d = scanner.nextInt();

        int up = a*d + b*c;
        int down = b*d;

        System.out.printf("Tổng của hai phần số %d/%d + %d/%d = %d/%d",a,b,c,d,up,down);
    }
}
