import java.util.Scanner;

abstract class Cab {
    protected double km;

    protected static final double MINIMUM_FARE = 100;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    abstract String getType();

    boolean offersNightService() {
        return false;
    }

    double calculateFare(boolean night) {

        if (night && !offersNightService()) {
            return -1;
        }

        double fare = km * getRate();

        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }

        if (night) {
            fare = fare * 1.20;
        }

        return fare;
    }
}

class Mini extends Cab {

    Mini(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 10;
    }

    @Override
    String getType() {
        return "MINI";
    }
}

class Sedan extends Cab {

    Sedan(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 14;
    }

    @Override
    String getType() {
        return "SEDAN";
    }

    @Override
    boolean offersNightService() {
        return true;
    }
}

class SUV extends Cab {

    SUV(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 18;
    }

    @Override
    String getType() {
        return "SUV";
    }

    @Override
    boolean offersNightService() {
        return true;
    }
}

public class CityCabFareMeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Cab[] cabs = new Cab[n];
        boolean[] night = new boolean[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            cabs[i] = createCab(type, km);
            night[i] = time.equals("NIGHT");
        }

        double total = 0;

        for (int i = 0; i < n; i++) {

            Cab cab = cabs[i];

            double fare = cab.calculateFare(night[i]);

            if (fare < 0) {

                System.out.println(
                    cab.getType() +
                    ": night service not available"
                );

            } else {

                System.out.printf(
                    "%s: %.2f%n",
                    cab.getType(),
                    fare
                );

                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }

    static Cab createCab(String type, double km) {

        switch (type) {

            case "MINI":
                return new Mini(km);

            case "SEDAN":
                return new Sedan(km);

            case "SUV":
                return new SUV(km);
        }

        return null;
    }
}
