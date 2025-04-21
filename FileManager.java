import java.io.*;
import java.util.*;

public class FileManager implements DataPersistence, PembacaTransaksi {
    private final String fileName = "data_transaksi.txt";

    @Override
    public void simpanData(String data) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    @Override
    public List<String> bacaData() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca data: " + e.getMessage());
        }
        return lines;
    }

    @Override
    public void tulisUlang(List<String> dataBaru) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            for (String line : dataBaru) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menulis ulang data: " + e.getMessage());
        }
    }
}
