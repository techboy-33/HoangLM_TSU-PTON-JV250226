package Session_09.bai_3;

import java.util.Scanner;

public class Categories implements IShop {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories, int index) {
        this.catalogId = index + 1;
        inputCatalogName(scanner);
        inputCatalogDescriptions(scanner);
        inputCatalogStatus(scanner);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã: %d, Tên danh mục: %s, Mô tả: %s, Trạng thái: %s \n", catalogId, catalogName, descriptions, catalogStatus ? "hoạt động" : "không hoạt động");
    }


    public void inputCatalogName(Scanner scanner) {
        System.out.print("Tên danh mục: ");
        this.catalogName = scanner.nextLine();
    }

    public void inputCatalogDescriptions(Scanner scanner) {
        System.out.print("Mô tả danh mục: ");
        this.descriptions = scanner.nextLine();
    }

    public void inputCatalogStatus(Scanner scanner) {
        System.out.print("Trạng thái danh mục (true – hoạt động, false – không hoạt động): ");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
    }
}
