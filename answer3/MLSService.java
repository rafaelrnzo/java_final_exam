import java.util.ArrayList;
import java.util.Scanner;

public class MLSService {
    private ArrayList<Parent> parents;
    private ArrayList<Student> students;
    private ArrayList<Topic> topics;
    private ArrayList<Quiz> quizzes;
    private Scanner scanner;

    // Membuat service utama MLS, scanner, dan data dummy awal
    public MLSService() {
        this.parents = new ArrayList<Parent>();
        this.students = new ArrayList<Student>();
        this.topics = new ArrayList<Topic>();
        this.quizzes = new ArrayList<Quiz>();
        this.scanner = new Scanner(System.in);
        seedData();
    }

    // Menyiapkan data dummy parent, student, membership, topic, dan quiz
    private void seedData() {
        Membership membership = new Membership("Active", "2026-01-01", "2026-12-31", true);
        Parent parent = new Parent("parent1", "parent123", "Budi Santoso", membership);
        Student student = new Student("child1", "child123", "Andi Santoso", 10, "SD");

        parent.addChild(student);

        parents.add(parent);
        students.add(student);

        topics.add(new Topic("TP001", "Penjumlahan Dasar", "SD"));
        topics.add(new Topic("TP002", "Pengurangan Dasar", "SD"));
        topics.add(new Topic("TP003", "Pecahan", "SD"));
        topics.add(new Topic("TP004", "Aljabar Dasar", "SMP"));
        topics.add(new Topic("TP005", "Trigonometri", "SMA"));

        Quiz additionQuiz = new Quiz("QZ001", "Kuis Penjumlahan Dasar", "Penjumlahan Dasar");
        additionQuiz.addQuestion("5 + 3 = ?", "8");
        additionQuiz.addQuestion("10 + 7 = ?", "17");
        additionQuiz.addQuestion("12 + 8 = ?", "20");
        quizzes.add(additionQuiz);

        Quiz subtractionQuiz = new Quiz("QZ002", "Kuis Pengurangan Dasar", "Pengurangan Dasar");
        subtractionQuiz.addQuestion("10 - 4 = ?", "6");
        subtractionQuiz.addQuestion("15 - 6 = ?", "9");
        subtractionQuiz.addQuestion("20 - 9 = ?", "11");
        quizzes.add(subtractionQuiz);
    }

    // Menjalankan menu utama aplikasi MLS
    public void startApplication() {
        boolean applicationRunning = true;

        while (applicationRunning) {
            System.out.println("========================================");
            System.out.println("MathChamp Learning System (MLS)");
            System.out.println("========================================");
            System.out.println("1. Login sebagai Parent");
            System.out.println("2. Login sebagai Student");
            System.out.println("3. Keluar");

            int mainMenuChoice = readIntegerInput("Pilih menu: ");

            switch (mainMenuChoice) {
                case 1:
                    Parent loggedInParent = parentLogin();
                    if (loggedInParent != null) {
                        parentMenu(loggedInParent);
                    }
                    break;
                case 2:
                    Student loggedInStudent = studentLogin();
                    if (loggedInStudent != null) {
                        studentMenu(loggedInStudent);
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan MLS.");
                    applicationRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    pauseScreen();
                    break;
            }
        }
    }

    // Menampilkan menu parent dan memproses fitur parent
    private void parentMenu(Parent parent) {
        boolean parentSessionActive = true;

        while (parentSessionActive) {
            System.out.println("========================================");
            System.out.println("Menu Parent - " + parent.getFullName());
            System.out.println("========================================");
            System.out.println("1. Lihat status membership");
            System.out.println("2. Beli atau perpanjang membership");
            System.out.println("3. Atur profil anak");
            System.out.println("4. Lihat progress pembelajaran anak");
            System.out.println("5. Lihat hasil assessment / kuis anak");
            System.out.println("6. Logout");

            int parentMenuChoice = readIntegerInput("Pilih menu: ");

            switch (parentMenuChoice) {
                case 1:
                    parent.getMembership().displayMembershipStatus();
                    pauseScreen();
                    break;
                case 2:
                    purchaseOrRenewMembership(parent);
                    pauseScreen();
                    break;
                case 3:
                    manageChildProfile(parent);
                    break;
                case 4:
                    viewChildLearningProgress(parent);
                    pauseScreen();
                    break;
                case 5:
                    viewChildQuizResults(parent);
                    pauseScreen();
                    break;
                case 6:
                    System.out.println("Logout parent berhasil.");
                    parentSessionActive = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    pauseScreen();
                    break;
            }
        }
    }

    // Menampilkan menu student dan memproses fitur student
    private void studentMenu(Student student) {
        boolean studentSessionActive = true;

        while (studentSessionActive) {
            System.out.println("========================================");
            System.out.println("Menu Student - " + student.getFullName());
            System.out.println("========================================");
            System.out.println("1. Lihat daftar topik");
            System.out.println("2. Selesaikan tugas topik");
            System.out.println("3. Kerjakan kuis");
            System.out.println("4. Lihat hasil kuis saya");
            System.out.println("5. Logout");

            int studentMenuChoice = readIntegerInput("Pilih menu: ");

            switch (studentMenuChoice) {
                case 1:
                    viewAvailableTopics(student);
                    pauseScreen();
                    break;
                case 2:
                    completeTopicTask(student);
                    pauseScreen();
                    break;
                case 3:
                    takeQuiz(student);
                    pauseScreen();
                    break;
                case 4:
                    displayStudentQuizResults(student);
                    pauseScreen();
                    break;
                case 5:
                    System.out.println("Logout student berhasil.");
                    studentSessionActive = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    pauseScreen();
                    break;
            }
        }
    }

    // Menjalankan proses login untuk parent berdasarkan username dan password
    private Parent parentLogin() {
        System.out.println("========================================");
        System.out.println("Login Parent");
        System.out.println("========================================");
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        for (Parent parent : parents) {
            if (parent.login(inputUsername, inputPassword)) {
                System.out.println("Login parent berhasil.");
                pauseScreen();
                return parent;
            }
        }

        System.out.println("Login gagal.");
        pauseScreen();
        return null;
    }

    // Menjalankan proses login untuk student berdasarkan username dan password
    private Student studentLogin() {
        System.out.println("========================================");
        System.out.println("Login Student");
        System.out.println("========================================");
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        for (Student student : students) {
            if (student.login(inputUsername, inputPassword)) {
                System.out.println("Login student berhasil.");
                pauseScreen();
                return student;
            }
        }

        System.out.println("Login gagal.");
        pauseScreen();
        return null;
    }

    // Memproses pembelian atau perpanjangan membership untuk parent
    private void purchaseOrRenewMembership(Parent parent) {
        System.out.println("========================================");
        System.out.println("Pembelian / Perpanjangan Membership");
        System.out.println("========================================");
        System.out.println("1. Credit Card");
        System.out.println("2. QRIS");
        System.out.println("3. Virtual Account");

        int paymentChoice = readIntegerInput("Pilih metode pembayaran: ");
        String paymentMethod = getPaymentMethodByChoice(paymentChoice);

        if (paymentMethod == null) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Payment payment = new Payment(paymentMethod, 299000);
        boolean paymentSuccess = payment.processPayment();

        if (!paymentSuccess) {
            return;
        }

        Membership membership = parent.getMembership();
        if (membership.isActive()) {
            System.out.print("Masukkan tanggal akhir baru (format YYYY-MM-DD): ");
            String newEndDate = scanner.nextLine();
            membership.renewMembership(newEndDate);
            System.out.println("Membership berhasil diperpanjang.");
        } else {
            System.out.print("Masukkan tanggal mulai baru (format YYYY-MM-DD): ");
            String startDate = scanner.nextLine();
            System.out.print("Masukkan tanggal akhir baru (format YYYY-MM-DD): ");
            String endDate = scanner.nextLine();
            membership.activateMembership(startDate, endDate);
            System.out.println("Membership berhasil diaktifkan.");
        }
    }

    // Mengelola profil anak, termasuk melihat daftar anak dan menambah anak baru
    private void manageChildProfile(Parent parent) {
        boolean childProfileMenuActive = true;

        while (childProfileMenuActive) {
            System.out.println("========================================");
            System.out.println("Atur Profil Anak");
            System.out.println("========================================");
            System.out.println("1. Lihat daftar anak");
            System.out.println("2. Tambah anak baru");
            System.out.println("3. Kembali");

            int childMenuChoice = readIntegerInput("Pilih menu: ");

            switch (childMenuChoice) {
                case 1:
                    displayChildren(parent);
                    pauseScreen();
                    break;
                case 2:
                    System.out.print("Masukkan nama lengkap anak: ");
                    String childFullName = scanner.nextLine();
                    int childAge = readIntegerInput("Masukkan usia anak: ");
                    System.out.print("Masukkan education level anak: ");
                    String childEducationLevel = scanner.nextLine();
                    System.out.print("Masukkan username anak: ");
                    String childUsername = scanner.nextLine();
                    System.out.print("Masukkan password anak: ");
                    String childPassword = scanner.nextLine();

                    if (isStudentUsernameTaken(childUsername)) {
                        System.out.println("Username student sudah digunakan.");
                        pauseScreen();
                        break;
                    }

                    Student newChild = new Student(
                            childUsername,
                            childPassword,
                            childFullName,
                            childAge,
                            childEducationLevel
                    );
                    parent.addChild(newChild);
                    students.add(newChild);
                    System.out.println("Data anak berhasil ditambahkan.");
                    pauseScreen();
                    break;
                case 3:
                    childProfileMenuActive = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    pauseScreen();
                    break;
            }
        }
    }

    // Menampilkan progress pembelajaran seluruh anak milik parent
    private void viewChildLearningProgress(Parent parent) {
        if (parent.getChildren().isEmpty()) {
            System.out.println("Belum ada data anak.");
            return;
        }

        System.out.println("========================================");
        System.out.println("Progress Pembelajaran Anak");
        System.out.println("========================================");

        for (Student child : parent.getChildren()) {
            int completedTopics = 0;
            for (Topic topic : child.getEnrolledTopics()) {
                if (topic.isTaskCompleted()) {
                    completedTopics++;
                }
            }

            double progressPercentage = 0;
            if (!topics.isEmpty()) {
                progressPercentage = (double) completedTopics / topics.size() * 100;
            }

            System.out.println("Nama Anak            : " + child.getFullName());
            System.out.println("Jumlah Topik Selesai : " + completedTopics + " / " + topics.size());
            System.out.printf("Progress             : %.2f%%%n", progressPercentage);
            System.out.println("----------------------------------------");
        }
    }

    // Menampilkan seluruh hasil kuis anak milik parent
    private void viewChildQuizResults(Parent parent) {
        if (parent.getChildren().isEmpty()) {
            System.out.println("Belum ada data anak.");
            return;
        }

        System.out.println("========================================");
        System.out.println("Hasil Assessment / Kuis Anak");
        System.out.println("========================================");

        for (Student child : parent.getChildren()) {
            System.out.println("Nama Anak: " + child.getFullName());
            if (child.getQuizResults().isEmpty()) {
                System.out.println("Belum ada hasil kuis.");
            } else {
                for (QuizResult quizResult : child.getQuizResults()) {
                    quizResult.displayResult();
                }
            }
            System.out.println("----------------------------------------");
        }
    }

    // Menampilkan seluruh topik yang tersedia beserta status tugas student
    private void viewAvailableTopics(Student student) {
        System.out.println("========================================");
        System.out.println("Daftar Topik");
        System.out.println("========================================");

        for (int topicIndex = 0; topicIndex < topics.size(); topicIndex++) {
            Topic availableTopic = topics.get(topicIndex);
            Topic studentTopic = findStudentTopic(student, availableTopic.getTopicName());
            String taskStatus = "Belum Selesai";

            if (studentTopic != null && studentTopic.isTaskCompleted()) {
                taskStatus = "Selesai";
            }

            System.out.println((topicIndex + 1) + ". " + availableTopic.getTopicName()
                    + " - " + availableTopic.getLevel()
                    + " - " + taskStatus);
        }
    }

    // Menandai tugas topik sebagai selesai untuk student
    private void completeTopicTask(Student student) {
        if (topics.isEmpty()) {
            System.out.println("Belum ada topik tersedia.");
            return;
        }

        viewAvailableTopics(student);
        int selectedTopicNumber = readIntegerInput("Pilih nomor topik yang ingin diselesaikan: ");

        if (selectedTopicNumber < 1 || selectedTopicNumber > topics.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Topic selectedTopic = topics.get(selectedTopicNumber - 1);
        Topic studentTopic = findStudentTopic(student, selectedTopic.getTopicName());

        if (studentTopic == null) {
            studentTopic = new Topic(
                    selectedTopic.getTopicId(),
                    selectedTopic.getTopicName(),
                    selectedTopic.getLevel()
            );
            student.addTopic(studentTopic);
        }

        studentTopic.markTaskCompleted();
        System.out.println("Topik \"" + selectedTopic.getTopicName() + "\" selesai dipelajari.");
    }

    // Menjalankan quiz yang dipilih student dan menyimpan hasilnya
    private void takeQuiz(Student student) {
        if (quizzes.isEmpty()) {
            System.out.println("Belum ada kuis tersedia.");
            return;
        }

        System.out.println("========================================");
        System.out.println("Daftar Kuis");
        System.out.println("========================================");

        for (int quizIndex = 0; quizIndex < quizzes.size(); quizIndex++) {
            Quiz quiz = quizzes.get(quizIndex);
            System.out.println((quizIndex + 1) + ". " + quiz.getQuizTitle() + " - " + quiz.getTopicName());
        }

        int selectedQuizNumber = readIntegerInput("Pilih nomor kuis: ");
        if (selectedQuizNumber < 1 || selectedQuizNumber > quizzes.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Quiz selectedQuiz = quizzes.get(selectedQuizNumber - 1);
        QuizResult quizResult = selectedQuiz.startQuiz(scanner);
        student.addQuizResult(quizResult);

        System.out.println("Hasil kuis berhasil disimpan.");
        quizResult.displayResult();
    }

    // Memberi jeda agar user dapat membaca output sebelum kembali ke menu
    private void pauseScreen() {
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    // Menampilkan seluruh hasil kuis milik student yang sedang login
    private void displayStudentQuizResults(Student student) {
        System.out.println("========================================");
        System.out.println("Hasil Kuis Saya");
        System.out.println("========================================");

        if (student.getQuizResults().isEmpty()) {
            System.out.println("Belum ada hasil kuis.");
            return;
        }

        for (QuizResult quizResult : student.getQuizResults()) {
            quizResult.displayResult();
        }
    }

    // Menampilkan daftar anak milik parent ke console
    private void displayChildren(Parent parent) {
        if (parent.getChildren().isEmpty()) {
            System.out.println("Belum ada data anak.");
            return;
        }

        for (int childIndex = 0; childIndex < parent.getChildren().size(); childIndex++) {
            System.out.println("Data Anak ke-" + (childIndex + 1));
            parent.getChildren().get(childIndex).displayStudentProfile();
            System.out.println("----------------------------------------");
        }
    }

    // Membaca input angka dengan aman agar program tidak crash saat input salah
    private int readIntegerInput(String promptText) {
        System.out.print(promptText);
        String inputText = scanner.nextLine();

        try {
            return Integer.parseInt(inputText);
        } catch (NumberFormatException exception) {
            System.out.println("Pilihan tidak valid.");
            return -1;
        }
    }

    // Mengubah pilihan angka menjadi nama metode pembayaran
    private String getPaymentMethodByChoice(int paymentChoice) {
        switch (paymentChoice) {
            case 1:
                return "Credit Card";
            case 2:
                return "QRIS";
            case 3:
                return "Virtual Account";
            default:
                return null;
        }
    }

    // Memeriksa apakah username student sudah terpakai
    private boolean isStudentUsernameTaken(String username) {
        for (Student student : students) {
            if (student.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    // Mencari topik milik student berdasarkan nama topik
    private Topic findStudentTopic(Student student, String topicName) {
        for (Topic enrolledTopic : student.getEnrolledTopics()) {
            if (enrolledTopic.getTopicName().equalsIgnoreCase(topicName)) {
                return enrolledTopic;
            }
        }
        return null;
    }
}
