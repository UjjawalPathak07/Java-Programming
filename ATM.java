import java.util.Scanner;
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class Account {
    String accountHolderName;
    double accountBalance;

    Account(String accountHolderName, double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }
    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount cannot be negative or zero.");
            return;
        }
        if (amount > accountBalance) {
            throw new InsufficientBalanceException(
                "Insufficient balance."
            );
        }
        accountBalance = accountBalance - amount;
        System.out.println("Withdrawal successful.");
        System.out.println("Remaining Balance: ₹" + accountBalance);
    }
    void displayBalance() {
        System.out.println("Current Balance: ₹" + accountBalance);
    }
}
public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account("Rahul", 10000);
        
        int choice;
        do {
            System.out.println("\n ATM MENU ");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Check Balance");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ₹");
                    double amount = sc.nextDouble();
                    try {
                        account.withdraw(amount);
                    } 
                    catch (InsufficientBalanceException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    account.displayBalance();
                    break;
                case 3:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
        sc.close();
    }
}