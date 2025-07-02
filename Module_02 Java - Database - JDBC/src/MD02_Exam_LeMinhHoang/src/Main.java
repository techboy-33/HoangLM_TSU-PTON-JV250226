import studentManager.StudentManager;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("********* Student Management ********");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm kiếm sinh viên theo tên");
            System.out.println("6. Sắp xếp sinh viên theo ngày đăng ký");
            System.out.println("7. Thoát");
            System.out.println("Xin hãy nhập vào : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    manager.showStudents();
                    break;
                case 2:
                    manager.addStudent(sc);
                    break;
                case 3:
                    manager.updateStudent(sc);
                    break;
                case 4:
                    manager.deleteStudent(sc);
                    break;
                case 5:
                    manager.searchStudentByName(sc);
                    break;
                case 6:
                    manager.sortDate();
                    break;
                case 7:
                    System.out.println("Tạm biệt !");
                    return;
                default:
                    System.out.println("Hãy chọn menu từ 1-7");
            }
        }
    }
}