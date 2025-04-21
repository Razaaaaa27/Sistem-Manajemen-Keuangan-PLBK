import java.util.List;

public class GeneratorLaporan implements PembuatLaporan {
    private PembacaTransaksi dataSource;

    public GeneratorLaporan(PembacaTransaksi dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void tampilkanLaporan() {
        System.out.println("=== Laporan Keuangan ===");
        List<String> data = dataSource.bacaData();
        for (String line : data) {
            String[] bagian = line.split(",");
            if (bagian.length >= 5) {
                System.out.println("Waktu     : " + bagian[0]);
                System.out.println("Deskripsi : " + bagian[1]);
                System.out.println("Jumlah    : Rp" + bagian[2]);
                System.out.println("Kategori  : " + bagian[3]);
                System.out.println("Tipe      : " + bagian[4]);
                System.out.println("----------------------------");
            }
        }
    }

    @Override
    public void hitungSaldo() {
        double saldo = 0;
        List<String> data = dataSource.bacaData();
        for (String line : data) {
            String[] bagian = line.split(",");
            if (bagian.length >= 5) {
                double jumlah = Double.parseDouble(bagian[2]);
                if (bagian[4].equalsIgnoreCase("PEMASUKAN")) {
                    saldo += jumlah;
                } else if (bagian[4].equalsIgnoreCase("PENGELUARAN")) {
                    saldo -= jumlah;
                }
            }
        }
        System.out.println("Saldo akhir: Rp" + String.format("%.0f", saldo));
    }
}
