class Cell<T> {
    private T data;

    public void setValue(T data) {
        this.data = data;
    }

    public T getValue() {
        return data;
    }

    // Latihan: Tambahkan method displayType() untuk menampilkan tipe data
    public void displayType() {
        if (data != null) {
            System.out.println("Nilai: " + data + " | Tipe: " + data.getClass().getName());
        } else {
            System.out.println("Data bernilai null.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Latihan: Buat Cell<Integer> dan Cell<String> di main()
        Cell<Integer> intCell = new Cell<>();
        intCell.setValue(100);

        Cell<String> stringCell = new Cell<>();
        stringCell.setValue("Pemrograman Berorientasi Objek");

        System.out.println("=== Uji Method displayType() ===");
        intCell.displayType();
        stringCell.displayType();

        // Latihan: Penjelasan keuntungan penggunaan generic type safety
        System.out.println("\n=== Keuntungan Generic Type Safety ===");
        System.out.println("1. Compile-Time Checking: Error tipe data terdeteksi saat kompilasi, bukan runtime.");
        System.out.println("2. Eliminasi Manual Type Casting: Tidak perlu casting seperti `(String) cell.getValue()`.");
        System.out.println("3. Menghindari ClassCastException di lingkungan production.");
    }
}
