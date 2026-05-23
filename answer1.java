import java.util.Scanner;

public class InputIntDenganNextLine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan umur: ");
        String umurText = input.nextLine(); // membaca input sebagai String

        int umur = Integer.parseInt(umurText); // mengubah String menjadi int

        System.out.println("Umur yang dimasukkan adalah: " + umur);
        System.out.println("Umur tahun depan: " + (umur + 1));

        input.close();
    }
}