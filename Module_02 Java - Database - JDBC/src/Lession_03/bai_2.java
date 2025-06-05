package Lession_03;

import java.util.Scanner;

public class bai_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***************MENU NHẬP ĐIỂM***************");
        System.out.println("1. Nhập điểm học viên");
        System.out.println("2. Hiển thị thống kê");
        System.out.println("3. Thoát");
        boolean flag = true;
        boolean flagScore = true;
        int studentIputed = 0;
        float maxScore = 0;
        float minScore = 0;
        float total = 0;
        do {
            System.out.print("Lựa chọn của bạn : ");
            int choose = scanner.nextInt();
            switch (choose) {
                case (1):
                    System.out.println("----Nhập điểm học viên (nhập -1 để dừng)----");
                    do {
                        System.out.print("Nhập điểm : ");
                        float score = scanner.nextFloat();
                        if (score != -1) {
                            studentIputed += 1;
                        }
                        total += score;
                        if (score < maxScore && score != -1) {
                            minScore = score;
                        }
                        if (score > minScore) {
                            maxScore = score;
                        }
                        if (score >= 0 && score <= 10) {
                            if (score < 5) {
                                System.out.println("Học lực : Yếu");
                            } else if (score >= 5 && score < 7) {
                                System.out.println("Học lực : Trung Bình");
                            } else if (score >= 7 && score < 8) {
                                System.out.println("Học lực : Khá");
                            } else if (score >= 8 && score <= 9) {
                                System.out.println("Học lực : Giỏi");
                            } else {
                                System.out.println("Học lực : Xuất sắc");
                            }
                            flagScore = true;
                        } else if (score == -1) {
                            flagScore = false;
                        } else {
                            System.err.print("Điểm không hợp lệ. Nhập lại.");
                        }
                    } while (flagScore);
                    break;
                case (2):
                    System.out.println("---Kết quá---");
                    if (studentIputed == 0) {
                        System.out.println("Chưa có dữ liệu.");
                    } else {
                        System.out.printf("Số học viên đã nhập : %d \n", studentIputed);
                        System.out.printf("Điểm trung bình : %.2f \n", total / studentIputed);
                        System.out.printf("Điểm cao nhất : %.2f \n", maxScore);
                        System.out.printf("Điểm thấp nhất : %.2f \n", minScore);
                    }
                    break;
                case (3):
                    System.out.print("Kết thúc chương trình.");
                    flag = false;
                    break;
                default:
                    System.out.println("Nhập sai rồi.");
            }
        } while (flag);
    }
}
