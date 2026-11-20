enum AccountType {
    SAVINGS {
        @Override
        public String toString() {
            return "Akun Tabungan (Savings Account)";
        }
    },
    CREDIT {
        @Override
        public String toString() {
            return "Akun Kredit (Credit Account)";
        }
    },
    // Latihan: Tambahkan DEPOSIT sebagai tipe baru
    DEPOSIT {
        @Override
        public String toString() {
            return "Akun Deposito (Deposit Account)";
        }
    };
}

class Account {
    private AccountType type;

    public Account(AccountType type) {
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Account [tipe=" + type.name() + ", deskripsi=" + type + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        // Latihan: Uji di main() dengan mencetak semua tipe enum
        System.out.println("=== Semua Tipe Enum ===");
        for (AccountType t : AccountType.values()) {
            System.out.println(t.name() + " -> " + t);
        }

        System.out.println("\n=== Pengujian Objek Account ===");
        Account acc1 = new Account(AccountType.SAVINGS);
        Account acc2 = new Account(AccountType.CREDIT);
        Account acc3 = new Account(AccountType.DEPOSIT);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
    }
}
