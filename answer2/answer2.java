import java.util.Scanner;

class Student {
    // Atribut untuk menyimpan data mahasiswa
    String id; // ID mahasiswa
    String name; // Nama mahasiswa
    double assignment; // Nilai tugas
    double midExam; // Nilai UTS
    double finalExam; // Nilai UAS
    double finalScore; // Nilai akhir yang dihitung berdasarkan bobot
    String grade;  // Grade yang ditentukan berdasarkan nilai akhir

    // kode ini digunakan untuk menghitung nilai akhir mahasiswa
    // berdasarkan bobot Assignment 20%, Mid Exam 30%, dan Final Exam 50%.
    void calculateFinalScore() {
        finalScore = (assignment * 0.20) + (midExam * 0.30) + (finalExam * 0.50);
    }

    // kode ini digunakan untuk menentukan grade mahasiswa
    // berdasarkan nilai akhir yang sudah dihitung.
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

// Kelas utama untuk menjalankan program
public class answer2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Student[] students = new Student[30];
       
        // Input data mahasiswa menggunakan loop
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();

            System.out.println("Input data mahasiswa ke-" + (i + 1));

            System.out.print("ID: ");
            students[i].id = input.nextLine();

            System.out.print("Name: ");
            students[i].name = input.nextLine();

            System.out.print("Assignment: ");
            students[i].assignment = Double.parseDouble(input.nextLine());

            System.out.print("Mid Exam: ");
            students[i].midExam = Double.parseDouble(input.nextLine());

            System.out.print("Final Exam: ");
            students[i].finalExam = Double.parseDouble(input.nextLine());

            students[i].calculateFinalScore();
            students[i].calculateGrade();

            System.out.println();
        }

        // Menampilkan data mahasiswa
        System.out.println("DATA NILAI MAHASISWA");
        System.out.printf("%-10s %-20s %-15s %-10s%n", "ID", "Name", "Nilai Akhir", "Grade");
        System.out.println("--------------------------------------------------------------");

        // Menampilkan data mahasiswa menggunakan loop for-each
        for (int i = 0; i < students.length; i++) {
            System.out.printf(
                    "%-10s %-20s %-15.2f %-10s%n",
                    students[i].id,
                    students[i].name,
                    students[i].finalScore,
                    students[i].grade
            );
        }

        // Menutup scanner setelah selesai digunakan
        input.close();
    }
}
