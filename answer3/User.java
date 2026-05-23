public class User {
    protected String username;
    protected String password;
    protected String fullName;

    // Membuat data dasar user untuk sistem MLS
    public User(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    // Mengambil username milik user
    public String getUsername() {
        return username;
    }

    // Mengambil password milik user
    public String getPassword() {
        return password;
    }

    // Mengambil nama lengkap milik user
    public String getFullName() {
        return fullName;
    }

    // Mengubah nama lengkap milik user
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Mengubah password milik user
    public void setPassword(String password) {
        this.password = password;
    }

    // Memeriksa kecocokan username dan password saat login
    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}
