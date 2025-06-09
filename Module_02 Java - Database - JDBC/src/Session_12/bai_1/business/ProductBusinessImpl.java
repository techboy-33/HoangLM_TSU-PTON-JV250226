package Session_12.bai_1.business;

import Session_12.bai_1.entity.Product;
import Session_12.bai_1.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductBusinessImpl implements IProductBusiness{
    private List<Product> products;

    public ProductBusinessImpl () {
        products = new ArrayList<>();
        products.add(new Product("P001", "Laptop", 1500.00, 10));
        products.add(new Product("P002", "Smartphone", 800.00, 20));
        products.add(new Product("P003", "Tablet", 600.00, 15));
    }

    @Override
    public void addProduct(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        boolean isCheckId = true;
        for (int i = 0; i < n; i++) {
            Product product = new Product();
            product.inputData(scanner);
            checkProductId(product, scanner);
            products.add(product);
            System.out.println("Đã thêm thành công");
        }
    }

    @Override
    public void displayProduct() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm rỗng.");
            return;
        }
        System.out.println("+-----+---------------+-------+-----+");
        System.out.printf("|%-5s|%-15s|%-7s|%5s|\n",  "ID", "productName", "price", "stock");
        System.out.println("+-----+---------------+-------+-----+");
        products.forEach(System.out::println);
    }

    @Override
    public void findProductById(String id) throws ProductNotFoundException {
        Optional<Product> productOptional = products.stream().filter(p -> p.getProductId().equals(id)).findFirst();
        System.out.println(productOptional.orElseThrow(() -> new ProductNotFoundException("Không có mã sản phẩm với ID " + id)));
    }

    public void checkProductId (Product product, Scanner scanner) {
        while (true) {
            boolean isDuplicate = products.stream().anyMatch(p -> p.getProductId().equals(product.getProductId()));
            if (isDuplicate) {
                System.out.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại.");
                product.setProductId(product.inputProductId(scanner));
            }else {
                break;
            }
        }
    }
}
