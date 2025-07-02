package studentDAO;

import java.sql.*;
import entity.Student;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> getAllStudent () {
        List<Student> students = new ArrayList<>();
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall("{call get_all_student()}")
        ) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getDate("register_date"),
                        rs.getBoolean("status")
                );
                students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }


    public  boolean addStudent(Student s) {
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall("{call add_student(?,?,?,?)}")){
             stmt.setString(1, s.getFull_name());
             stmt.setString(2, s.getEmail());
             stmt.setString(3, s.getPhone_number());
             stmt.setDate(4, (Date) s.getRegister_date());
             return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public  boolean updateStudent(Student s) {
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall("{call update_student(?,?,?,?,?,?)}")){
            stmt.setInt(1, s.getStudent_id());
            stmt.setString(2, s.getFull_name());
            stmt.setString(3, s.getEmail());
            stmt.setString(4, s.getPhone_number());
            stmt.setDate(5, (Date) s.getRegister_date());
            stmt.setBoolean(6,s.getStatus());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public  boolean deleteStudent(int id) {
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall("{call delete_student(?)}")){
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public  List<Student> searchByName(String name) {
        List<Student> students = new ArrayList<>();
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall("{call search_student_by_name(?)}")){
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getDate("register_date"),
                        rs.getBoolean("status")
                );
                students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public  Student getStudentById(int id) {
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall("{call get_student_by_id(?)}")){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("student_id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getDate("register_date"),
                        rs.getBoolean("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  List<Student> sortByRegisterDate() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement stmt = conn.prepareCall("{call sort_student_by_date_desc()}")){

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getDate("register_date"),
                        rs.getBoolean("status")
                );
                students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

}
