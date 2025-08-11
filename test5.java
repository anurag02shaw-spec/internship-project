import java.util.ArrayList;

class Account {
    private String accountHolder;  // Account holder ka naam
    private double balance;        // Account ka balance
    private ArrayList<String> transactionHistory; // Transaction ka record store karega

    // Constructor - account create karte time naam aur starting balance set karega
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account banaya gaya with balance: " + initialBalance);
    }

    // Deposit method - paise jama karne ke liye
    public void deposit(double amount) {
        if (amount > 0) { // agar amount positive hai
            balance += amount; // balance me add karo
            transactionHistory.add("Deposit kiya: " + amount + " | Naya Balance: " + balance);
            System.out.println("Deposit hua ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount."); // galat input
        }
    }

    // Withdraw method - paise nikalne ke liye
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // agar amount sahi hai aur balance me paise hain
            balance -= amount; // balance me se paise hatao
            transactionHistory.add("Withdraw kiya: " + amount + " | Naya Balance: " + balance);
            System.out.println("Withdraw hua ₹" + amount);
        } else {
            System.out.println("Invalid withdraw amount ya insufficient funds."); // galat input ya kam balance
        }
    }

    // Balance check karne ke liye method
    public double getBalance() {
        return balance;
    }

    // Saare transaction ka record print karne ke liye
    public void printTransactionHistory() {
        System.out.println("\nTransaction History for " + accountHolder + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

// Test Class
public class test5 {
    public static void main(String[] args) {
        // Naya account create kiya
        Account acc = new Account("Anurag Shaw", 1000);

        acc.deposit(500);   // 500 deposit kiya
        acc.withdraw(200);  // 200 withdraw kiya
        acc.deposit(1000);  // 1000 deposit kiya
        acc.withdraw(3000); // yeh fail hoga kyunki paise kam hain

        System.out.println("\nCurrent Balance: ₹" + acc.getBalance()); // balance check kiya
        acc.printTransactionHistory(); // saari transactions ka record print kiya
    }
}
