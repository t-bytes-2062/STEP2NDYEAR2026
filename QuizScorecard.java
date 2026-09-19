import java.util.Scanner;

class Scorecard {

    private boolean[] results;
    private int answerCount;
    private int score;

    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answerCount = 0;
        score = 0;
    }

    void recordAnswer(boolean correct) {

        if (answerCount >= results.length) {
            System.out.println("No more answers can be recorded.");
            return;
        }

        results[answerCount] = correct;
        answerCount++;

        if (correct) {
            score++;
        }
    }

    int getScore() {
        return score;
    }
}

public class QuizScorecard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();

        Scorecard scorecard = new Scorecard(n);

        for (int i = 0; i < n; i++) {

            System.out.print("Enter answer result (true/false): ");
            boolean answer = sc.nextBoolean();

            scorecard.recordAnswer(answer);
        }

        System.out.println("Final score: " + scorecard.getScore());

        sc.close();
    }
}
