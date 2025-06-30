import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MovieManagement movieManager = new MovieManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Movie Management ---");
            System.out.println("1. Add movie");
            System.out.println("2. List movies");
            System.out.println("3. Update movie");
            System.out.println("4. Delete movie");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    movieManager.addMovie(scanner);
                    break;
                case "2":
                    movieManager.listMovies();
                    break;
                case "3":
                    movieManager.updateMovie(scanner);
                    break;
                case "4":
                    movieManager.deleteMovie(scanner);
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again from 1 to 5.");
            }
        }
    }
}
