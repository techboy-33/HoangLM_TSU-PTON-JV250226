package Session_11.bai_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 8.5),
                new Student("Bob", 22, 6.0),
                new Student("Charlie", 21, 7.5),
                new Student("David", 23, 9.0),
                new Student("Eve", 20, 5.5),
                new Student("Frank", 22, 8.0),
                new Student("Grace", 21, 7.0),
                new Student("Heidi", 23, 8.8),
                new Student("Ivan", 20, 6.5),
                new Student("Judy", 22, 7.2)
        );

        List<Student> studentStream = students.stream()
                .filter(student -> student.getGrade() > 7.0)
                .sorted(Comparator.comparing(Student::getGrade))
                .toList();
        System.out.println("Danh sách sinh viên có điểm lớn hơn 7.0, sắp xếp theo tên: ");
        studentStream.forEach(Student::display);
    }
}
