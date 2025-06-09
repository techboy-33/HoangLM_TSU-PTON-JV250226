package Session_12.bai_1.presentation;

import Session_12.bai_1.business.ProductBusinessImpl;
import Session_12.bai_1.exception.ProductNotFoundException;

import java.util.Scanner;

public class ProductsManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductBusinessImpl products = new ProductBusinessImpl();
        do {
            System.out.println("******* PRODUCT MENU ********");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Tìm sản phẩm theo ID");
            System.out.println("4. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    products.displayProduct();
                    break;
                case 2:
                    products.addProduct(scanner);
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm cần tìm: ");
                    String id = scanner.nextLine();
                    try{
                        products.findProductById(id);
                    }catch (ProductNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }while (true);
    }
}
