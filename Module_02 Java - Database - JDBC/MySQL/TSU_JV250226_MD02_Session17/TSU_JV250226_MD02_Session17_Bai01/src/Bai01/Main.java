package Bai01;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        List<Student> students = Arrays.asList(
                new Student(0, "Nguyễn Văn A", 20),
                new Student(0, "Trần Thị B", 22),
                new Student(0, "Lê Văn C", 19)
        );

        manager.addStudents(students);

    }
}