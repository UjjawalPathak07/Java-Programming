class BankAccount {
    private String accno;
    private String name;
    private double balance;

    public BankAccount(String accno, String name, double balance) {
        this.accno = accno;
        this.name = name;
        this.balance = balance;
    }

    public synchronized void deposit(String userName, double amount) {
        if (amount <= 0) {
            System.out.println(userName + " attempted invalid deposit amount: ₹" + amount);
            return;
        }
        balance += amount;
        System.out.println(userName + " deposited: ₹" + amount + " | Updated Balance: ₹" + balance);
    }

    public synchronized void withdraw(String userName, double amount) {
        if (amount <= 0) {
            System.out.println(userName + " attempted invalid withdrawal amount: ₹" + amount);
            return;
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println(userName + " withdrew: ₹" + amount + " | Updated Balance: ₹" + balance);
        } else {
            System.out.println(userName + " attempted to withdraw ₹" + amount + " -> Insufficient Balance! Current Balance: ₹" + balance);
        }
    }

    public void displayBalance() {
        System.out.println("Final Account Balance: ₹" + balance);
    }
}

class UserTransaction extends Thread {
    private String userName;
    private BankAccount account;
    private String transactionType;
    private double transactionAmount;

    public UserTransaction(String userName, BankAccount account, String transactionType, double transactionAmount) {
        this.userName = userName;
        this.account = account;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    @Override
    public void run() {
        if (transactionType.equalsIgnoreCase("Deposit")) {
            account.deposit(userName, transactionAmount);
        } else if (transactionType.equalsIgnoreCase("Withdraw")) {
            account.withdraw(userName, transactionAmount);
        } else {
            System.out.println("Invalid transaction type for user: " + userName);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Online Banking System Simulation ---");

        BankAccount sharedAccount = new BankAccount("ACC1001", "John Doe", 10000.00);

        UserTransaction user1 = new UserTransaction("User1", sharedAccount, "Deposit", 2000);
        UserTransaction user2 = new UserTransaction("User2", sharedAccount, "Withdraw", 3000009);
        UserTransaction user3 = new UserTransaction("User3", sharedAccount, "Deposit", 1000);

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted: " + e.getMessage());
        }
        sharedAccount.displayBalance();
    }
}