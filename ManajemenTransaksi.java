import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManajemenTransaksi implements PengelolaTransaksi {
    private DataPersistence penyimpanan;

    public ManajemenTransaksi(DataPersistence penyimpanan) {
        this.penyimpanan = penyimpanan;
    }

    @Override
    public void tambah(String deskripsi, double jumlah, String kategori, String tipe) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktu = LocalDateTime.now().format(formatter);
        String data = waktu + "," + deskripsi + "," + String.format("%.0f", jumlah) + "," + kategori + "," + tipe;
        penyimpanan.simpanData(data);
    }

    public void hapus(int index) {
        List<String> semuaData = penyimpanan.bacaData();
        if (index >= 0 && index < semuaData.size()) {
            semuaData.remove(index);
            penyimpanan.tulisUlang(semuaData);
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    public void edit(int index, String deskripsiBaru, double jumlahBaru, String kategoriBaru, String tipeBaru) {
        List<String> semuaData = penyimpanan.bacaData();
        if (index >= 0 && index < semuaData.size()) {
            String[] bagian = semuaData.get(index).split(",");
            String waktu = bagian[0]; // pertahankan waktu lama
            String dataBaru = waktu + "," + deskripsiBaru + "," + String.format("%.0f", jumlahBaru) + "," + kategoriBaru + "," + tipeBaru;
            semuaData.set(index, dataBaru);
            penyimpanan.tulisUlang(semuaData);
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    public List<String> getSemuaTransaksi() {
        return penyimpanan.bacaData();
    }
}