package Session_08.bai_4;

public class BankAccount implements IBank{
    private String accountId;
    private double balance;
    private String userName;
    private String phoneNumber;

    public BankAccount(String accountId, String userName, String phoneNumber) {
        this.accountId = accountId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Đã nhận tiền: %.1f \n", amount);
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
        System.out.printf("Đã rút tiền: %.1f \n", amount);
    }

    public void displayBalance() {
        System.out.printf("Số dư tài khoảng (%s): %.1f \n",accountId, balance);
    }
}
