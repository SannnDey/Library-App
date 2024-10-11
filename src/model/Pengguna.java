package model;
public class Pengguna {
    private String nama;
    private boolean isAdmin;

    public Pengguna(String nama, boolean isAdmin) {
        this.nama = nama;
        this.isAdmin = isAdmin;
    }

    public String getNama() {
        return nama;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
