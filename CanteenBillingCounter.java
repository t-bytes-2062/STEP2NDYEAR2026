import java.util.*;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();

    abstract String getType();
}

class Student extends Customer {

    Student(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.90;
    }

    @Override
    String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {

    Staff(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.95;
    }

    @Override
    String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {

    Guest(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + 10;
    }

    @Override
    String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    customers[i] = new Student(amount);
                    break;

                case "STAFF":
                    customers[i] = new Staff(amount);
                    break;

                case "GUEST":
                    customers[i] = new Guest(amount);
                    break;
            }
        }

        double grandTotal = 0;

        for (Customer customer : customers) {
            double finalAmount = customer.calculateFinalAmount();

            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);

            grandTotal += finalAmount;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}
