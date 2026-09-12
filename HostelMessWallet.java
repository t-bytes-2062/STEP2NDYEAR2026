import java.util.Scanner;

class MessWallet {

    private double balance;

    public MessWallet(double openingBalance) {

        if (openingBalance < 0) {
            System.out.println("Warning: Negative balance not allowed.");
            balance = 0;
        } else {
            balance = openingBalance;
        }
    }

    public void topUp(double amount) {

        if (amount <= 0) {
            System.out.println("Top-up rejected: invalid amount");
        } else {
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    public void deduct(double amount) {

        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Deduct rejected: invalid amount");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class HostelMessWallet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter opening balance: ");
        double opening = sc.nextDouble();

        MessWallet wallet = new MessWallet(opening);

        System.out.print("Enter top-up amount: ");
        double topUpAmount = sc.nextDouble();

        wallet.topUp(topUpAmount);

        System.out.print("Enter deduction amount: ");
        double deduction = sc.nextDouble();

        wallet.deduct(deduction);

        System.out.println("Final balance: "
                + wallet.getBalance());

        sc.close();
    }
}
