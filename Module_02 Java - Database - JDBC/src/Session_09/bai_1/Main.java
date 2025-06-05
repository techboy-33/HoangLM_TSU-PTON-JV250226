package Session_09.bai_1;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("************QUẢN LÝ SINH VIÊN************");
        System.out.println("1. Hiển thị danh sách sinh viên");
        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Cập nhật thông tin sinh viên theo mã sinh viên.");
        System.out.println("4. Xóa sinh viên theo mã sinh viên");
        System.out.println("5. Tìm sinh viên theo tên sinh viên");
        System.out.println("6. Thoát");

//        Khai báo
        Student[] studentArray = new Student[100];
        int currentIndex = 0;

        do {
            System.out.print("Lựa chọn của bạn: ");
            int chocce = Integer.parseInt(scanner.nextLine());
            switch (chocce) {
                case (1):
//                    Hiển thị danh sách sinh viên
                    if (currentIndex != 0) {
                        for (int i = 0; i < currentIndex; i++) {
                            studentArray[i].displayData();
                        }
                    } else {
                        System.out.println("Chưa có data.");
                    }
                    break;
                case (2):
//                    Thêm sinh viên
                    System.out.print("Nhập số sinh viên bạn muốn thêm: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < quantity; i++) {
                        studentArray[currentIndex] = new Student();
                        System.out.printf("==== Nhập thông tin sinh viên thứ %d ====\n", currentIndex + 1);
                        studentArray[currentIndex].inputData(scanner);
                        currentIndex += 1;
                    }
                    break;
                case (3):
//                    Cập nhật thông tin sinh viên theo mã sinh viên
                    System.out.print("Nhập mã sinh viên muốn cập nhật thông tin : ");
                    String inputUpdateId = scanner.nextLine();
                    int updateStudentIndex = -1;
                    for (int i = 0; i < currentIndex; i++) {
                        if (studentArray[i].getStudentId().equals(inputUpdateId)) {
                            updateStudentIndex = i;
                        }
                    }
                    if (updateStudentIndex == -1) {
                        System.out.println("Mã chưa tồn tại.");
                    } else {
                        System.out.print("Cập nhật mã sinh viên: ");
                        studentArray[updateStudentIndex].setStudentId(scanner.nextLine());
                        System.out.print("Cập nhật tên sinh viên: ");
                        studentArray[updateStudentIndex].setName(scanner.nextLine());
                        System.out.print("Cập nhật tuổi sinh viên: ");
                        studentArray[updateStudentIndex].setAge(Integer.parseInt(scanner.nextLine()));
                        System.out.print("Cập nhật ngành của sinh viên: ");
                        studentArray[updateStudentIndex].setSpecialization(scanner.nextLine());
                    }
                    break;
                case (4):
//                    Xóa sinh viên theo mã sinh viên
                    System.out.print("Nhập mã sinh viên muốn xóa: ");
                    String inputDeleteId = scanner.nextLine();
                    int deleteStudentIndex = -1;
                    for (int i = 0; i < currentIndex; i++) {
                        if (studentArray[i].getStudentId().equals(inputDeleteId)) {
                            deleteStudentIndex = i;
                        }
                    }
                    if (deleteStudentIndex == -1) {
                        System.out.println("Mã chưa tồn tại.");
                    } else {
                        for (int i = deleteStudentIndex; i < currentIndex - 1; i++) {
                            studentArray[deleteStudentIndex] = studentArray[deleteStudentIndex + 1];
                        }
//                        cho phần tử cuối bằng null
//                        nhưng đã bỏ do có thẻ ghi đè lên phần tử cũ có được không ?
                        currentIndex = currentIndex - 1;
                    }
                    break;
                case (5):
//                    Tìm sinh viên theo tên sinh viên
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String inputStudentName = scanner.nextLine();
                    int cntStudent = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if ((studentArray[i].getName().toLowerCase()).contains(inputStudentName.toLowerCase(Locale.ROOT))) {
                            studentArray[i].displayData();
                            cntStudent += 1;
                        }
                    }
                    if (cntStudent != 0) {
                        System.out.printf("Có %d sinh viên khớp với kết quả tìm kiếm. \n", cntStudent);
                    }else {
                        System.out.println("Không có thông tin nào hợp lệ.");
                    }
                    break;
                case (6):
//                    Thoát
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
