package dao;

import entity.Product;
import entity.StatictisProduct;
import util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static List<Product> findALL() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_product}");
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getFloat("product_price"));
                product.setTitle(rs.getString("product_title"));
                product.setCreated(rs.getDate("product_created").toLocalDate());
                product.setCatalog(rs.getString("product_catalog"));
                product.setStatus(rs.getBoolean("product_status"));
                listProduct.add(product);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;
    }

    public static int isProductNameExist(String productName) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call is_product_name_exist(?, ?)}");
            callSt.setString(1, productName);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();
            return callSt.getInt(2);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return -1;
    }

    public static boolean createProduct(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_product(?,?,?,?,?)}");
            callSt.setString(1, product.getProductName());
            callSt.setFloat(2, product.getPrice());
            callSt.setString(3, product.getTitle());
            callSt.setDate(4, Date.valueOf(product.getCreated()));
            callSt.setString(5, product.getCatalog());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static boolean updateProduct(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_product(?,?,?,?,?,?,?)}");
            callSt.setInt(1, product.getProductId());
            callSt.setString(2, product.getProductName());
            callSt.setFloat(3, product.getPrice());
            callSt.setString(4, product.getTitle());
            callSt.setDate(5, Date.valueOf(product.getCreated()));
            callSt.setString(6, product.getCatalog());
            callSt.setBoolean(7, product.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static Product findProductById(int productId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product product = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_product_by_id(?)}");
            callSt.setInt(1, productId);
            ResultSet rs = callSt.executeQuery();
            product = new Product();
            if (rs.next()) {
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getFloat("product_price"));
                product.setTitle(rs.getString("product_title"));
                product.setCreated(rs.getDate("product_created").toLocalDate());
                product.setCatalog(rs.getString("product_catalog"));
                product.setStatus(rs.getBoolean("product_status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return product;
    }

    public static boolean deleteProductById(int productId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_product(?)}");
            callSt.setInt(1, productId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static List<Product> searchProductByName(String productName) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_product_by_name(?)}");
            callSt.setString(1, productName);
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getFloat("product_price"));
                product.setTitle(rs.getString("product_title"));
                product.setCreated(rs.getDate("product_created").toLocalDate());
                product.setCatalog(rs.getString("product_catalog"));
                product.setStatus(rs.getBoolean("product_status"));
                listProduct.add(product);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;
    }

    public static List<StatictisProduct> statictisProductByCatalog() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<StatictisProduct> listStatictis = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call static_product_by_catalog()}");
            ResultSet rs = callSt.executeQuery();
            listStatictis = new ArrayList<>();
            while (rs.next()) {
                StatictisProduct sproduct = new StatictisProduct();
                sproduct.setCatalog(rs.getString("product_catalog"));
                sproduct.setCntProduct(rs.getInt("cntProduct"));
                listStatictis.add(sproduct);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listStatictis;
    }
}
