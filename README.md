# 💰 Sistem Manajemen Keuangan

Sistem Manajemen Keuangan berbasis konsol ini membantu pengguna mencatat, mengelola, dan menganalisis transaksi keuangan secara sederhana namun efektif. Proyek ini dibangun menggunakan Java dan berfokus pada pencatatan pemasukan, pengeluaran, serta pembuatan laporan keuangan.

---

## 📦 Fitur Utama

-  Tambah transaksi keuangan
-  Tampilkan laporan keuangan
-  Hitung saldo akhir
-  Edit transaksi yang sudah ada
-  Hapus transaksi yang tidak diinginkan

---

## 🧩 Struktur Proyek

```
.
├── Main.java
├── FileManager.java
├── GeneratorLaporan.java
├── KonsolUI.java
├── ManajemenTransaksi.java
├── interface/
│   ├── DataPersistence.java
│   ├── PembuatLaporan.java
│   ├── PengelolaTransaksi.java
│   └── UserInterface.java
```

---

## ⚙️ Cara Menjalankan

1. **Clone repositori ini**
   ```bash
   git clone https://github.com/username/SistemManajemenKeuangan.git
   cd SistemManajemenKeuangan
   ```

2. **Kompilasi semua file Java**
   ```bash
   javac *.java
   ```

3. **Jalankan aplikasi**
   ```bash
   java Main
   ```

---

## 🖥️ Antarmuka Konsol

Menu utama yang tersedia:
```
1. Tambah Transaksi
2. Laporan Keuangan
3. Hitung Saldo
4. Edit Transaksi
5. Hapus Transaksi
6. Keluar
```

---

## 🧠 Arsitektur

- `FileManager`: Menyimpan dan membaca data dari file.
- `ManajemenTransaksi`: Menangani logika tambah, edit, hapus transaksi.
- `GeneratorLaporan`: Menampilkan laporan dan menghitung saldo.
- `KonsolUI`: Menyediakan antarmuka pengguna berbasis teks.
- Interface: Abstraksi dari setiap komponen utama untuk skalabilitas dan pemeliharaan.



