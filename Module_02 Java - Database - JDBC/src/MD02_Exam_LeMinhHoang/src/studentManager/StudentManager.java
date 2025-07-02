package studentManager;

import entity.Student;
import studentDAO.StudentDAO;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private final StudentDAO dao = new StudentDAO();
    private final Scanner sc = new Scanner(System.in);

    public void showStudents() {
        List<Student> list = dao.getAllStudent();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void addStudent(Scanner scanner) {
        Student s = new Student();
        System.out.println("Họ và tên: ");
        s.setFull_name(scanner.nextLine());
        System.out.println("Email: ");
        s.setEmail(scanner.nextLine());
        System.out.println("Số điện thoại: ");
        s.setPhone_number(scanner.nextLine());
        System.out.println("Ngày đăng ký: ");
        s.setRegister_date(Date.valueOf(scanner.nextLine()));

        if (dao.addStudent(s)) {
            System.out.println("Thêm mới thành công.");
        } else {
            System.out.println("Thêm mới thất bại.");
        }
    }

    public void updateStudent(Scanner scanner) {
        System.out.println("Nhập id cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student s = dao.getStudentById(id);
        if (s == null) {
            System.out.printf("Không tìm thấy sinh viên có %d", id);
            return;
        }
        System.out.println("Nhập họ và tên update: ");
        s.setFull_name(scanner.nextLine());
        System.out.println("Nhập email update: ");
        s.setEmail(scanner.nextLine());
        System.out.println("Nhập số điện thoại update: ");
        s.setPhone_number(scanner.nextLine());
        System.out.println("Nhập ngày đăng ký update: ");
        s.setRegister_date(Date.valueOf(scanner.nextLine()));
        System.out.println("Nhập trạng thái update (1 = Hoạt động, 0 = Không hoạt động)");
        s.setStatus(scanner.nextLine().equals("1"));

        if (dao.updateStudent(s)) {
            System.out.println("Cập nhật thành công.");
        } else {
            System.out.println("Cập nhật thất bại.");
        }
    }

    public  void deleteStudent(Scanner scanner) {
        System.out.println("Nhập id Sv cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (dao.deleteStudent(id)) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

    public void searchStudentByName(Scanner scanner) {
        System.out.println("Nhập tên Sv cần tìm: ");
        String name = scanner.nextLine();
        List<Student> list = dao.searchByName(name);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void sortDate () {
        List<Student> list = dao.sortByRegisterDate();
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
