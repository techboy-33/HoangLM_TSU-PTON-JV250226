package Session_09.bai_1;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String specialization;

    public Student() {
    }

    public Student(String studentId, String name, int age, String specialization) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.specialization = specialization;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        this.studentId = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chuyên ngành: ");
        this.specialization = scanner.nextLine();
    }

    public void displayData() {
        System.out.printf("Mã: %s, Tên: %s, Tuổi: %d, Chuyên ngành: %s \n", studentId, name, age, specialization);
    }
}
