class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double accountBalance;
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = initialBalance;
    }
    
    public synchronized void deposit(String userName, double amount) {
        if (amount <= 0) {
            System.out.println(userName + " attempted invalid deposit amount: ₹" + amount + ". Transaction failed.");
            return;
        }
        accountBalance += amount;
        System.out.println(userName + " deposited ₹" + amount + " | Updated Balance: ₹" + accountBalance);
    }

    public synchronized void withdraw(String userName, double amount) {
        if (amount <= 0) {
            System.out.println(userName + " attempted invalid withdrawal amount: ₹" + amount + ". Transaction failed.");
            return;
        }
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println(userName + " withdrew ₹" + amount + " | Updated Balance: ₹" + accountBalance);
        } else {
            System.out.println(userName + " attempted to withdraw ₹" + amount + " | Insufficient Balance! Current Balance: ₹" + accountBalance);
        }
    }
    public void displayBalance() {
        System.out.println("Final Account Balance: ₹" + accountBalance);
    }
    public double getAccountBalance() {
        return accountBalance;
    }
}
class UserTransaction implements Runnable {
    private String userName;
    private BankAccount account;
    private String transactionType;
    private double amount;
    public UserTransaction(String userName, BankAccount account, String transactionType, double amount) {
        this.userName = userName;
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }
    @Override
    public void run() {
        if (transactionType.equalsIgnoreCase("Deposit")) {
            account.deposit(userName, amount);
        } else if (transactionType.equalsIgnoreCase("Withdraw")) {
            account.withdraw(userName, amount);
        }
    }
}
public class Program9 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount("ACC1987", "Paul", 10000);
        Thread t1 = new Thread(new UserTransaction("User1", account, "Deposit", 2000));
        Thread t2 = new Thread(new UserTransaction("User2", account, "Withdraw", 3000));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        account.displayBalance();
    }
}