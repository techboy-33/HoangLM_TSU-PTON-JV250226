package utils;

import java.sql.*;
import java.sql.DriverManager;

public class ConnectionDB {
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/student_management_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement callSt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw  new RuntimeException(e);
            }
        }
        if (callSt != null) {
            try {
                callSt.close();
            } catch (SQLException e) {
                throw  new RuntimeException(e);
            }
        }
    }

//    public static void main(String[] args) {
//        Connection conn = (Connection) openConnection();
//        if (conn != null) {
//            System.out.println("Thành công");
//        } else {
//            System.out.println("Thất bại");
//        }
//    }
}
