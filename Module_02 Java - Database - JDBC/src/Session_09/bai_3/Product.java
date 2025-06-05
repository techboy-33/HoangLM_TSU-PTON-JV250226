package Session_09.bai_3;

import java.util.Scanner;

public class Product implements IShop {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCatalog) {
        inputProductId(scanner);
        inputProductPrice(scanner);
        inputProductDescritption(scanner);
        inputCatalogId(scanner);
        inputProductStatus(scanner);
    }

    public void inputProductId(Scanner scanner) {
        System.out.println("mã sản phẩm đồ uống, gồm 4 ký tự bắt đầu là một trong 3 ký tự \n (C: các đồ uống là café, S: các đồ uống là sinh tố, A: các đồ ăn nhanh)");
        System.out.print("Nhập mã sản phẩm: ");
        this.productId = scanner.nextLine();
    }

    public void inputProductName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();
    }

    public void inputProductPrice (Scanner scanner){
        System.out.print("Nhập giá: ");
        this.price = Float.parseFloat(scanner.nextLine());
    }

    public void inputProductDescritption (Scanner scanner) {
        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();
    }

    public void inputCatalogId (Scanner scanner) {
        for (int i = 0; i < ShopManagement.categoriesCurrentIndex; i++) {
            ShopManagement.categories[i].displayData();
        }
        System.out.print("Nhập mã danh mục: ");
        this.catalogId = Integer.parseInt(scanner.nextLine());
    }

    public void inputProductStatus (Scanner scanner) {
        System.out.print("Nhập trạng thái sản phẩm (0: Đang bán – 1: Hết hàng – 2: Không bán): ");
        this.productStatus = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %d, Tên sản phẩm: %s,Giá: %.f, Mô tả: %s,Mã danh mục: %d Trạng thái: %s \n",productId ,productName ,price ,description,catalogId,productStatus == 0  ? "Đang bán" : (productStatus == 1 ? "Hết hàng" : "Không bán"));
    }
}
