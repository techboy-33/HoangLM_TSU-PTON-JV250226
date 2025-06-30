package validate;

import dao.ProductDAO;
import entity.Product;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class ProductValidation {
    public static boolean validateProductId(String data) {
        try {
            int productId = Integer.parseInt(data.trim());
            if (productId > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean validateProductName(String data) {
        if (data != null && !data.trim().isEmpty()) {
            if (data.length() < 100) {
                int cntProduct = ProductDAO.isProductNameExist(data);
                if (cntProduct == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validatePrice(String data) {
        if (data != null && !data.trim().isEmpty()) {
            try {
                float price = Float.parseFloat(data.trim());
                if (price > 0) {
                    return true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
