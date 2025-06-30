import bussiness.dao.StudentDaoImpl;
import validator.Validator;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDaoImpl studentManagement = new StudentDaoImpl();
        while (true) {
            System.out.println("1.Hiển thị danh sách sinh viên.\n" +
                    "2.Thêm mới sinh viên.\n" +
                    "3.Sửa sinh viên.\n" +
                    "4.Xóa sinh viên.\n" +
                    "5.Tìm kiếm sinh viên.\n" +
                    "6.Thoát .\n");
            int choice = Validator.getInt(scanner, "Mời nhập lựa chọn : ");
            switch (choice) {
                case 1:
                    studentManagement.getAllStudents();
                    break;
                case 2:
                    studentManagement.addStudent(scanner);
                    break;
                case 3:
                    studentManagement.updateStudent(scanner);
                    break;
                case 4:
                    studentManagement.deleteStudentById(scanner);
                    break;
                case 5:
                    studentManagement.searchStudentByName(scanner);
                    break;
                case 6:
                    System.out.println("Good bye !");
                    System.exit(0);
            }
        }
    }
}