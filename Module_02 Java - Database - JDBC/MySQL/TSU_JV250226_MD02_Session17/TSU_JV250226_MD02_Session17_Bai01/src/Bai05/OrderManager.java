package Bai05;


import Database.ConnectDatabase;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class OrderManager {

    public void placeOrder(int customerId, BigDecimal totalAmount, int productId, int quantity) {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = ConnectDatabase.getConnection();
            if (connection != null) {
                connection.setAutoCommit(false);

                callableStatement = connection.prepareCall("{call place_order(?,?,?, ?, ?)}");
                callableStatement.setInt(1, customerId);
                callableStatement.setBigDecimal(2, totalAmount);
                callableStatement.setInt(3, productId);
                callableStatement.setInt(4, quantity);
                callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);

                callableStatement.executeUpdate();
                String result = callableStatement.getString(5);

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
