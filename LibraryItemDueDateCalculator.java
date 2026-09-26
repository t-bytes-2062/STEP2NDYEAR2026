import java.util.Scanner;
import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;
    protected LocalDate currentDate;

    LibraryItem(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    abstract LocalDate getDueDate();

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {

    Book(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    @Override
    LocalDate getDueDate() {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {

    DVD(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    @Override
    LocalDate getDueDate() {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {

    Magazine(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    @Override
    LocalDate getDueDate() {
        return currentDate.plusDays(3);
    }
}

public class LibraryItemDueDateCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        int n = sc.nextInt();
        sc.nextLine();

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1);

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            switch (type) {
                case "BOOK":
                    items[i] = new Book(title, currentDate);
                    break;

                case "DVD":
                    items[i] = new DVD(title, currentDate);
                    break;

                case "MAGAZINE":
                    items[i] = new Magazine(title, currentDate);
                    break;
            }
        }

        for (LibraryItem item : items) {
            System.out.println(
                item.getTitle() + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}
