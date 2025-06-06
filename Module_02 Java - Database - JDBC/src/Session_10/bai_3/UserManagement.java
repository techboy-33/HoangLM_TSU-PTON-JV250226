package Session_10.bai_3;

import java.util.LinkedList;
import java.util.List;

public class UserManagement {
    private List<User> users;

    public UserManagement() {
        users = new LinkedList<>();
    }

    public void addUser (User user) {
        users.add(user);
    }
    public boolean deleteUser (String email) {
        return users.removeIf(user -> user.getEmail().equals(email));
    }

    public void displayUser () {
        if (users.isEmpty()) {
            System.out.println("Chưa có dữ liệu");
        }else {
            System.out.println("Danh sách người dùng:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
