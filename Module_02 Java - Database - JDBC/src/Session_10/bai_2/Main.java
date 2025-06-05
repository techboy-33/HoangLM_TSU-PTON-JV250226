package Session_10.bai_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("************** MENU QUẢN LÝ SÁCH *************");
            System.out.println("1. Thêm sách");
            System.out.println("2. Tìm kiếm sách");
            System.out.println("3. Hiển thị danh sách sách");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bản: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    String name = InputData.getString(scanner, "Nhập tên sách: ");
                    String author = InputData.getString(scanner, "Nhập tên tác giả: ");
                    int year = InputData.getInt(scanner, "Nhập năm xuất bản: ");
                    Book book = new Book(name, author, year);
//                    BookManagement.addBook(book);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
            }
        }while (true);
    }
}
