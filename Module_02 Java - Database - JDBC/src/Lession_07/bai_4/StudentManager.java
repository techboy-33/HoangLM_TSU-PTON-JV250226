package Lession_07.bai_4;

import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] stuArray = new Student[7];
        stuArray[0] = new Student("Bob", 21, "A1", 7.0);
        stuArray[1] = new Student("Eve", 20, "A1", 8.0);
        stuArray[2] = new Student("Tom", 27, "A2", 5.0);
        stuArray[3] = new Student("Harry", 19, "A3", 6.0);
        stuArray[4] = new Student("John", 25, "A2", 4.0);
        stuArray[5] = new Student("Keven", 30, "A3", 9.0);
        stuArray[6] = new Student("Lisa", 22, "A3", 5.0);

        System.out.print("Nhập điểm min: ");
        float minScore = scanner.nextFloat();
        System.out.print("Nhập điểm max: ");
        float maxScore = scanner.nextFloat();
        System.out.printf("Danh sách sinh viên có điểm trung bình từ %.1f đến %.1f:\n", minScore, maxScore);
        for (Student student : stuArray) {
            if (student.getAvgScore() >= minScore && student.getAvgScore() <= maxScore) {
                System.out.printf("Tên : %s, Tuổi : %d, Lớp : %s, Điểm trung bình: %.1f \n", student.getName(), student.getAge(), student.getClassRoom(), student.getAvgScore());
            }
        }
    }
}
