import java.util.Scanner;
import model.Buku;
import model.Pengguna;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        Pengguna admin = new Pengguna("Admin", true);
        admin.tambahBuku(new Buku(1, "Belajar Java", "SannnDey"));
        admin.tambahBuku(new Buku(2, "Pemrograman Berorientasi Objek", "SannnDey"));

        while (true) {
            System.out.print("Masukkan nama Anda: ");
            String nama = scanner.nextLine();

            System.out.print("Apakah Anda admin? (ya/tidak): ");
            boolean isAdmin = scanner.nextLine().equalsIgnoreCase("ya");

            Pengguna pengguna = isAdmin ? admin : new Pengguna(nama, false);

            boolean kembaliKeMenuAwal = false;
            while (true) {
                System.out.println("\nMenu:");
                if (pengguna.isAdmin()) {
                    System.out.println("1. Tambah Buku");
                    System.out.println("2. Hapus Buku");
                    System.out.println("3. Daftar Buku");
                    System.out.println("4. Keluar");
                } else {
                    System.out.println("1. Pinjam Buku");
                    System.out.println("2. Kembalikan Buku");
                    System.out.println("3. Daftar Buku");
                    System.out.println("4. Keluar");
                }

                System.out.print("Pilih opsi: ");
                int opsi = scanner.nextInt();
                scanner.nextLine();
                switch (opsi) {
                    case 1:
                        if (pengguna.isAdmin()) {
                            System.out.print("Masukkan ID Buku: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Judul Buku: ");
                            String judul = scanner.nextLine();
                            System.out.print("Masukkan Pengarang: ");
                            String pengarang = scanner.nextLine();
                            Buku buku = new Buku(id, judul, pengarang);
                            pengguna.tambahBuku(buku);
                        } else {
                            System.out.print("Masukkan ID Buku yang ingin dipinjam: ");
                            int id = scanner.nextInt();
                            pengguna.pinjamBuku(id);
                        }
                        break;
                    case 2:
                        if (pengguna.isAdmin()) {
                            System.out.print("Masukkan ID Buku yang ingin dihapus: ");
                            int id = scanner.nextInt();
                            pengguna.hapusBuku(id);
                        } else {
                            System.out.print("Masukkan ID Buku yang ingin dikembalikan: ");
                            int id = scanner.nextInt();
                            pengguna.kembalikanBuku(id);
                        }
                        break;
                    case 3:
                        pengguna.daftarBuku();
                        break;
                    case 4:
                        System.out.print(
                                "Apakah Anda ingin kembali ke menu awal atau keluar sepenuhnya? (kembali/keluar): ");
                        String pilihan = scanner.nextLine();
                        if (pilihan.equalsIgnoreCase("keluar")) {
                            System.out.println("Terima kasih telah menggunakan aplikasi pustaka.");
                            scanner.close();
                            return;
                        } else if (pilihan.equalsIgnoreCase("kembali")) {
                            System.out.println("Kembali ke menu awal...");
                            kembaliKeMenuAwal = true;
                            break;
                        } else {
                            System.out.println("Opsi tidak valid. Kembali ke menu.");
                        }
                        break;
                    default:
                        System.out.println("Opsi tidak valid. Silakan pilih lagi.");
                }

                if (opsi == 4) {
                    break;
                }
            }

            if (kembaliKeMenuAwal) {
                continue;
            } else {
                break;
            }
        }
    }
}
