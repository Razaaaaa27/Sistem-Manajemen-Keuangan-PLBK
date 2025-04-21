import java.util.List;

public interface DataPersistence {
    void simpanData(String data);
    List<String> bacaData();
    void tulisUlang(List<String> dataBaru);
}