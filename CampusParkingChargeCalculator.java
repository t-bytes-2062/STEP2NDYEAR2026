import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();

    abstract String getType();
}

class Bike extends Vehicle {

    Bike(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return hours * 10;
    }

    @Override
    String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {

    Car(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return 30 + (hours - 1) * 20;
    }

    @Override
    String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {

    Truck(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }

    @Override
    String getType() {
        return "TRUCK";
    }
}

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            switch (type) {
                case "BIKE":
                    vehicles[i] = new Bike(hours);
                    break;

                case "CAR":
                    vehicles[i] = new Car(hours);
                    break;

                case "TRUCK":
                    vehicles[i] = new Truck(hours);
                    break;
            }
        }

        double total = 0;

        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n",
                    vehicle.getType(), charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
