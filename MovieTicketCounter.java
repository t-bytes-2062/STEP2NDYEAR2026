import java.util.Scanner;

abstract class Ticket {
    protected int count;

    private static final double CONVENIENCE_FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    abstract String getType();

    double getTotal() {
        return (getPrice() + CONVENIENCE_FEE) * count;
    }
}

class Regular extends Ticket {

    Regular(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 150;
    }

    @Override
    String getType() {
        return "REGULAR";
    }
}

class Premium extends Ticket {

    Premium(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 250;
    }

    @Override
    String getType() {
        return "PREMIUM";
    }
}

class Recliner extends Ticket {

    Recliner(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 400;
    }

    @Override
    String getType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int count = sc.nextInt();

            switch (type) {
                case "REGULAR":
                    tickets[i] = new Regular(count);
                    break;

                case "PREMIUM":
                    tickets[i] = new Premium(count);
                    break;

                case "RECLINER":
                    tickets[i] = new Recliner(count);
                    break;
            }
        }

        double total = 0;

        for (Ticket ticket : tickets) {

            double amount = ticket.getTotal();

            System.out.printf("%s: %.2f%n",
                    ticket.getType(), amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
