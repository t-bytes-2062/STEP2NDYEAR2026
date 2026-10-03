abstract class Staff {
    protected String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTime extends Staff {
    private double weeklySalary;

    FullTime(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    double calculatePay() {
        return weeklySalary;
    }
}

class Hourly extends Staff {
    private double hours;
    private double rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class Intern extends Staff {
    private double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {

        Staff[] staff = {
            new FullTime("Asha", 12000),
            new Hourly("Ravi", 45, 200),
            new Intern("Neha", 5000)
        };

        double total = 0;

        for (Staff person : staff) {
            double pay = person.calculatePay();

            System.out.printf("%s: %.2f%n",
                    person.name, pay);

            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
