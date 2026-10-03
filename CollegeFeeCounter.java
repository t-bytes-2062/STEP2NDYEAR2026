import java.util.Scanner;

abstract class Student {
    protected String name;

    protected static final double TUITION = 40000;
    protected static final double TRANSPORT_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    double getTransportFee() {
        return 0;
    }

    double getTotalFee() {
        return getTuition() + getTransportFee();
    }
}

class DayScholar extends Student {

    DayScholar(String name) {
        super(name);
    }

    @Override
    double getTuition() {
        return TUITION;
    }

    @Override
    double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    @Override
    double getTuition() {
        return TUITION + 60000;
    }
}

class Scholar extends Student {

    Scholar(String name) {
        super(name);
    }

    @Override
    double getTuition() {
        return 20000;
    }

    @Override
    double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            switch (type) {

                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    students[i] = new Scholar(name);
                    break;
            }
        }

        double total = 0;

        for (Student student : students) {

            double fee = student.getTotalFee();

            System.out.printf("%s: %.2f%n",
                    student.name, fee);

            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);

        sc.close();
    }
}
