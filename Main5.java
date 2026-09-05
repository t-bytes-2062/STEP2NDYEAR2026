import java.util.Arrays;
import java.util.Scanner;

public class Main5 {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        double compositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                other.compositeScore(),
                this.compositeScore()
            );
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        int count = 0;

        // Count eligible candidates
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa) ||
                Candidate.isEligible(c.cgpa, c.codingScore)) {
                count++;
            }
        }

        // Create shortlisted array
        Candidate[] shortlisted = new Candidate[count];

        int index = 0;

        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa) ||
                Candidate.isEligible(c.cgpa, c.codingScore)) {
                shortlisted[index++] = c;
            }
        }

        // Sort using Comparable
        Arrays.sort(shortlisted);

        // Create output
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1)
                  .append(". ")
                  .append(shortlisted[i].name)
                  .append(" (")
                  .append(shortlisted[i].compositeScore())
                  .append(")");

            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println("\nShortlisted Candidates:");
        System.out.println(shortlistAndRank(candidates));

        sc.close();
    }
}
