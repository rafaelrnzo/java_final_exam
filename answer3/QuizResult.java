public class QuizResult {
    private String topicName;
    private int score;
    private int totalQuestions;
    private double percentage;

    // Membuat hasil kuis berdasarkan topik, skor, dan jumlah soal
    public QuizResult(String topicName, int score, int totalQuestions) {
        this.topicName = topicName;
        this.score = score;
        this.totalQuestions = totalQuestions;
        if (totalQuestions == 0) {
            this.percentage = 0;
        } else {
            this.percentage = (double) score / totalQuestions * 100;
        }
    }

    // Menampilkan hasil kuis ke console
    public void displayResult() {
        System.out.println("Topik           : " + topicName);
        System.out.println("Skor            : " + score + " / " + totalQuestions);
        System.out.printf("Persentase      : %.2f%%%n", percentage);
        System.out.println("----------------------------------------");
    }

    // Mengambil nama topik pada hasil kuis
    public String getTopicName() {
        return topicName;
    }

    // Mengambil skor hasil kuis
    public int getScore() {
        return score;
    }

    // Mengambil total jumlah soal hasil kuis
    public int getTotalQuestions() {
        return totalQuestions;
    }

    // Mengambil persentase nilai hasil kuis
    public double getPercentage() {
        return percentage;
    }
}
