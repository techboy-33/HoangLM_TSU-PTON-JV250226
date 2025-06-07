package Session_10.bai_4;

import java.util.ArrayList;

public class AttendanceManager implements Manage<Student> {
    ArrayList<Student> students = new ArrayList<>();

    public AttendanceManager() {
        students = new ArrayList<>();
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void update(int index, Student student) {
        if (index >= 0 && index < students.size()) {
            students.set(index, student);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
    }

    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Chưa có dữ liệu.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + "." + students.get(i));
            }
        }
    }
}
