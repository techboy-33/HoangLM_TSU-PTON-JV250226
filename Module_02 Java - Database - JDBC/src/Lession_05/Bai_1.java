package Lession_05;

import java.util.Scanner;

public class Bai_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi : ");
        String inputStr = scanner.nextLine();
        System.out.print("Nhập từ cần tìm : ");
        String search = scanner.nextLine();
        if (inputStr.contains(search)) {
            System.out.printf("Từ \"%s\" xuất hiện tại vị trí %d trong chuỗi.",search, inputStr.indexOf(search)-1);
        }else {
            System.out.printf("không tìm thấy từ %s trong chuỗi.", search);
        }
    }
}
