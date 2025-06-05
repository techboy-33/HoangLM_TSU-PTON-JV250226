package Session_10.bai_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student_Management studentManagement = new Student_Management();
        String continueInput;
        do {
            String name = InputData.getString(scanner, "Nhập tên sinh viên: ");
            int age = InputData.getInt(scanner, "Nhập tuổi sinh viên: ");
            double avgScore = InputData.getDouble(scanner, "Nhập điểm trung bình sinh viên: ");

            Student student = new Student(name, age, avgScore);
            studentManagement.addStudent(student);
            continueInput = InputData.getString(scanner, "Bạn có muốn thêm sinh viên khác? (y/n): ");
        }while (continueInput.equalsIgnoreCase("y"));

        System.out.println("\n Danh sách sinh viên: ");
        studentManagement.displayStudents();
        scanner.close();
    }
}
