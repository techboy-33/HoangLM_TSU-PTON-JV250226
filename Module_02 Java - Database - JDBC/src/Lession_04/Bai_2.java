package Lession_04;

import java.util.Scanner;

public class Bai_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        int arrayItem = scanner.nextInt();
        int [] arr = new int [arrayItem];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Hãy nhập phần tử thứ %d : ", i + 1);
            arr[i] = scanner.nextInt();
        }
        int total = myMethord(arr);
        System.out.printf("Tổng các phần tử trong mảng là: %d", total);

    }

    public static int myMethord (int [] array) {
        int sum = 0;
        for (int item : array) {
            sum += item;
        }
        return sum;
    }
}
