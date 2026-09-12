import java.util.Scanner;

class Employee {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public Employee(String empId,
                    String empName,
                    double salary) {

        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {

        this(empId, empName, 0);

        this.isIntern = true;
    }

    public void printProfile() {

        System.out.println(
                empId + " | "
                + empName + " | Rs "
                + salary + " | Intern: "
                + isIntern
        );
    }
}

public class EmployeeProfileCreation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter permanent employee ID: ");
        String id1 = sc.nextLine();

        System.out.print("Enter permanent employee name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        Employee permanent =
                new Employee(id1, name1, salary);

        System.out.print("Enter intern ID: ");
        String id2 = sc.nextLine();

        System.out.print("Enter intern name: ");
        String name2 = sc.nextLine();

        Employee intern =
                new Employee(id2, name2);

        permanent.printProfile();
        intern.printProfile();

        sc.close();
    }
}
