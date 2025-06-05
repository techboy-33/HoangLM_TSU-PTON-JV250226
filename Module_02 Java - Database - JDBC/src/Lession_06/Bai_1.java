package Lession_06;

import java.util.Scanner;

public class Bai_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*********QUẢN LÝ ĐIỂM SV*********");
        System.out.println("1. Nhập danh sách điểm sinh viên");
        System.out.println("2. In danh sách điểm");
        System.out.println("3. Tính điểm trung bình của các sinh viên");
        System.out.println("4. Tìm điểm cao nhất và thấp nhất");
        System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
        System.out.println("6. Sắp xếp điểm tăng dần");
        System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
        System.out.println("8. Thoát");

        float[] arrayScore = new float[100];
        int currentIndex = 0;
        float total = 0;
        float averageScore = 0;
        float minScore = Float.MAX_VALUE;
        float maxScore = Float.MIN_VALUE;
        int passed = 0;
        int excellent = 0;
        do {
            System.out.print("Mời nhập số menu : ");
            int choose = scanner.nextInt();

            switch (choose) {
                case (1):
                    System.out.print("Bạn muốn nhập bao nhiêu : ");
                    int quality = scanner.nextInt();
                    for (int i = 0; i < quality; i++) {
                        System.out.printf("Mời bạn nhập điểm thứ %d : ", i + 1);
                        arrayScore[i] = scanner.nextFloat();
                        currentIndex += 1;
                        total += arrayScore[i];
                        if (arrayScore[i] < minScore) {
                            minScore = arrayScore[i];
                        }
                        if (arrayScore[i] > maxScore) {
                            maxScore = arrayScore[i];
                        }
                        if (arrayScore[i] >= 5){
                            passed += 1;
                        }
                        if (arrayScore[i] >= 8) {
                            excellent += 1;
                        }
                    }
                    break;
                case (2):
                    if (currentIndex != 0) {
                        System.out.println("Danh sách điểm sinh viên : ");
                        for (int i = 0; i < currentIndex; i++) {
                            System.out.printf("Điểm sinh viên thứ %d : %.1f\n", i + 1, arrayScore[i]);
                        }
                    } else {
                        System.out.println("Chưa có dữ liệu.");
                    }
                    break;
                case (3):
                    if (currentIndex != 0) {
                        averageScore = total / currentIndex;
                        System.out.println(averageScore);
                    } else {
                        System.out.println("Chưa có dữ liệu.");
                    }
                    break;
                case (4):
                    System.out.printf("Điểm cao nhất là %.1f \n", maxScore);
                    System.out.printf("Điểm thấp nhất là %.1f \n", minScore);
                    break;
                case (5):
                    System.out.printf("Số sinh viên đạt : %d \n", passed);
                    System.out.printf("Số sinh viên trượt : %d \n", currentIndex - passed);
                    break;
                case (6):
                    boolean swapped;
                    for (int i = 0; i < currentIndex - 1; i++) {
                        swapped = false;
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (arrayScore[i] > arrayScore[j]){
                                float temp = arrayScore[i];
                                arrayScore[i] = arrayScore[j];
                                arrayScore[j] = temp;
                                swapped = true;
                            }
                        }
                        if (!swapped) break;
                    }
                    break;
                case (7):
                    System.out.printf("Số sinh viên giỏi và xuất sắc là %d \n", excellent);
                    break;
                case (8):
                    System.exit(0);
                    break;
                default:
                    System.out.println("Số này không tồn tại.");
            }
        } while (true);

    }
}
