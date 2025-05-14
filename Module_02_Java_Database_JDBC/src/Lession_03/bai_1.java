package Lession_03;

import java.util.Scanner;

public class bai_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------Nhập thông tin sinh viên---------");
        System.out.println("Nhập mã sinh viên : ");
        String studentNumber = scanner.nextLine();
        System.out.println("Nhập tên sinh viên : ");
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại sinh viên : ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ngày sinh sinh viên (dd/mm/yyyy): ");
        String birthday = scanner.nextLine();
        System.out.println("Nhập giới tính sinh viên (1: Nam, 0: Nữ) : ");
        int choosed = scanner.nextInt();
        String gender = "";
        switch (choosed) {
            case (1) :
                gender = "Nam";
                break;
            case (0) :
                gender = "Nam";
                break;
            default:
                gender = "Đã nhập sai thông tin, hãy kiểm tra lại";
        }

        System.out.println("---------Nhập điểm sinh viên---------");
        System.out.println("Nhập điểm toán : ");
        double mathPoint = scanner.nextDouble();
        System.out.println("Nhập điểm vậy lý : ");
        double physicsPoint = scanner.nextDouble();
        System.out.println("Nhập điểm hóa : ");
        double chemistryPoint = scanner.nextDouble();
        System.out.println("Nhập điểm sinh học : ");
        double biologyPoint = scanner.nextDouble();
        System.out.println("Nhập điểm ngoại ngữ : ");
        double languagePoint = scanner.nextDouble();

        double averagePoint = ( mathPoint + physicsPoint + chemistryPoint + biologyPoint + languagePoint ) /5;

        System.out.println("---------Hiển thị thông tin sinh viên---------");
        System.out.printf("Mã sinh viên : %s | Tên sinh viên : %s | Giới tính : %s \n", studentNumber, name, gender);
        System.out.printf("Ngày sinh : %s | Số điện thoại : %d \n", birthday, phoneNumber);
        System.out.printf("Điểm toán : %.2f | Điểm Vật lý : %.2f | Điểm Hóa học : %.2f | Điểm Sinh học : %.2f | Điểm Ngoại ngữ : %.2f \n", mathPoint, physicsPoint, chemistryPoint, biologyPoint, languagePoint );
        System.out.printf("Điểm trung bình : %.2f", averagePoint);
    }
}
