package Lession_03;

import java.util.Scanner;

public class bai_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.printf("Nhập tên sản phẩm: ");
        String bookName = scanner.nextLine();
        System.out.printf("Nhập giá: ");
        int price = scanner.nextInt();
        System.out.printf("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        System.out.printf("Khách hàng có thẻ thành viên (true/false): ");
        boolean menberCard = scanner.nextBoolean();

        int total = price * quantity;
        int sale = 0;
        if (menberCard == true) {
            sale = total * 10 /100;
        }
        int tax = total * 8/100;
        int allPrice = total - sale + tax;
        System.out.printf("=============== HÓA ĐƠN =================");
        System.out.printf("Khách hàng : %s \n", name);
        System.out.printf("Sản phẩm : %s \n", bookName);
        System.out.printf("Số lượng : %,d \n", quantity);
        System.out.printf("Đơn giá : %s VND \n", myMethod(price));
        System.out.printf("Thành tiền : %s \n", myMethod(total));
        System.out.printf("Giảm giá thành viên : %s \n", myMethod(sale));
        System.out.printf("Tiền VAT (8%%) : %s \n", myMethod(tax));
        System.out.printf("Tổng thanh toán : %s \n", myMethod(allPrice));
        System.out.printf("========================================");
    }
//    Em viết chơi để luyện tư duy thôi ạ, chứ e hỏi chat gpt %,d + số là giải quyết được vấn đề luôn :))

    public static String myMethod(int number) {
        String n = Integer.toString(number);
        String returnNumber = "";
        int flag = 0;
        int length = n.length();
        for (int i = length-1; i >= 0 ; i--) {
            returnNumber += n.charAt(i);
            flag += 1;
            if (flag == 3 && i != 0) {
                returnNumber += ",";
                flag = 0;
            }
        }
        String reversed = new StringBuilder(returnNumber).reverse().toString();
        return reversed;
    }
}

