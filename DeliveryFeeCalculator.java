import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();

    abstract String getType();
}

class Standard extends Delivery {

    Standard(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    String getType() {
        return "STANDARD";
    }
}

class Express extends Delivery {

    Express(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    String getType() {
        return "EXPRESS";
    }
}

class International extends Delivery {
    private double customsFee;

    International(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Delivery[] deliveries = new Delivery[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    deliveries[i] = new Standard(weight, distance);
                    break;

                case "EXPRESS":
                    deliveries[i] = new Express(weight, distance);
                    break;

                case "INTERNATIONAL":
                    double customsFee = sc.nextDouble();
                    deliveries[i] = new International(
                        weight, distance, customsFee
                    );
                    break;
            }
        }

        double total = 0;

        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();

            System.out.printf("%s: %.2f%n",
                    delivery.getType(), fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
