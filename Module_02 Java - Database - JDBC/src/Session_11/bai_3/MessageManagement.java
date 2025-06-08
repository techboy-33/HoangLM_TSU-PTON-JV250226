package Session_11.bai_3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageManagement {
    List<Message> messages = new ArrayList<>();

    public void sendMessage(String sender, String content) {
        Message message = new Message(sender, content);
        messages.add(message);
    }

    public void displayMessages() {
        if (messages.isEmpty()) {
            System.out.println("Không có dữ liệu.");
        }else {
            System.out.println("Lịch sử chat: ");
            for (Message message : messages) {
                System.out.println(message);
            }
        }
    }

    public void filterMessageBySender(String sender) {
        List<Message> filterMessage = messages.stream().filter(msg -> msg.getSender().equalsIgnoreCase(sender)).toList();
        if (filterMessage.isEmpty()) {
            System.out.println("Không có dữ liệu. ");
        }else {
            System.out.println("Tin nhắn từ " + sender);
            filterMessage.forEach(System.out::println);
        }
    }

    public void FilterMessageByDate(LocalDateTime dateTime) {
        List<Message> filterMessage = messages.stream().filter(msg -> msg.getTimestamp().toLocalDate().equals(dateTime.toLocalDate())).toList();
        if (filterMessage.isEmpty()) {
            System.out.println("Không có dữ liệu.");
        }else {
            System.out.println("Tin nhắn trong ngày " + dateTime.toLocalDate() + ":");
            filterMessage.forEach(System.out::println);
        }
    }
}
