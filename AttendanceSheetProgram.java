import java.util.Scanner;

class AttendanceSheet {

    private String[] presentStudents;
    private int presentCount;

    AttendanceSheet(int maxStudents) {
        presentStudents = new String[maxStudents];
        presentCount = 0;
    }

    public void markPresent(String name) {

        // Check if already present
        if (isPresent(name)) {
            return;
        }

        // Check if there is space
        if (presentCount >= presentStudents.length) {
            System.out.println("Attendance sheet is full.");
            return;
        }

        presentStudents[presentCount] = name;
        presentCount++;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {

        for (int i = 0; i < presentCount; i++) {

            if (presentStudents[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class AttendanceSheetProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum class size: ");
        int max = sc.nextInt();
        sc.nextLine();

        AttendanceSheet sheet =
                new AttendanceSheet(max);

        System.out.print("Enter number of students to mark: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            sheet.markPresent(name);
        }

        System.out.println(
                "Present count: "
                + sheet.getPresentCount()
        );

        System.out.print("Enter name to check: ");
        String name = sc.nextLine();

        System.out.println(
                "Is present: "
                + sheet.isPresent(name)
        );

        sc.close();
    }
}
