import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    // Latihan: Buat log hasil operasi ke file log.txt
    private static void catatLog(Path logPath, String pesan) {
        String waktu = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String barisLog = "[" + waktu + "] " + pesan + System.lineSeparator();
        try {
            Files.writeString(logPath, barisLog,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Gagal mencatat log: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");
        Path logFile = Paths.get("log.txt");

        try {
            // Tulis laporan awal
            List<String> konten = List.of(
                "=== LAPORAN SISTEM SERVER ===",
                "Status: OPERATIONAL",
                "Tanggal: " + LocalDateTime.now()
            );
            Files.write(source, konten);
            System.out.println("Laporan utama berhasil ditulis ke: " + source);
            catatLog(logFile, "Laporan dibuat pada " + source);

            // Latihan: 1. Tambahkan pengecekan file sebelum menyalin (Files.exists())
            if (Files.exists(source)) {
                if (backup.getParent() != null && Files.notExists(backup.getParent())) {
                    Files.createDirectories(backup.getParent());
                }

                Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Backup berhasil dibuat di: " + backup);

                // Latihan: 2. Log hasil operasi sukses
                catatLog(logFile, "Backup berhasil disalin dari " + source + " ke " + backup);
            } else {
                System.err.println("File sumber " + source + " tidak ditemukan.");
                catatLog(logFile, "Gagal backup: File sumber tidak ditemukan.");
            }

        } catch (IOException e) {
            System.err.println("Terjadi kesalahan sistem: " + e.getMessage());
            catatLog(logFile, "Kesalahan IO: " + e.getMessage());
        }
    }
}
