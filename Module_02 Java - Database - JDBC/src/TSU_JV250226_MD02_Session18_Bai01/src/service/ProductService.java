package service;

import dao.ProductDAO;
import entity.Product;
import entity.StatictisProduct;
import validate.ProductValidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    public static void findAll() {
        List<Product> listProducts = ProductDAO.findALL();
        if (listProducts == null) {
            System.err.println("Có lỗi xảy ra trong quá trình xử lý, vui lòng thử lại");
            return;
        }
        listProducts.forEach(System.out::println);
    }

    public static void createProduct(Scanner scanner) {
        Product product = new Product();
        product.inputData(scanner);
        boolean result = ProductDAO.createProduct(product);
        if (result) {
            System.out.println("Thêm mới sản phẩm thành công");
        } else {
            System.out.println("Thêm mới sản phẩm thất bại");
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần cập nhật: ");
        int productId = Integer.parseInt(scanner.nextLine());
        Product productUpdate = ProductDAO.findProductById(productId);
        if (productUpdate == null) {
            System.err.println("Mã sản phẩm không tồn tại!!");
        } else {
            boolean isExist = true;
            do {
                System.out.println("1. Cập nhật tên sản phẩm");
                System.out.println("2. Cập nhật giá sản phẩm");
                System.out.println("3. Cập nhật tiêu đề");
                System.out.println("4. Cập nhật ngày tạo");
                System.out.println("5. Cập nhật danh mục");
                System.out.println("6. Cập nhật trạng thái");
                System.out.println("7. Thoát");
                System.out.println("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên sản phẩm mới: ");
                        do {
                            String productName = scanner.nextLine();
                            if (ProductValidation.validateProductName(productName)) {
                                productUpdate.setProductName(productName);
                                break;
                            } else {
                                System.out.println("Tên không được để trống, không trùng lặp, độ dài không vượt quá 100 ký tự.");
                            }
                        } while (true);
                        break;
                    case 2:
                        System.out.println("Nhập vào giá sản phẩm: ");
                        do {
                            String price = scanner.nextLine();
                            if (ProductValidation.validatePrice(price)) {
                                productUpdate.setPrice(Float.parseFloat(price));
                                break;
                            } else {
                                System.err.println("Giá sản phẩm là số thực lớn hơn 0, vui lòng nhập lại");
                            }
                        } while (true);
                        break;
                    case 3:
                        System.out.println("Nhập vào tiêu đề mới: ");
                        productUpdate.setTitle(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhập vào tiêu đề mới: ");
                        productUpdate.setCreated(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        break;
                    case 5:
                        System.out.println("Nhập vào danh mục mới: ");
                        productUpdate.setCatalog(scanner.nextLine());
                        break;
                    case 6:
                        System.out.println("Nhập vào trạng thái mới: ");
                        productUpdate.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 7:
                        isExist = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-7");
                }
            }while (isExist);
            boolean result = ProductDAO.updateProduct(productUpdate);
            if (result) {
                System.out.println("Cập nhật sản phẩm thành công");
            } else {
                System.out.println("Có lỗi trong quá trình cập nhật !!!");
            }
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần xóa: ");
        int productId = Integer.parseInt(scanner.nextLine());
        Product productDelete = ProductDAO.findProductById(productId);
        if (productDelete == null) {
            System.out.println("Mã sản phẩm không tồn tại");
        } else {
            boolean result = ProductDAO.deleteProductById(productId);
            if (result) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Có lỗi xảy ra trong quá trình xóa");
            }
        }
    }

    public static void searchProductByName (Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm cần tìm: ");
        String productName = scanner.nextLine();
        List<Product> listProducts = ProductDAO.searchProductByName(productName);
        if (listProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm");
        } else {
            System.out.printf("Tìm thấy %d sản phẩm: \n", listProducts.size());
            listProducts.forEach(System.out::println);
        }
    }

    public static void sortProductByPriceASB () {
        List<Product> listProducts = ProductDAO.findALL();
        System.out.println("Danh sách sản phẩm khi sắp xếp theo giá tăng dần: ");
        listProducts.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(System.out::println);
    }

    public static void statictisProductByCatalog() {
        List<StatictisProduct> listProducts = ProductDAO.statictisProductByCatalog();
        listProducts.forEach(System.out::println);
    }
}
