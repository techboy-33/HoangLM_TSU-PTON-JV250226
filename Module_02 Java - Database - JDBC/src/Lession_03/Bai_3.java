package Lession_03;

import java.util.Scanner;

public class Bai_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***************MENU NHẬP LƯƠNG***************");
        System.out.println("1. Nhập lương nhân viên");
        System.out.println("2. Hiển thị thống kê");
        System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
        System.out.println("4. Thoát");
        boolean flag = true;
        boolean flagMoney = true;
        int employeeIputed = 0;
        float maxMoney = 0;
        float minMoney = 0;
        float total = 0;
        float bonus = 0;
        do {
            System.out.print("Lựa chọn của bạn : ");
            int choose = scanner.nextInt();
            switch (choose) {
                case (1):
                    System.out.println("----Nhập lương nhân viên (nhập -1 để dừng)----");
                    do {
                        System.out.print("Nhập lương : ");
                        float money = scanner.nextFloat();

                        if (money >= 0 && money <= 500000000) {
                            employeeIputed += 1;

                            if (money < 5000000) {
                                System.out.println("Thu nhập thấp");
                            } else if (money >= 5000000 && money < 15000000) {
                                System.out.println("Thu nhập trung bình");
                            } else if (money >= 15000000 && money <= 50000000) {
                                System.out.println("Thu nhập khá");
                            } else {
                                System.out.println("Thu nhập cao");
                            }
                            flagMoney = true;
                            total += money;

                            if (money >= 0) {
                                if (money < 5000000) {
                                    bonus += money * 0.05F;
                                } else if (money >= 5000000 && money < 15000000) {
                                    bonus += money * 0.1F;
                                } else if (money >= 15000000 && money < 50000000) {
                                    bonus += money * 0.15F;
                                } else if (money >= 50000000 && money <= 100000000) {
                                    bonus += money * 0.20F;
                                } else {
                                    bonus += money * 0.25F;
                                }
                            }
                            if (maxMoney < money) {
                                maxMoney = money;
                            }
                            if ( minMoney < money) {
                                minMoney = money;
                            }
                        } else if (money == -1) {
                            flagMoney = false;
                        } else {
                            System.out.println("Lương không hợp lệ. Nhập lại.");
                        }
                    } while (flagMoney);
                    break;
                case (2):
                    System.out.println("---Thống kê---");
                    if (employeeIputed == 0) {
                        System.out.println("Chưa có dữ liệu.");
                    } else {
                        System.out.printf("Số nhân viên đã nhập : %d \n", employeeIputed);
                        System.out.printf("Tổng tiền lương : %,.2f VND  \n", total);
                        System.out.printf("Lương trung bình : %,.2f VND  \n", total / employeeIputed);
                        System.out.printf("Lương cao nhất : %,.2f VND  \n", maxMoney);
                        System.out.printf("Lương thấp nhất : %,.2f VND  \n", minMoney);

                    }
                    break;
                case (3):
                    System.out.println("--- Tính tổng số tiền thưởng nhân viên ---");
                    System.out.printf("Tổng tiền thưởng nhân viên: %,.2f VND \n", bonus);
                    break;
                case (4):
                    System.out.print("Kết thúc chương trình.");
                    flag = false;
                    break;
                default:
                    System.out.println("Nhập sai rồi.");
            }
        } while (flag);
    }
}
