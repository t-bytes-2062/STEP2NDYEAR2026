abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {

    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return daysLate * 2;
    }
}

class DVD extends LibraryItem {

    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        double fine = daysLate * 5;

        if (fine > 50) {
            fine = 50;
        }

        return fine;
    }
}

class Magazine extends LibraryItem {

    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return daysLate;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {

        LibraryItem[] items = {
            new Book("Algebra", 4),
            new DVD("Inception", 12),
            new Magazine("Sports", 3)
        };

        double total = 0;

        for (LibraryItem item : items) {
            double fine = item.calculateFine();

            System.out.printf("%s: %.2f%n",
                    item.title, fine);

            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
    }
}
