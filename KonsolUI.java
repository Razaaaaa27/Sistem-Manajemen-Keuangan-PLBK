import java.util.Scanner;
import java.util.List;

public class KonsolUI implements UserInterface {
    private PengelolaTransaksi pengelolaTransaksi;
    private PembuatLaporan pembuatLaporan;

    public KonsolUI(PengelolaTransaksi pengelolaTransaksi, PembuatLaporan pembuatLaporan) {
        this.pengelolaTransaksi = pengelolaTransaksi;
        this.pembuatLaporan = pembuatLaporan;
    }

    @Override
    public void tampilkanMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== SISTEM MANAJEMEN KEUANGAN ===");
            System.out.println("1. Tambah Transaksi");
                        System.out.println("2. Laporan Keuangan");
            System.out.println("3. Hitung Saldo");
            System.out.println("4. Edit Transaksi");
            System.out.println("5. Hapus Transaksi");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt(); scanner.nextLine();

            switch (pilihan) {
                case 1:
                    inputTransaksi();
                    break;
                case 2:
                buatLaporan();
                    break;
                case 3:
                hitungSaldo();
                    break;
                case 4:
                    editTransaksi();
                    break;
                case 5:
                    hapusTransaksi();
                    break;
                case 6:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            
        } while (pilihan != 6);
    }

    @Override
public void hitungSaldo() {
    pembuatLaporan.hitungSaldo();
}

    @Override
    public void inputTransaksi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deskripsi: ");
        String deskripsi = scanner.nextLine();

        double jumlah = 0;
        while (true) {
            System.out.print("Jumlah: ");
            String jumlahInput = scanner.nextLine();
            try {
                jumlah = Double.parseDouble(jumlahInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
            }
        }

        System.out.print("Kategori: ");
        String kategori = scanner.nextLine();

        String tipe;
        while (true) {
            System.out.print("Tipe (PEMASUKAN/PENGELUARAN): ");
            tipe = scanner.nextLine().toUpperCase();
            if (tipe.equals("PEMASUKAN") || tipe.equals("PENGELUARAN")) {
                break;
            } else {
                System.out.println("Tipe tidak valid. Harus PEMASUKAN atau PENGELUARAN.");
            }
        }

        pengelolaTransaksi.tambah(deskripsi, jumlah, kategori, tipe);
    }

    

    @Override
    public void buatLaporan() {
        pembuatLaporan.tampilkanLaporan();
    }

    public void editTransaksi() {
        Scanner scanner = new Scanner(System.in);
        tampilkanSemuaTransaksi();
        System.out.print("Pilih indeks transaksi yang ingin diedit: ");
        int index = scanner.nextInt(); scanner.nextLine();
        System.out.print("Deskripsi baru: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Jumlah baru: ");
        double jumlah = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Kategori baru: ");
        String kategori = scanner.nextLine();
        System.out.print("Tipe baru (PEMASUKAN/PENGELUARAN): ");
        String tipe = scanner.nextLine();

        ((ManajemenTransaksi) pengelolaTransaksi).edit(index, deskripsi, jumlah, kategori, tipe);
    }

    public void hapusTransaksi() {
        Scanner scanner = new Scanner(System.in);
        tampilkanSemuaTransaksi();
        System.out.print("Pilih indeks transaksi yang ingin dihapus: ");
        int index = scanner.nextInt(); scanner.nextLine();
        ((ManajemenTransaksi) pengelolaTransaksi).hapus(index);
    }

    private void tampilkanSemuaTransaksi() {
        List<String> data = ((ManajemenTransaksi) pengelolaTransaksi).getSemuaTransaksi();
        System.out.println("\n=== DAFTAR TRANSAKSI ===");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(i + ". " + data.get(i));
        }
    }
}