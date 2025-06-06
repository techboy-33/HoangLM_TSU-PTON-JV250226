package Session_10.bai_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManagement management = new UserManagement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("************ MENU QUẢN LÝ NGƯỜI DÙNG ************");
        System.out.println("1. Thêm người dùng");
        System.out.println("2. Xóa người dùng");
        System.out.println("3. Hiển thị danh sách người dùng");
        System.out.println("4. Thoát");


        do {
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    String name = InputData.getString(scanner, "Nhập tên người dùng: ");
                    String email = InputData.getEmail(scanner, "Nhập email người dùng: ");
                    String phoneNumber = InputData.getString(scanner, "Nhập số điện thoại người dùng: ");
                    User user = new User(name, email, phoneNumber);
                    management.addUser(user);
                    System.out.println("Đã thêm người dùng thành công.");
                    break;
                case 2:
                    String emailDelete = InputData.getString(scanner, "Nhập email người dùng đẻ xóa");
                    if (management.deleteUser(emailDelete)) {
                        System.out.println("Người dùng đã được xóa thành công.");
                    } else {
                        System.out.println("Không tìm thấy người dùng với email này.");
                    }
                    break;
                case 3:
                    management.displayUser();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }
}
