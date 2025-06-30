import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManagement manager = new TaskManagement();

        while (true) {
            System.out.println("\n===== TO-DO LIST MENU =====");
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Update task status");
            System.out.println("4. Delete task");
            System.out.println("5. Search task by name");
            System.out.println("6. Task statistics");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter status (hoan thanh / chua hoan thanh): ");
                    String status = scanner.nextLine();
                    manager.addTask(name, status);
                    break;
                case "2":
                    manager.listTasks();
                    break;
                case "3":
                    System.out.print("Enter task ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new status: ");
                    String newStatus = scanner.nextLine();
                    manager.updateTaskStatus(id, newStatus);
                    break;
                case "4":
                    System.out.print("Enter task ID: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    manager.deleteTask(deleteId);
                    break;
                case "5":
                    System.out.print("Enter name to search: ");
                    String keyword = scanner.nextLine();
                    manager.searchTaskByName(keyword);
                    break;
                case "6":
                    manager.taskStatistics();
                    break;
                case "7":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
