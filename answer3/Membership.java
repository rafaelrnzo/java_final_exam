public class Membership {
    private String status;
    private String startDate;
    private String endDate;
    private boolean active;

    // Membuat data membership awal untuk parent
    public Membership(String status, String startDate, String endDate, boolean active) {
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    // Mengaktifkan membership dengan tanggal mulai dan tanggal akhir baru
    public void activateMembership(String startDate, String endDate) {
        this.status = "Active";
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = true;
    }

    // Memperpanjang membership dengan tanggal akhir yang baru
    public void renewMembership(String newEndDate) {
        this.status = "Active";
        this.endDate = newEndDate;
        this.active = true;
    }

    // Mengembalikan status aktif membership
    public boolean isActive() {
        return active;
    }

    // Mengambil status membership
    public String getStatus() {
        return status;
    }

    // Mengambil tanggal mulai membership
    public String getStartDate() {
        return startDate;
    }

    // Mengambil tanggal akhir membership
    public String getEndDate() {
        return endDate;
    }

    // Menampilkan status membership ke console
    public void displayMembershipStatus() {
        System.out.println("Status Membership : " + status);
        System.out.println("Tanggal Mulai     : " + startDate);
        System.out.println("Tanggal Akhir     : " + endDate);
        System.out.println("Aktif             : " + (active ? "Ya" : "Tidak"));
    }
}
