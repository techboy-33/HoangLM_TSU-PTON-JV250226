package Session_09.bai_3;

import java.util.Scanner;

public class ShopManagement {
    //    Khai báo
    public static Categories[] categories = new Categories[100];
    Categories categori1 = new Categories(1,"Thuốc", "Thuốc dùng ngoài", true);
    Categories categori2 = new Categories(2,"Đồ ăn", "Đồ ăn vặt", true);

    public static Product[] products = new Product[100];
    public static int categoriesCurrentIndex = 2;
    public static int productCurrentIndex = 0;


    public static void main(String[] args) {
        Categories categori1 = new Categories(1,"Thuốc", "Thuốc dùng ngoài", true);
        Categories categori2 = new Categories(2,"Đồ ăn", "Đồ ăn vặt", true);
        categories[0] = categori1;
        categories[1] = categori2;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("********SHOP MENU********");
            System.out.println("1. Quản lý danh mục sản phầm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case (1):
//                    Hiển thị menu quản lí các sản phẩm
                    int categoriMenuChoice;
                    boolean isContinueCategoriesMenu = true;
                    do {
                        System.out.println();
                        System.out.println("********CATEGORIES MENU********");
                        System.out.println("1. Nhập thông tin các danh mục");
                        System.out.println("2. Hiển thị thông tin các danh mục");
                        System.out.println("3. Cập nhật thông tin danh mục");
                        System.out.println("4. Xóa danh mục");
                        System.out.println("5. Cập nhật trạng thái danh mục");
                        System.out.println("6. Quay lại menu chính");

                        System.out.print("Lựa chọn của bạn: ");
                        categoriMenuChoice = Integer.parseInt(scanner.nextLine());
                        switch (categoriMenuChoice) {
                            case (1):
//                                Nhập thông tin các danh mục
                                System.out.print("Bạn muốn nhập bao nhiêu danh mục: ");
                                int quantity = Integer.parseInt(scanner.nextLine());
                                for (int i = 0; i < quantity; i++) {
                                    Categories categori = new Categories();
                                    categori.inputData(scanner, categories, categoriesCurrentIndex);
                                    categories[categoriesCurrentIndex] = categori;
                                    categoriesCurrentIndex += 1;
                                }
                                break;
                            case (2):
//                                Hiển thị thông tin các danh mục
                                if (categoriesCurrentIndex != 0) {
                                    System.out.println("**** Thông tin các danh mục ****");
                                    for (int i = 0; i < categoriesCurrentIndex; i++) {
                                        categories[i].displayData();
                                    }
                                } else {
                                    System.out.println("Chưa có danh mục nào được tạo.");
                                }
                                break;
                            case (3):
//                                Cập nhật thông tin danh mục
                                int updateCategoriIndex = -1;
                                if (categoriesCurrentIndex != 0) {
                                    System.out.print("Mã danh mục cần cập nhật thông tin: ");
                                    int updateCategoriId = Integer.parseInt(scanner.nextLine());
                                    for (int i = 0; i < categoriesCurrentIndex; i++) {
                                        if (updateCategoriId == categories[i].getCatalogId()) {
                                            updateCategoriIndex = i;
                                        }
                                    }
                                    if (updateCategoriId != -1) {
                                        System.out.print("Cập nhật tên danh mục: ");
                                        categories[updateCategoriIndex].setCatalogName(scanner.nextLine());
                                        System.out.print("Cập nhật mô tả: ");
                                        categories[updateCategoriIndex].setDescriptions(scanner.nextLine());
                                        System.out.print("Cập nhật trạng thái (true – hoạt động, false – không hoạt động): ");
                                        categories[updateCategoriIndex].setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
                                    } else {
                                        System.out.println("Mã này không tồn tại.");
                                    }
                                } else {
                                    System.out.println("Chưa có dữ liệu.");
                                }
                                break;
                            case (4):
//                                Xóa danh mục
                                break;
                            case (5):
//                                Cập nhật trajgn thái danh mục
                                int updateCategoriStatusIndex = -1;
                                if (categoriesCurrentIndex != 0) {
                                    System.out.print("Mã danh mục cần cập nhật trạng thái: ");
                                    int updateCategoriStatusId = Integer.parseInt(scanner.nextLine());
                                    for (int i = 0; i < categoriesCurrentIndex; i++) {
                                        if (updateCategoriStatusId == categories[i].getCatalogId()) {
                                            updateCategoriStatusIndex = i;
                                        }
                                    }
                                    if (updateCategoriStatusIndex != -1) {
                                        System.out.print("Cập nhật trạng thái (true – hoạt động, false – không hoạt động): ");
                                        categories[updateCategoriStatusIndex].setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
                                    } else {
                                        System.out.println("Mã này không tồn tại.");
                                    }
                                } else {
                                    System.out.println("Chưa có dữ liệu.");
                                }
                                break;
                            case (6):
                                isContinueCategoriesMenu = false;
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Mời nhập lại.");
                        }
//                        lựa chọn tiếp tục ở lại menu danh mục, để cho dễ nhìn
                        if (isContinueCategoriesMenu) {
                            System.out.print("Bạn có muốn tiếp tục ở lại menu danh mục không: ");
                            String continueChoice = scanner.nextLine();
                            if (continueChoice.equalsIgnoreCase("không")) {
                                isContinueCategoriesMenu = false;
                            }
                        }
                    }
                    while (isContinueCategoriesMenu);
                    break;
                case (2):
//                    Hiển thị menu quản lí sản phẩm
                    int productMenuChoice;
                    boolean isContinueProductMenu = true;
                    do {
                        System.out.println();
                        System.out.println("*****PRODUCT MANAGEMENT*****");
                        System.out.println("1. Nhập thông tin các sản phẩm");
                        System.out.println("2. Hiển thị thông tin các sản phẩm");
                        System.out.println("3. Sắp xếp các sản phẩm theo giá");
                        System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
                        System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
                        System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
                        System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a-b(a,b nhập từ bàn phím)");
                        System.out.println("8. Quay lại menu chính");

                        System.out.print("Lựa chọn của bạn:");
                        productMenuChoice = Integer.parseInt(scanner.nextLine());
                        switch (productMenuChoice) {
                            case (1):
//                                Nhập thông tin các sản phẩm
                                Product product = new Product();
                                product.inputData(scanner, products, productCurrentIndex, categories, categoriesCurrentIndex);
                                products[productCurrentIndex] = product;
                                productCurrentIndex ++;
                                break;
                            case (2):
//                                Hiển thị thông tin các sản phẩm
                                for (int i = 0; i < productCurrentIndex; i++) {
                                    products[i].displayData();
                                }

                                break;
                            case (3):
//                                Sắp xếp các sản phẩm theo giá
                                break;
                            case (4):
//                                Cập nhật thông tin sản phẩm theo mã sản phẩm
                                break;
                            case (5):
//                                Xóa sản phẩm theo mã sản phẩm
                                break;
                            case (6):
//                                Tìm kiếm các sản phẩm theo tên sản phẩm
                                break;
                            case (7):
//                                Tìm kiếm sản phẩm trong khoảng giá a đến b(a, b nhập từ bàn phím)
                                break;
                            case (8):
                                isContinueProductMenu = false;
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Mời nhập lại.");
                        }

//                        lựa chọn tiếp tục ở lại menu sản phẩm, để cho dễ nhìn
                        if (isContinueProductMenu) {
                            System.out.print("Bạn có muốn tiếp tục ở lại menu sản phẩm không: ");
                            String continueChoice = scanner.nextLine();
                            if (continueChoice.equalsIgnoreCase("không")) {
                                isContinueProductMenu = false;
                            }
                        }
                    } while (isContinueProductMenu);
                    break;
                case (3):
                    System.exit(0);
                    break;
                default:
                    System.out.println("Số nhập vào không hợp lệ. Xin hãy nhập lại!");
            }
        } while (true);
    }
}
