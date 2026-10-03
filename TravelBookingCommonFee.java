abstract class TravelBooking {
    protected double distance;

    private static final double BOOKING_FEE = 50;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getMode();

    double getTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends TravelBooking {

    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 2 * distance;
    }

    @Override
    String getMode() {
        return "BUS";
    }
}

class Train extends TravelBooking {

    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 1.5 * distance;
    }

    @Override
    String getMode() {
        return "TRAIN";
    }
}

class Flight extends TravelBooking {

    Flight(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 2500 + (4 * distance);
    }

    @Override
    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {

        TravelBooking[] bookings = {
            new Bus(200),
            new Train(300),
            new Flight(500)
        };

        for (TravelBooking booking : bookings) {
            System.out.printf("%s: %.2f%n",
                    booking.getMode(),
                    booking.getTotal());
        }
    }
}
