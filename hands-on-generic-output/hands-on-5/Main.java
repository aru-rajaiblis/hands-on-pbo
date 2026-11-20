class CompareUtil {
    public static <T extends Comparable<T>> boolean isEqual(T a, T b) {
        return a.compareTo(b) == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Pengujian Generic Method isEqual ===");
        System.out.println("Integer (5, 5)          : " + CompareUtil.isEqual(5, 5));
        System.out.println("String ('Halo', 'Halo') : " + CompareUtil.isEqual("Halo", "Halo"));
        System.out.println("String ('Halo', 'Dunia'): " + CompareUtil.isEqual("Halo", "Dunia"));

        // Latihan: Tambahkan test case untuk Double dan Character
        System.out.println("Double (3.14, 3.14)     : " + CompareUtil.isEqual(3.14, 3.14));
        System.out.println("Double (2.71, 3.14)     : " + CompareUtil.isEqual(2.71, 3.14));
        System.out.println("Char ('A', 'A')         : " + CompareUtil.isEqual('A', 'A'));
        System.out.println("Char ('A', 'B')         : " + CompareUtil.isEqual('A', 'B'));

        // Latihan: Penjelasan perbedaan antara generic class dan generic method
        System.out.println("\n=== Perbedaan Generic Class vs Generic Method ===");
        System.out.println("1. Generic Class: Type parameter dideklarasikan di tingkat class (misal: class Box<T>).");
        System.out.println("   Tipe T terikat ke instance objek class tersebut.");
        System.out.println("2. Generic Method: Type parameter dideklarasikan spesifik di header method (misal: <T> boolean isEqual(T a, T b)).");
        System.out.println("   Dapat berada dalam class non-generic dan tipe T di-infer secara dinamis saat pemanggilan method.");
    }
}
