package model;

import java.util.ArrayList;
import java.util.List;

public class Pengguna {
    private String nama;
    private boolean isAdmin;
    private static List<Buku> daftarBuku = new ArrayList<>();

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

    public void tambahBuku(Buku buku) {
        if (isAdmin) {
            for (Buku b : daftarBuku) {
                if (b.getId() == buku.getId()) {
                    System.out.println("Buku dengan ID " + buku.getId() + " sudah ada. Tidak dapat menambahkan buku.");
                    return;
                }
            }
            daftarBuku.add(buku);
            System.out.println("Buku \"" + buku.getJudul() + "\" ditambahkan ke pustaka.");
        } else {
            System.out.println("Hanya admin yang dapat menambahkan buku.");
        }
    }

    public void hapusBuku(int id) {
        if (isAdmin) {
            for (Buku buku : daftarBuku) {
                if (buku.getId() == id) {
                    daftarBuku.remove(buku);
                    System.out.println("Buku \"" + buku.getJudul() + "\" dihapus dari pustaka.");
                    return;
                }
            }
            System.out.println("Buku dengan ID " + id + " tidak ditemukan.");
        } else {
            System.out.println("Hanya admin yang dapat menghapus buku.");
        }
    }

    public void daftarBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada buku di pustaka.");
        } else {
            System.out.println("Daftar Buku:");
            for (Buku buku : daftarBuku) {
                System.out.println("ID: " + buku.getId() + ", Judul: " + buku.getJudul() + ", Pengarang: "
                        + buku.getPengarang() + ", Dipinjam: " + (buku.isDipinjam() ? "Ya" : "Tidak"));
            }
        }
    }

    public void pinjamBuku(int id) {
        if (!isAdmin) {
            for (Buku buku : daftarBuku) {
                if (buku.getId() == id) {
                    buku.pinjam();
                    return;
                }
            }
            System.out.println("Buku dengan ID " + id + " tidak ditemukan.");
        } else {
            System.out.println("Admin tidak dapat meminjam buku.");
        }
    }

    public void kembalikanBuku(int id) {
        if (!isAdmin) {
            for (Buku buku : daftarBuku) {
                if (buku.getId() == id) {
                    buku.kembalikan();
                    return;
                }
            }
            System.out.println("Buku dengan ID " + id + " tidak ditemukan.");
        } else {
            System.out.println("Admin tidak dapat mengembalikan buku.");
        }
    }
}
