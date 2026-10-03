abstract class Connection {
    protected int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();
}

class Home extends Connection {

    Home(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }

        return (100 * 5) + ((units - 100) * 7);
    }

    @Override
    String getType() {
        return "HOME";
    }
}

class Shop extends Connection {

    Shop(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return (units * 8) + 100;
    }

    @Override
    String getType() {
        return "SHOP";
    }
}

class Factory extends Connection {

    Factory(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        double bill = units * 6;

        if (bill < 1000) {
            bill = 1000;
        }

        return bill;
    }

    @Override
    String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {

        Connection[] connections = {
            new Home(150),
            new Shop(90),
            new Factory(120)
        };

        double total = 0;

        for (Connection connection : connections) {
            double bill = connection.calculateBill();

            System.out.printf("%s: %.2f%n",
                    connection.getType(), bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
