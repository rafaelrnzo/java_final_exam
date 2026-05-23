import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private String quizId;
    private String quizTitle;
    private String topicName;
    private ArrayList<String> questions;
    private ArrayList<String> correctAnswers;

    // Membuat data kuis untuk topik tertentu
    public Quiz(String quizId, String quizTitle, String topicName) {
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.topicName = topicName;
        this.questions = new ArrayList<String>();
        this.correctAnswers = new ArrayList<String>();
    }

    // Menambahkan pertanyaan dan jawaban benar ke kuis
    public void addQuestion(String question, String correctAnswer) {
        questions.add(question);
        correctAnswers.add(correctAnswer);
    }

    // Mengambil ID kuis
    public String getQuizId() {
        return quizId;
    }

    // Mengambil judul kuis
    public String getQuizTitle() {
        return quizTitle;
    }

    // Mengambil nama topik untuk kuis
    public String getTopicName() {
        return topicName;
    }

    // Menjalankan kuis, menerima jawaban user, lalu mengembalikan hasil kuis
    public QuizResult startQuiz(Scanner scanner) {
        int score = 0;

        System.out.println("========================================");
        System.out.println("Memulai " + quizTitle);
        System.out.println("Topik: " + topicName);
        System.out.println("========================================");

        for (int questionIndex = 0; questionIndex < questions.size(); questionIndex++) {
            System.out.println((questionIndex + 1) + ". " + questions.get(questionIndex));
            System.out.print("Jawaban Anda: ");
            String studentAnswer = scanner.nextLine().trim();
            String correctAnswer = correctAnswers.get(questionIndex).trim();

            if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
                score++;
            }
        }

        return new QuizResult(topicName, score, questions.size());
    }
}
