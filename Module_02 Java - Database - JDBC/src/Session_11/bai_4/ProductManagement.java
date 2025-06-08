package Session_11.bai_4;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class ProductManagement {
    private HashMap<Integer, Product> products;

    public ProductManagement() {
        products = new HashMap<>();
    }


    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void editProduct(int index, Scanner scanner) {
        if (products.containsKey(index)) {
            System.out.print("Enter new Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Product Price: ");
            double price = scanner.nextDouble();
            products.put(index, new Product(index, name, price));
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeProduct(int index) {
        products.remove(index);
        System.out.println("Product deleted successfully.");
    }

    public void displayProduct() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            products.values().forEach(System.out::println);
        }
    }

    public void filterProduct() {
        System.out.println("Products with price greater than 100:");
        products.values().stream()
                .filter(product -> product.getProductPrice() > 100)
                .forEach(System.out::println);
    }

    public void totalProduct() {
        double total = products.values().stream().mapToDouble(Product::getProductPrice).sum();
        System.out.println("Total value of products: " + total);
    }
}
