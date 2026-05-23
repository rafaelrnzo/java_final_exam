public class Payment {
    private String paymentMethod;
    private double amount;
    private String paymentStatus;

    // Membuat data pembayaran untuk proses membership
    public Payment(String paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentStatus = "Pending";
    }

    // Memproses pembayaran dan mengubah status menjadi Paid jika berhasil
    public boolean processPayment() {
        if (!paymentMethod.equalsIgnoreCase("Credit Card")
                && !paymentMethod.equalsIgnoreCase("QRIS")
                && !paymentMethod.equalsIgnoreCase("Virtual Account")) {
            System.out.println("Metode pembayaran tidak valid.");
            return false;
        }

        System.out.println("Memproses pembayaran menggunakan " + paymentMethod + "...");
        System.out.printf("Total pembayaran: Rp%.0f%n", amount);
        System.out.println("Pembayaran berhasil.");
        paymentStatus = "Paid";
        return true;
    }
}
