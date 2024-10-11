package model;
public class Buku {
    private int id;
    private String judul;
    private String pengarang;
    private boolean isDipinjam;

    public Buku(int id, String judul, String pengarang) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.isDipinjam = false;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public boolean isDipinjam() {
        return isDipinjam;
    }

    public void pinjam() {
        if (!isDipinjam) {
            isDipinjam = true;
            System.out.println("Buku \"" + judul + "\" berhasil dipinjam.");
        } else {
            System.out.println("Buku \"" + judul + "\" sudah dipinjam.");
        }
    }

    public void kembalikan() {
        if (isDipinjam) {
            isDipinjam = false;
            System.out.println("Buku \"" + judul + "\" berhasil dikembalikan.");
        } else {
            System.out.println("Buku \"" + judul + "\" tidak sedang dipinjam.");
        }
    }
}
