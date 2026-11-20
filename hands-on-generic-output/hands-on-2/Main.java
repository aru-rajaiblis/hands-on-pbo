enum AccountType {
    SAVINGS("SA", 0.025),
    CREDIT("CR", 0.150),
    DEPOSIT("DP", 0.050);

    private final String code;
    private final double interestRate; // Latihan: Tambahkan atribut interestRate

    private AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }

    public String getCode() {
        return code;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

public class Main {
    public static void main(String[] args) {
        // Latihan: Tampilkan nama, kode, dan suku bunga menggunakan loop
        System.out.println("=== Daftar Tipe Akun, Kode, dan Suku Bunga ===");
        for (AccountType type : AccountType.values()) {
            System.out.printf("Tipe: %-8s | Kode: %s | Suku Bunga: %.2f%%\n",
                type.name(),
                type.getCode(),
                type.getInterestRate() * 100);
        }
    }
}
