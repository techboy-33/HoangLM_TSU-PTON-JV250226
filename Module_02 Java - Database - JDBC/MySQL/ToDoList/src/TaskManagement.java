import java.sql.*;
import java.util.Scanner;

public class TaskManagement {
    public void addTask(String taskName, String status) {
        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{call add_task(?, ?)}");
            stmt.setString(1, taskName);
            stmt.setString(2, status);
            stmt.executeUpdate();
            System.out.println("Task added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listTasks() {
        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{call list_tasks()}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Task task = new Task(rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
                task.display();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTaskStatus(int taskId, String status) {
        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{call update_task_status(?, ?)}");
            stmt.setInt(1, taskId);
            stmt.setString(2, status);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Task updated.");
            else System.out.println("Task not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int taskId) {
        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{call delete_task(?)}");
            stmt.setInt(1, taskId);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Task deleted.");
            else System.out.println("Task not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchTaskByName(String taskName) {
        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{call search_task_by_name(?)}");
            stmt.setString(1, taskName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Task task = new Task(rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
                task.display();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void taskStatistics() {
        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{call task_statistics()}");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Completed: " + rs.getInt("completed"));
                System.out.println("Pending: " + rs.getInt("pending"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}