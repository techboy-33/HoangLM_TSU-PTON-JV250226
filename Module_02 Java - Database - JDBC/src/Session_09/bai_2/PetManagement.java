package Session_09.bai_2;

import java.util.Locale;
import java.util.Scanner;

public class PetManagement {
    //        Phần khai báo dùng chung
    public static Pet[] petArray = new Pet[100];
    public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************* QUẢN LÝ THÚ CƯNG ***************");
        System.out.println("1. Hiển thị danh sách thú cưng");
        System.out.println("2. Thêm thú cưng");
        System.out.println("3. Gọi tiếng kêu");
        System.out.println("4. Xóa thú cưng");
        System.out.println("5. Tìm thú cưng theo tên");
        System.out.println("6. Thoát");

        do {
            System.out.print("Lựa chọn của bạn: ");
            int choosed = Integer.parseInt(scanner.nextLine());
            switch (choosed) {
                case (1):
//                Hiển thị danh sách thú cưng
                    if (currentIndex != 0) {
                        for (int i = 0; i < currentIndex; i++) {
                            petArray[i].displayData();
                        }
                    } else {
                        System.out.println("Chưa có data.");
                    }
                    break;
                case (2):
//                Thêm thú cưng
                    System.out.print("Bạn muốn thêm chó hay mèo (chó: true, mèo false):");
                    boolean petChoosed = Boolean.parseBoolean(scanner.nextLine());
                    if (petChoosed) {
//                        Khởi tạo chó
                        Pet dog = new Dog();
                        petArray[currentIndex] = dog;
                        petArray[currentIndex].inputData(scanner);
                        currentIndex += 1;
                    } else {
//                        Khởi tạo mèo
                        Pet cat = new Cat();
                        petArray[currentIndex] = cat;
                        petArray[currentIndex].inputData(scanner);
                        currentIndex += 1;
                    }
                    break;
                case (3):
//                Gọi tiếng kêu
                    System.out.print("Nhập tên thú cưng muốn gọi: ");
                    String callName = scanner.nextLine();
                    int cntCall = 0;

                    for (int i = 0; i < currentIndex; i++) {
                        if ((petArray[i].getPetName()).toLowerCase().contains(callName.toLowerCase(Locale.ROOT))) {
                            petArray[i].displayData();
                            petArray[i].speak();
                            cntCall += 1;
                        }
                    }
                    if (cntCall != 0) {
                        System.out.printf("Có %d thú cưng được gọi.\n", cntCall);
                    } else {
                        System.out.println("Không có thú cưng nào hợp lệ.");
                    }
                    break;
                case (4):
//                Xóa thú cưng
                    System.out.print("Nhập mã thú cưng muốn xóa: ");
                    String deletePetId = scanner.nextLine();
                    int deleteIndex = -1;
                    for (int i = 0; i < currentIndex; i++) {
                        if ((petArray[i].getPetId()).equalsIgnoreCase(deletePetId)) {
                            deleteIndex = i;
                        }
                    }
                    if (deleteIndex != -1) {
                        System.out.println("Đã xóa!");
                        for (int j = deleteIndex; j < currentIndex - 1; j++) {
                            petArray[j] = petArray[j + 1];
                        }
//                            petArray[currentIndex] = null;
                        currentIndex = currentIndex - 1;
                    } else {
                        System.out.println("Thú cưng này chưa tồn tại.");
                    }
                    break;
                case (5):
//                Tìm thú cưng theo tên
                    System.out.print("Nhập tên cần tìm: ");
                    String searchName = scanner.nextLine();
                    int cntSearch = 0;

                    for (int i = 0; i < currentIndex; i++) {
                        if ((petArray[i].getPetName()).toLowerCase().contains(searchName.toLowerCase(Locale.ROOT))) {
                            petArray[i].displayData();
                            cntSearch += 1;
                        }
                    }
                    if (cntSearch != 0) {
                        System.out.printf("Có %d thú cưng thỏa điều kiện tìm kiếm.\n", cntSearch);
                    } else {
                        System.out.println("Không có thú cưng nào hợp lệ.");
                    }
                    break;
                case (6):
//                  Thoát
                    System.exit(0);
                    break;
                default:
                    System.out.println("Số nhập vào không có trong menu.");
                    break;
            }
        } while (true);
    }
}
