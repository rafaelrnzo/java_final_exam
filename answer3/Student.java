import java.util.ArrayList;

public class Student extends User {
    private int age;
    private String educationLevel;
    private ArrayList<Topic> enrolledTopics;
    private ArrayList<QuizResult> quizResults;

    // Membuat data student beserta daftar topik dan hasil kuis
    public Student(String username, String password, String fullName, int age, String educationLevel) {
        super(username, password, fullName);
        this.age = age;
        this.educationLevel = educationLevel;
        this.enrolledTopics = new ArrayList<Topic>();
        this.quizResults = new ArrayList<QuizResult>();
    }

    // Mengambil usia student
    public int getAge() {
        return age;
    }

    // Mengambil jenjang pendidikan student
    public String getEducationLevel() {
        return educationLevel;
    }

    // Mengambil daftar topik yang diikuti student
    public ArrayList<Topic> getEnrolledTopics() {
        return enrolledTopics;
    }

    // Mengambil daftar hasil kuis milik student
    public ArrayList<QuizResult> getQuizResults() {
        return quizResults;
    }

    // Menambahkan topik ke daftar topik student jika belum ada
    public void addTopic(Topic topic) {
        for (Topic enrolledTopic : enrolledTopics) {
            if (enrolledTopic.getTopicName().equalsIgnoreCase(topic.getTopicName())) {
                return;
            }
        }
        enrolledTopics.add(topic);
    }

    // Menambahkan hasil kuis baru ke student
    public void addQuizResult(QuizResult quizResult) {
        quizResults.add(quizResult);
    }

    // Menampilkan profil student ke console
    public void displayStudentProfile() {
        System.out.println("Nama Student      : " + fullName);
        System.out.println("Username          : " + username);
        System.out.println("Usia              : " + age);
        System.out.println("Jenjang Pendidikan: " + educationLevel);
    }
}
