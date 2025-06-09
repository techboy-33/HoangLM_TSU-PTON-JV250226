package Session_12.bai_1.entity;

import java.util.Scanner;

public class Product implements IApp {
    private String productId;
    private String productName;
    private double productPrice;
    private int productStock;

    public Product() {
    }

    public Product(String productId, String productName, double productPrice, int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.productId = inputProductId(scanner);
        this.productName = inputProductName(scanner);
        System.out.print("Nhập giá sản phẩm: ");
        this.productPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng tồn kho: ");
        this.productStock = Integer.parseInt(scanner.nextLine());
    }

    public String inputProductId(Scanner scanner) {
        do {
            System.out.print("Nhập mã sản phẩm: ");
            String id = scanner.nextLine();
            if (id.matches("P\\d{3}")) {
                return id;
            } else {
                System.out.println("Mã sản phẩm không hợp lệ, vui long nhap lai (PXXX, X la so tu 0-9)");
            }
        } while (true);
    }

    public String inputProductName(Scanner scanner) {
        do {
            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            if (name.length() > 5 && name.length() < 50) {
                return name;
            } else {
                System.out.println("Tên sản phẩm không hợp lệ, phải từ 5 đến 50 kí tự .");
            }
        }while (true);
    }

    @Override
    public String toString() {
        String out= String.format("|%5s|%15s|%7.2f|%5d|\n",
                productId, productName, productPrice, productStock);
        String line = "+-----+---------------+-------+-----+";
        return out + line;
    }
}
