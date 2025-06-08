package Session_11.bai_3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MessageManagement management = new MessageManagement();

        while (true) {
            String sender = InputData.getString(scanner, "Nhập tên người gửi (hoặc 'exit' để thoát: ");
            if (sender.equalsIgnoreCase("exit")) {
                System.out.print("Cám ơn bạn đã sử dụng chương trình !");
                break;
            }
            String content = InputData.getString(scanner, "Nhập nội dung tin nhắn: ");
            management.sendMessage(sender, content);

            String command = InputData.getString(scanner, "Nhập 'history' để xem lịch sử, hoặc 'filter' để lọc tin nhắn theo người gửi, hoặc 'date' để lọc theo ngày: ");
            switch (command) {
                case "history":
                    management.displayMessages();
                    break;
                case "filter":
                    String filterSender = InputData.getString(scanner, "Nhập tên người gửi để lọc: ");
                    management.filterMessageBySender(filterSender);
                    break;
                case "date":
                    LocalDateTime filterDate = InputData.getDate(scanner, "Nhập ngày (dd-MM-yyyy): ");
                    management.FilterMessageByDate(filterDate);
                    break;
                default:
                    System.out.println("Lệnh không hợp lệ.");
                    break;
            }
        }
        scanner.close();
    }
}
