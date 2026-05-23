import java.util.ArrayList;

public class Parent extends User {
    private Membership membership;
    private ArrayList<Student> children;

    // Membuat data parent beserta membership dan daftar anak
    public Parent(String username, String password, String fullName, Membership membership) {
        super(username, password, fullName);
        this.membership = membership;
        this.children = new ArrayList<Student>();
    }

    // Mengambil data membership milik parent
    public Membership getMembership() {
        return membership;
    }

    // Mengambil daftar anak yang terhubung dengan parent
    public ArrayList<Student> getChildren() {
        return children;
    }

    // Menambahkan data anak baru ke parent
    public void addChild(Student child) {
        children.add(child);
    }

    // Menampilkan profil parent ke console
    public void displayParentProfile() {
        System.out.println("Nama Parent   : " + fullName);
        System.out.println("Username      : " + username);
        System.out.println("Jumlah Anak   : " + children.size());
    }
}
