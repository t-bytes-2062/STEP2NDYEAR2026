import java.util.Scanner;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    abstract String getType();
}

class Card extends Payment {

    Card(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 1.02;
    }

    @Override
    String getType() {
        return "CARD";
    }
}

class Wallet extends Payment {

    Wallet(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 1.01;
    }

    @Override
    String getType() {
        return "WALLET";
    }
}

class BankTransfer extends Payment {

    BankTransfer(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount;
    }

    @Override
    String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystemFeeCalculation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "CARD":
                    payments[i] = new Card(amount);
                    break;

                case "WALLET":
                    payments[i] = new Wallet(amount);
                    break;

                case "BANKTRANSFER":
                    payments[i] = new BankTransfer(amount);
                    break;
            }
        }

        double total = 0;

        for (Payment payment : payments) {
            double adjustedAmount = payment.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    payment.getType(), adjustedAmount);

            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
