import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate getRenewalDate();
}

class Basic extends Plan {

    Basic(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class Standard extends Plan {

    Standard(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class Premium extends Plan {

    Premium(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Plan[] plans = new Plan[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            switch (type) {
                case "BASIC":
                    plans[i] = new Basic(name, date);
                    break;

                case "STANDARD":
                    plans[i] = new Standard(name, date);
                    break;

                case "PREMIUM":
                    plans[i] = new Premium(name, date);
                    break;
            }
        }

        for (Plan plan : plans) {
            System.out.println(
                plan.name + ": " + plan.getRenewalDate()
            );
        }

        sc.close();
    }
}
