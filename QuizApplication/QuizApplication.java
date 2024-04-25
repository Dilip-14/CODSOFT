import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private char correctAnswer;

    public QuizQuestion(String question, List<String> options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = Character.toUpperCase(correctAnswer);
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((char) ('A' + i) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(char answer) {
        return Character.toUpperCase(answer) == correctAnswer;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int score;
    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (QuizQuestion question : questions) {
            System.out.println("\nQuestion:");
            question.displayQuestion();
            System.out.print("Your answer: ");
            char answer = scanner.nextLine().charAt(0);
            if (question.checkAnswer(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. Correct answer: " + question.getCorrectAnswer());
            }
        }
        scanner.close();
    }

    public void displayScore() {
        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

public class QuizApplication {
    public static void main(String[] args) {
       
        QuizQuestion question1 = new QuizQuestion("What is the capital of France?",
                Arrays.asList("London", "Paris", "Berlin", "Rome"), 'B');
        QuizQuestion question2 = new QuizQuestion("Which planet is known as the Red Planet?",
                Arrays.asList("Mars", "Venus", "Mercury", "Jupiter"), 'A');
        QuizQuestion question3 = new QuizQuestion("Who wrote 'To Kill a Mockingbird'?",
                Arrays.asList("Harper Lee", "J.K. Rowling", "Stephen King", "Charles Dickens"), 'A');
                
        List<QuizQuestion> questions = Arrays.asList(question1, question2, question3);
        Quiz quiz = new Quiz(questions);

        quiz.startQuiz();

        quiz.displayScore();
    }
}
