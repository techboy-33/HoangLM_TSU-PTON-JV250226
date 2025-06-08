package Session_11.bai_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagement management = new ProductManagement();

        int choice;
        do {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    management.addProduct(new Product(id, name, price));
                    System.out.println("Product added successfully.");
                    break;
                case 2:
                    int editId = InputData.getInt(scanner, "Enter Product ID to edit: ");
                    management.editProduct(editId, scanner);
                    break;
                case 3:
                    int removeId = InputData.getInt(scanner, "Enter Product ID to delete: ");
                    management.removeProduct(removeId);
                    break;
                case 4:
                    management.displayProduct();
                    break;
                case 5:
                    management.filterProduct();
                    break;
                case 6:
                    management.totalProduct();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
