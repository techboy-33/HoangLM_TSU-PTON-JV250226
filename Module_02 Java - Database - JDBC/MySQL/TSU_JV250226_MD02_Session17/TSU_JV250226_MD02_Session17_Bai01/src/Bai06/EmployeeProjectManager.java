package Bai06;

import Database.ConnectDatabase;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class EmployeeProjectManager {

    public void assignEmployeeToProject(int employeeId, int projectId) {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = ConnectDatabase.getConnection();
            if (connection != null) {
                connection.setAutoCommit(false);

                callableStatement = connection.prepareCall("{call assign_employee_to_project(?, ?, ?)}");
                callableStatement.setInt(1, employeeId);
                callableStatement.setInt(2, projectId);
                callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);

                callableStatement.executeUpdate();
                String result = callableStatement.getString(3);

                System.out.println(result);

                connection.commit();
            }
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            throw new RuntimeException(e);
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
