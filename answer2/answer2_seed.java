public class answer2_seed {
    static class Student {
        String id;
        String name;
        double assignment;
        double midExam;
        double finalExam;
        double finalScore;
        String grade;

        void calculateFinalScore() {
            finalScore = (assignment * 0.20) + (midExam * 0.30) + (finalExam * 0.50);
        }

        void calculateGrade() {
            if (finalScore >= 90) {
                grade = "A";
            } else if (finalScore >= 85) {
                grade = "A";
            } else if (finalScore >= 80) {
                grade = "B+";
            } else if (finalScore >= 75) {
                grade = "B";
            } else if (finalScore >= 70) {
                grade = "B";
            } else if (finalScore >= 65) {
                grade = "C";
            } else if (finalScore >= 51) {
                grade = "D";
            } else {
                grade = "E";
            }
        }
    }

    // Method untuk membuat objek Student dengan data yang diberikan
    static Student createStudent(String id, String name, double assignment, double midExam, double finalExam) {
        Student student = new Student();
        student.id = id;
        student.name = name;
        student.assignment = assignment;
        student.midExam = midExam;
        student.finalExam = finalExam;
        student.calculateFinalScore();
        student.calculateGrade();
        return student;
    }

    public static void main(String[] args) {
        Student[] students = new Student[30];

        // Input data mahasiswa pertama secara manual
        students[0] = createStudent("STD001", "Rafael", 90, 88, 92);
        // Input data mahasiswa lainnya secara otomatis menggunakan loop
        for (int i = 1; i < students.length; i++) {
            String id = String.format("STD%03d", i + 1);
            String name = "test" + i;
            double assignment = 60 + i;
            double midExam = 62 + i;
            double finalExam = 64 + i;

            students[i] = createStudent(id, name, assignment, midExam, finalExam);
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("DATA NILAI MAHASISWA");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-15s %-10s%n", "ID", "Name", "Nilai Akhir", "Grade");
        System.out.println("--------------------------------------------------------------");

        // Menampilkan data mahasiswa menggunakan loop for-each
        for (Student student : students) {
            System.out.printf(
                    "%-10s %-20s %-15.2f %-10s%n",
                    student.id,
                    student.name,
                    student.finalScore,
                    student.grade
            );
        }
    }
}
