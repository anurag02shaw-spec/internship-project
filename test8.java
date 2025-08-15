import java.util.*;

class Question {
    String questionText;
    List<String> options;
    char correctOption;

    Question(String questionText, List<String> options, char correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> quiz = new ArrayList<>();

        // 1. Add questions
        quiz.add(new Question(
                "What is the capital of France?",
                Arrays.asList("A) Berlin", "B) Madrid", "C) Paris", "D) Rome"),
                'C'
        ));

        quiz.add(new Question(
                "Which planet is known as the Red Planet?",
                Arrays.asList("A) Venus", "B) Mars", "C) Jupiter", "D) Saturn"),
                'B'
        ));

        quiz.add(new Question(
                "Who wrote 'Romeo and Juliet'?",
                Arrays.asList("A) Charles Dickens", "B) William Shakespeare", "C) Jane Austen", "D) Mark Twain"),
                'B'
        ));

        int score = 0;

        // 2. Ask questions
        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }
            System.out.print("Your answer (A/B/C/D): ");
            char answer = Character.toUpperCase(sc.next().charAt(0));

            if (answer == q.correctOption) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.correctOption);
            }
        }

        // 3. Show score
        System.out.println("\nYour Score: " + score + "/" + quiz.size());

        // 4. Grade outcome
        double percentage = (score * 100.0) / quiz.size();
        if (percentage >= 80) {
            System.out.println("Outcome: A");
        } else if (percentage >= 60) {
            System.out.println("Outcome: B");
        } else if (percentage >= 40) {
            System.out.println("Outcome: C");
        } else {
            System.out.println("Outcome: F");
        }

        sc.close();
    }
}

