public class Topic {
    private String topicId;
    private String topicName;
    private String level;
    private boolean taskCompleted;

    // Membuat data topik pembelajaran dalam sistem MLS
    public Topic(String topicId, String topicName, String level) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.level = level;
        this.taskCompleted = false;
    }

    // Menandai bahwa tugas topik sudah diselesaikan
    public void markTaskCompleted() {
        taskCompleted = true;
    }

    // Mengembalikan status penyelesaian tugas topik
    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    // Menampilkan informasi topik ke console
    public void displayTopic() {
        System.out.println(topicId + " - " + topicName + " (" + level + ") - "
                + (taskCompleted ? "Selesai" : "Belum Selesai"));
    }

    // Mengambil ID topik
    public String getTopicId() {
        return topicId;
    }

    // Mengambil nama topik
    public String getTopicName() {
        return topicName;
    }

    // Mengambil level topik
    public String getLevel() {
        return level;
    }
}
