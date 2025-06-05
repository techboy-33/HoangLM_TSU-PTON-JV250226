package Session_08.bai_4;

public class Main {
    public static void main(String[] args) {
        BankAccount acA = new BankAccount("A001", "Nguyễn Văn A", "0123456789");
        BankAccount acB = new BankAccount("B001", "Nguyễn Văn B", "01442456789");

        acA.deposit(1000);

        double transferAmount = 300;
        acA.withdraw(transferAmount);
        acB.deposit(transferAmount);

        acA.displayBalance();
        acB.displayBalance();
    }
}
