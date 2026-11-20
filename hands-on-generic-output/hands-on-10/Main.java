import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Latihan 1 & Modifikasi: Class generic Produk dengan atribut stok (Integer)
class Produk<T, U> {
    private T nama;
    private U harga;
    private Integer stok; // Latihan: Tambahkan atribut stok (tipe data Integer)

    public Produk(T nama, U harga, Integer stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public T getNama() {
        return nama;
    }

    public U getHarga() {
        return harga;
    }

    public Integer getStok() {
        return stok;
    }

    @Override
    public String toString() {
        return nama + "," + harga + "," + stok;
    }
}

// Latihan 3: Modifikasi class generic agar dapat digunakan untuk entitas data lain (misal: Transaksi)
class Transaksi<T, U> {
    private T kodeTransaksi;
    private U totalBiaya;
    private Integer jumlahBarang;

    public Transaksi(T kodeTransaksi, U totalBiaya, Integer jumlahBarang) {
        this.kodeTransaksi = kodeTransaksi;
        this.totalBiaya = totalBiaya;
        this.jumlahBarang = jumlahBarang;
    }

    @Override
    public String toString() {
        return kodeTransaksi + "," + totalBiaya + "," + jumlahBarang;
    }
}

public class Main {
    public static void main(String[] args) {
        // --- 1. Penyimpanan Data Produk ---
        List<Produk<String, Double>> produkList = new ArrayList<>();
        produkList.add(new Produk<>("Laptop ASUS ROG", 18500000.0, 5));
        produkList.add(new Produk<>("Mouse Logitech G-Pro", 1250000.0, 20));
        produkList.add(new Produk<>("Mechanical Keyboard", 850000.0, 15));

        Path produkPath = Paths.get("produk_output.txt");
        try {
            List<String> lines = new ArrayList<>();
            for (Produk<String, Double> p : produkList) {
                lines.add(p.toString());
            }
            Files.write(produkPath, lines);
            System.out.println("Data produk berhasil disimpan dengan NIO.2 ke " + produkPath);

            // Latihan 2: Ubah program agar dapat membaca kembali isi file (Files.readAllLines()) dan menampilkannya di konsol
            System.out.println("\n=== Membaca Kembali Isi File (" + produkPath.getFileName() + ") ===");
            List<String> hasilBaca = Files.readAllLines(produkPath);
            for (String baris : hasilBaca) {
                String[] part = baris.split(",");
                System.out.printf("Barang: %-22s | Harga: Rp%-10s | Stok: %s unit\n", part[0], part[1], part[2]);
            }
        } catch (IOException e) {
            System.err.println("Gagal mengelola file produk: " + e.getMessage());
        }

        // --- Latihan 3: Penggunaan generic class untuk jenis data lain (Transaksi) ---
        List<Transaksi<String, Double>> transaksiList = new ArrayList<>();
        transaksiList.add(new Transaksi<>("TRX-20261119-01", 19750000.0, 2));
        transaksiList.add(new Transaksi<>("TRX-20261119-02", 850000.0, 1));

        Path transaksiPath = Paths.get("transaksi_output.txt");
        try {
            List<String> trxLines = new ArrayList<>();
            for (Transaksi<String, Double> trx : transaksiList) {
                trxLines.add(trx.toString());
            }
            Files.write(transaksiPath, trxLines);
            System.out.println("\nData transaksi berhasil disimpan dengan Generic Class ke " + transaksiPath);

            System.out.println("=== Membaca Kembali Isi File Transaksi ===");
            List<String> hasilTrx = Files.readAllLines(transaksiPath);
            for (String baris : hasilTrx) {
                String[] part = baris.split(",");
                System.out.printf("Kode: %-16s | Total: Rp%-10s | Qty: %s\n", part[0], part[1], part[2]);
            }
        } catch (IOException e) {
            System.err.println("Gagal mengelola file transaksi: " + e.getMessage());
        }
    }
}
