package entity;

import validate.ProductValidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Product {
    private int productId;
    private String productName;
    private float price;
    private String title;
    private LocalDate created;
    private String catalog;
    private boolean status;

    public Product() {
    }

    public Product(int productId, String productName, float price, String title, LocalDate created, String catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.created = created;
        this.catalog = catalog;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format ("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá: %.1f\n" +
                "Tiêu đề: %s - Ngày tạo: %s - Danh mục: %s = Trạng thái: %s\n",
                this.productId, this.productName, this.price, this.title, this.created,
                this.catalog, this.status ? "Hoạt động" : "Không hoạt động");
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm");
        do {
            String productName = scanner.nextLine();
            if(ProductValidation.validateProductName(productName)) {
                this.productName = productName;
                break;
            } else {
                System.out.println("Tên sản phẩm phải nhập, duy nhất và có độ dài tối đa 100 ký tự. Vui lòng nhập lại.");
            }
        } while (true);
        System.out.println("Nhập vào giá sản phẩm: ");
        do {
            String price = scanner.nextLine();
            if(ProductValidation.validatePrice(price)) {
                this.price = Float.parseFloat(price);
                break;
            } else {
                System.out.println("Giá sản phẩm là số thực lớn hơn 0, vui lòng nhập lại");
            }
        }while (true);

        System.out.println("Nhập vào tiêu đề sản phẩm: ");
        this.title = scanner.nextLine();
        System.out.println("Nhập vào ngày tạo sản phẩm: ");
        this.created = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Nhập vào danh mục sản phẩm: ");
        this.catalog = scanner.nextLine();
    }
}
