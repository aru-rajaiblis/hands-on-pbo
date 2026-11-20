import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path inputPath = Paths.get("employees.txt");
        Path outputPath = Paths.get("copy_employees.txt");

        // Persiapan file contoh bila belum ada
        if (Files.notExists(inputPath)) {
            try {
                Files.write(inputPath, List.of(
                    "EMP001, Kanda Asep, Backend Engineer",
                    "EMP002, Siti Durjana, UI/UX Designer",
                    "EMP003, Sipakamase, DevOps Specialist"
                ), StandardCharsets.UTF_8);
                System.out.println("Sample file 'employees.txt' berhasil dibuat.");
            } catch (IOException e) {
                System.err.println("Gagal menginisialisasi employees.txt: " + e.getMessage());
            }
        }

        // Latihan: 1. Tambahkan deteksi jika file tidak ditemukan
        if (!Files.exists(inputPath)) {
            System.err.println("File " + inputPath.getFileName() + " tidak ditemukan!");
            return;
        }

        // Latihan: 2. Simpan hasil baca ke ArrayList<String>
        List<String> employeeList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(inputPath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                employeeList.add(line);
            }
            System.out.println("=== Hasil Pembacaan File (Total: " + employeeList.size() + " baris) ===");
            employeeList.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
            return;
        }

        // Latihan: 3. Tuliskan ke file baru copy_employees.txt
        try {
            Files.write(outputPath, employeeList, StandardCharsets.UTF_8);
            System.out.println("\nSukses: Data karyawan berhasil disalin ke " + outputPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Gagal menulis salinan file: " + e.getMessage());
        }
    }
}
