import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("user_input.txt");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("=== Pencatatan Input Pengguna (Try-with-Resources) ===");
        System.out.println("Ketik input per baris. Ketik 'exit' untuk menyelesaikan program:");

        // Try-with-resources memastikan Scanner dan BufferedWriter otomatis ditutup
        try (Scanner sc = new Scanner(System.in);
             BufferedWriter bw = Files.newBufferedWriter(path,
                 StandardOpenOption.CREATE,
                 StandardOpenOption.APPEND)) {

            // Latihan: Ubah agar menulis beberapa baris hingga pengguna mengetik exit
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                if ("exit".equalsIgnoreCase(input.trim())) {
                    System.out.println("Perintah 'exit' diterima. Selesai menulis file.");
                    break;
                }

                // Latihan: Tambahkan timestamp pada setiap baris input
                String timestamp = LocalDateTime.now().format(dtf);
                String record = "[" + timestamp + "] " + input;
                bw.write(record);
                bw.newLine();
                System.out.println("Tersimpan: " + record);
            }

            System.out.println("Semua data telah disimpan ke: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan IO: " + e.getMessage());
        }
    }
}
