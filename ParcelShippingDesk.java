import java.util.Scanner;

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    abstract double calculateInsurance();

    abstract String getType();

    double getTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

class StandardParcel extends Parcel {

    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 40 + (10 * weight);
    }

    @Override
    double calculateInsurance() {
        return 0;
    }

    @Override
    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel {

    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 80 + (15 * weight);
    }

    @Override
    double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel {

    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    @Override
    double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            switch (type) {

                case "STANDARD":
                    parcels[i] =
                        new StandardParcel(weight, declaredValue);
                    break;

                case "EXPRESS":
                    parcels[i] =
                        new ExpressParcel(weight, declaredValue);
                    break;

                case "FRAGILE":
                    parcels[i] =
                        new FragileParcel(weight, declaredValue);
                    break;
            }
        }

        double grandTotal = 0;

        for (Parcel parcel : parcels) {

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.getTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                parcel.getType(),
                charge,
                insurance,
                total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}
