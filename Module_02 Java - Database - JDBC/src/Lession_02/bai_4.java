package Lession_02;

import java.util.Scanner;

public class bai_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.printf("Hãy nhập vào 1 số nguyên : ");
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                if (n <= 0){
                    System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0.");
//                    scanner.next();
                } else {
                    System.out.printf("Tuổi của bạn là %d ", n);
                    flag = false;
                }
            } else {
                System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0.");
                scanner.next();
            }

//            String age = scanner.nextLine();
//            if (age.isEmpty() || age.matches(".*[a-zA-Z].*")) {
//                flag = true;
//            } else {
//                int trueAge = Integer.parseInt(age);
//                if (trueAge <= 0) {
//                    System.out.printf("Vui lòng nhập vào một số nguyên  và lớn hơn 0 : ");
//                } else {
//                    flag = false;
//                    System.out.printf("Tuổi của bạn là %d", trueAge);
//                }
//            }
        } while (flag);
    }
}
