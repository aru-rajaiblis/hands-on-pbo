class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void showTypes() {
        System.out.println(first.getClass().getName() + " & " + second.getClass().getName());
    }

    // Latihan: Tambahkan method swap() untuk menukar nilai
    public Pair<T2, T1> swap() {
        return new Pair<>(this.second, this.first);
    }

    @Override
    public String toString() {
        return "Pair(" + first + ", " + second + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        // Latihan: Buat Pair<Integer, String> dan Pair<Double, Boolean>
        Pair<Integer, String> pair1 = new Pair<>(2026, "Tahun Sekarang");
        Pair<Double, Boolean> pair2 = new Pair<>(98.5, true);

        System.out.println("=== Pair Awal & Tipe ===");
        System.out.print(pair1 + " -> Tipe: ");
        pair1.showTypes();

        System.out.print(pair2 + " -> Tipe: ");
        pair2.showTypes();

        // Latihan: Uji method swap()
        Pair<String, Integer> swapped1 = pair1.swap();
        Pair<Boolean, Double> swapped2 = pair2.swap();

        System.out.println("\n=== Hasil Setelah swap() ===");
        System.out.print(swapped1 + " -> Tipe: ");
        swapped1.showTypes();

        System.out.print(swapped2 + " -> Tipe: ");
        swapped2.showTypes();
    }
}
