import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double evaluate();
}

class MCQ extends Question {

    MCQ(String questionText, String correctAnswer,
        String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double evaluate() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TF extends Question {

    TF(String questionText, String correctAnswer,
       String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double evaluate() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay extends Question {

    Essay(String questionText, String correctAnswer,
          String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double evaluate() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class ExaminationQuestionGrader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            String[] remaining = parts[6].trim().split("\\s+");
            double points = Double.parseDouble(remaining[0]);

            switch (type) {
                case "MCQ":
                    questions[i] = new MCQ(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    );
                    break;

                case "TF":
                    questions[i] = new TF(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    );
                    break;

                case "ESSAY":
                    questions[i] = new Essay(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    );
                    break;
            }
        }

        double totalScore = 0;

        for (Question question : questions) {
            double score = question.evaluate();

            System.out.printf("%s: %.2f%n",
                    question instanceof MCQ ? "MCQ" :
                    question instanceof TF ? "TF" : "ESSAY",
                    score);

            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}
