package Session_10.bai_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AttendanceManager manage = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("******** MENU QUẢN LÝ ĐIỂM DANH ********");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Sửa sinh viên");
        System.out.println("3. Xóa sinh viên");
        System.out.println("4. Hiển thị danh sách sinh viên");
        System.out.println("4. Thoát");

        do {
             choice = InputData.getInt(scanner, "Lựa chọn của bạn: ");
             switch (choice) {
                 case 1:
//                     Thêm sinh viên
                     int id = InputData.getInt(scanner, "Nhập id sinh viên: ");
                     String name = InputData.getString(scanner, "Nhập tên sinh viên: ");
                     Student student = new Student(id, name);
                     manage.add(student);
                     System.out.println("Sinh viên đã được thêm thành công.");
                     break;
                 case 2:
//                     Sửa sinh viên
                     manage.display();
                     int inputId = InputData.getInt(scanner, "Nhập id sinh viên cần sửa: ");
                     int index = -1;
                     for (int i = 0; i < manage.students.size(); i++) {
                        if (manage.students.get(i).getId() == inputId){
                            index = i;
                            break;
                        }
                     }
                     if (index == -1) {
                         System.out.println("Không tìm thấy ID sinh viên cần sửa.");
                     }else {
                         String nameUpdate = InputData.getString(scanner, "Nhập tên mới sinh viên: ");
                         manage.update(index, new Student(inputId, nameUpdate));
                         System.out.println("Sinh viên đã được sửa thành công !");
                     }
                     break;
                 case 3:
//                     Xóa sinh viên
                     manage.display();
                     int inputDeleteId = InputData.getInt(scanner, "Nhập id sinh viên cần xóa: ");
                     int deleteIndex = -1;
                     for (int i = 0; i < manage.students.size(); i++) {
                         if (manage.students.get(i).getId() == inputDeleteId) {
                             deleteIndex = i;
                             break;
                         }
                     }
                     if (deleteIndex == -1) {
                         System.out.println("Không tìm thấy ID sinh viên cần xóa. ");
                     }else {
                         manage.delete(deleteIndex);
                         System.out.println("Đã xóa sinh viên thành công !");
                     }
                     break;
                 case 4:
//                     Hiển thị danh sách sinh viên
                     manage.display();
                     break;
                 case 5:
                     System.exit(0);
                     break;
                 default:
                     System.out.println("Số nhập vào không hợp lệ.");
             }
        }while (true);
    }
}
