public class Main {
    public static void main(String[] args) {
        DataPersistence penyimpanan = new FileManager();    
        PembacaTransaksi pembaca = new FileManager();        

        PengelolaTransaksi pengelola = new ManajemenTransaksi(penyimpanan);
        PembuatLaporan pelapor = new GeneratorLaporan(pembaca);
        UserInterface ui = new KonsolUI(pengelola, pelapor);

        ui.tampilkanMenu();
    }
}
