import java.util.Scanner;

abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class Bus extends Transport {

    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    @Override
    String getType() {
        return "BUS";
    }
}

class Train extends Transport {

    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    String getType() {
        return "METRO";
    }
}

public class PublicTransportFareCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Transport[] journeys = new Transport[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            switch (type) {
                case "BUS":
                    journeys[i] = new Bus(distance);
                    break;

                case "TRAIN":
                    journeys[i] = new Train(distance);
                    break;

                case "METRO":
                    double peakHourFactor = sc.nextDouble();
                    journeys[i] = new Metro(distance, peakHourFactor);
                    break;
            }
        }

        double total = 0;

        for (Transport journey : journeys) {
            double fare = journey.calculateFare();

            System.out.printf("%s: %.2f%n",
                    journey.getType(), fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
