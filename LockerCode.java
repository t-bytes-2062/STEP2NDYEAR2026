import java.util.Scanner;

class Locker {

    private String code;
    private final int lockerNumber;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String currentCode, String newCode) {

        if (code.equals(currentCode)) {
            code = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerCode {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter locker number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter current code: ");
        String code = sc.nextLine();

        Locker locker = new Locker(number, code);

        System.out.print("Enter current code to change: ");
        String currentCode = sc.nextLine();

        System.out.print("Enter new code: ");
        String newCode = sc.nextLine();

        locker.changeCode(currentCode, newCode);

        sc.close();
    }
}
