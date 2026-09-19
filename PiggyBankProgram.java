import java.util.Scanner;

class PiggyBank {

    private double savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    void deposit(double amount) {
        savings += amount;
    }

    void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected");
        } else {
            savings -= amount;
        }
    }

    double getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }
}

public class PiggyBankProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Piggy Bank ID: ");
        String id = sc.nextLine();

        PiggyBank pb = new PiggyBank(id);

        System.out.print("Enter deposit amount: ");
        double deposit = sc.nextDouble();
        pb.deposit(deposit);

        System.out.println("Savings = " + pb.getSavings());

        System.out.print("Enter withdrawal amount: ");
        double withdraw = sc.nextDouble();
        pb.withdraw(withdraw);

        System.out.println("Savings = " + pb.getSavings());

        sc.close();
    }
}
