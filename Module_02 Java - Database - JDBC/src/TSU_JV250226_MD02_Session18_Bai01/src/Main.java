import service.ProductService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************** PRODUCT MANAGEMENT ******************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("7. Thống kê số lượng sản phẩm theo danh mục");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductService.findAll();
                    break;
                case 2:
                    ProductService.createProduct(scanner);
                    break;
                case 3:
                    ProductService.updateProduct(scanner);
                    break;
                case 4:
                    ProductService.deleteProduct(scanner);
                    break;
                case 5:
                    ProductService.searchProductByName(scanner);
                    break;
                case 6:
                    ProductService.sortProductByPriceASB();
                    break;
                case 7:
                    ProductService.statictisProductByCatalog();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }while(true);
    }
}