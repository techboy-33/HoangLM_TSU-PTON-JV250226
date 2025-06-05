package Session_10.bai_1;

import java.util.ArrayList;

public class Student_Management {
    private ArrayList<Student> students;

    public Student_Management() {
        students = new ArrayList<>();
    }

    public void addStudent (Student student) {
        students.add(student);
    }

    public void displayStudents () {
        if (students.isEmpty()) {
            System.out.println("Chưa có sinh viên nào trong danh sách.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
