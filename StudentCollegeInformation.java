import java.util.Scanner;

class Student {

    String name;
    double attendance;

    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    Student(String name, double attendance) {

        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    static void printCollegeInfo() {

        System.out.println("College: " + collegeName);
        System.out.println("Students created: "
                + studentCount);
    }
}

public class StudentCollegeInformation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student 1 name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter attendance: ");
        double attendance1 = sc.nextDouble();
        sc.nextLine();

        Student s1 =
                new Student(name1, attendance1);

        System.out.print("Enter student 2 name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter attendance: ");
        double attendance2 = sc.nextDouble();

        Student s2 =
                new Student(name2, attendance2);

        Student.printCollegeInfo();

        sc.close();
    }
}
