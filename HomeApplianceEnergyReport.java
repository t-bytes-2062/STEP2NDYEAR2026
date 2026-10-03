import java.util.Scanner;

abstract class Appliance {
    protected double power;

    Appliance(double power) {
        this.power = power;
    }

    abstract String getType();

    boolean supportsSaverMode() {
        return false;
    }

    double calculateUnits(double hours, boolean saver) {

        double units = (power * hours) / 1000;

        if (saver) {
            units = units * 0.75;
        }

        return units;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {

    Fridge() {
        super(150);
    }

    @Override
    String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance {

    AC() {
        super(1500);
    }

    @Override
    String getType() {
        return "AC";
    }

    @Override
    boolean supportsSaverMode() {
        return true;
    }
}

class TV extends Appliance {

    TV() {
        super(100);
    }

    @Override
    String getType() {
        return "TV";
    }
}

class Washer extends Appliance {

    Washer() {
        super(500);
    }

    @Override
    String getType() {
        return "WASHER";
    }

    @Override
    boolean supportsSaverMode() {
        return true;
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];
        double[] hours = new double[n];
        boolean[] saver = new boolean[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double h = sc.nextDouble();

            boolean useSaver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                useSaver = true;
            }

            appliances[i] = createAppliance(type);
            hours[i] = h;
            saver[i] = useSaver;
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            Appliance appliance = appliances[i];

            if (saver[i] && !appliance.supportsSaverMode()) {

                System.out.println(
                    appliance.getType() +
                    ": saver mode not supported"
                );

                continue;
            }

            double units =
                appliance.calculateUnits(hours[i], saver[i]);

            double cost =
                appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                appliance.getType(),
                units,
                cost
            );

            totalCost += cost;
        }

        System.out.printf(
            "Total Cost: %.2f%n",
            totalCost
        );

        sc.close();
    }

    static Appliance createAppliance(String type) {

        switch (type) {

            case "FRIDGE":
                return new Fridge();

            case "AC":
                return new AC();

            case "TV":
                return new TV();

            case "WASHER":
                return new Washer();
        }

        return null;
    }
}
