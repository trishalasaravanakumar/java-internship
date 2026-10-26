import java.util.*;
class Question {
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    int answer;
    Question(String question, String option1, String option2, String option3, String option4, int answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }
}
public class OnlineQuizApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Which language is used for Android development?",
                "Java", "HTML", "SQL", "CSS", 1));
        questions.add(new Question(
                "Which keyword is used to create a class in Java?",
                "function", "class", "new", "object", 2));
        questions.add(new Question(
                "Which data type is used to store whole numbers?",
                "double", "String", "int", "boolean", 3));
        questions.add(new Question(
                "Which symbol is used for single-line comments in Java?",
                "//", "/*", "#", "<!--", 1));
        questions.add(new Question(
                "Which collection stores elements in key-value pairs?",
                "ArrayList", "HashMap", "Stack", "Queue", 2));
        int score = 0;
        System.out.println("===== Online Quiz Application =====");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.question);
            System.out.println("1. " + q.option1);
            System.out.println("2. " + q.option2);
            System.out.println("3. " + q.option3);
            System.out.println("4. " + q.option4);
            System.out.print("Enter your answer: ");
            int userAnswer = in.nextInt();
            if (userAnswer == q.answer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }
        System.out.println("\n===== Quiz Result =====");
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.size() - score));
        System.out.println("Score: " + score + "/" + questions.size());
        if (score >= 4) {
            System.out.println("Result: Excellent!");
        } else if (score >= 3) {
            System.out.println("Result: Good!");
        } else {
            System.out.println("Result: Try Again!");
        }
        in.close();
    }
}
