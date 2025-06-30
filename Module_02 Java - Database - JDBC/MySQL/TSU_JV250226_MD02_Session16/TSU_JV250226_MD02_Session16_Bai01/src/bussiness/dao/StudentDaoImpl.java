package bussiness.dao;

import bussiness.model.Student;
import utils.ConnectionDB;
import validator.Validator;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDaoImpl{
    //    Hiện thị ra tất cả sinh viên
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{call get_all_students()}");
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setEmail(resultSet.getString("email"));
                student.setDateOfBirth(LocalDate.parse(String.valueOf(resultSet.getDate("date_of_birth").toLocalDate())));
                student.setFullName(resultSet.getString("full_name"));
                students.add(student);
            }
        } catch (Exception e) {
            System.out.println("Lấy dữ liệu ko thành công");
        }
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống !");
        } else {
            System.out.println("Danh sách sinh viên");
            for (Student student : students) {
                student.display();
            }
        }
        return students;
    }

    //    Thêm mới sinh viên
    public void addStudent(Scanner scanner) {
        Student student = new Student();
        student.setFullName(Validator.getString(scanner, "Enter full name : "));
        student.setEmail(Validator.getString(scanner, "Enter email : "));
        student.setDateOfBirth(Validator.getLocalDate(scanner, "Enter date of birth (dd/mm/yyyy) : "));
        try (Connection connection = ConnectionDB.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{call insert_student(?,?,?)}");
            callableStatement.setString(1, student.getFullName());
            callableStatement.setDate(2, Date.valueOf(student.getDateOfBirth()));
            callableStatement.setString(3, student.getEmail());
            boolean rs = callableStatement.executeUpdate() > 0;
            if (rs){
                System.out.println("Added student successfully");
            }else {
                System.out.println("Added student failed");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //Cập nhật sinh viên theo id

    public void updateStudent(Scanner scanner) {
        int id = Validator.getInt(scanner, "Enter student id want to be updated : ");
        Student oldStudent = findStudentById(id);
        if (oldStudent == null) {
            System.out.println("Student not found");
        }else {
            Student student = new Student();
            student.setStudentId(oldStudent.getStudentId());
            student.setFullName(Validator.getString(scanner, "Enter full name : "));
            student.setEmail(Validator.getString(scanner, "Enter email : "));
            student.setDateOfBirth(Validator.getLocalDate(scanner, "Enter date of birth (dd/mm/yyyy) : "));
            try (Connection connection = ConnectionDB.getConnection()) {
                CallableStatement callableStatement = connection.prepareCall("{call update_student(?,?,?,?)}");
                callableStatement.setInt(1, student.getStudentId());
                callableStatement.setString(2, student.getFullName());
                callableStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
                callableStatement.setString(4, student.getEmail());
                boolean rs = callableStatement.executeUpdate() > 0;
                if (rs) {
                    System.out.println("Student has been updated");
                }else {
                    System.out.println("Student has not been updated");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Tìm sinh viên theo id

    public Student findStudentById(int studentId) {
        try (Connection connection = ConnectionDB.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{call find_student_by_id(?)}");
            callableStatement.setInt(1, studentId);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setFullName(resultSet.getString("full_name"));
                // Giữ nguyên kiểu LocalDate, không chuyển thành String
                student.setDateOfBirth(LocalDate.parse(String.valueOf(resultSet.getDate("date_of_birth").toLocalDate())));
                student.setEmail(resultSet.getString("email"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    Xóa sinh viên theo id

    public void deleteStudentById(Scanner scanner) {
        int studentId = Validator.getInt(scanner, "Enter student id want to be deleted : ");
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found");
        }else {
            try (Connection connection = ConnectionDB.getConnection()) {
                CallableStatement callableStatement = connection.prepareCall("{call delete_student_by_id(?)}");
                callableStatement.setInt(1, studentId);
                boolean rs = callableStatement.executeUpdate() > 0;
                if (rs){
                    System.out.println("Xóa thành công !");
                }else {
                    System.out.println("Không thể xóa !");
                }
            }catch (Exception e) {
                System.out.println("Xóa thất bại !");
            }
        }
    }
    public void searchStudentByName(Scanner scanner) {
        String search = Validator.getString(scanner, "Enter student name want search : ");
        List<Student> students = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{call search_student_by_name(?)}");
            callableStatement.setString(1, search);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setEmail(resultSet.getString("email"));
                student.setDateOfBirth(LocalDate.parse(String.valueOf(resultSet.getDate("date_of_birth").toLocalDate())));
                student.setFullName(resultSet.getString("full_name"));
                students.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (students.isEmpty()){
            System.out.println("Không tim thấy sinh viên nào có chứa tên : " + search);
        }else {
            System.out.println("Kết quả sau khi tìm kiếm với tên : " + search);
            for(Student student : students){
                student.display();
            }
        }
    }
}
