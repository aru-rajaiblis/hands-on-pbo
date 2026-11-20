import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String division;

    public Employee(String name, int age, String division) {
        this.name = name;
        this.age = age;
        this.division = division;
    }

    public static void serialize(List<Employee> list, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
            System.out.println("Objek berhasil diserialisasi ke file: " + filename);
        } catch (IOException e) {
            System.err.println("Gagal serialisasi: " + e.getMessage());
        }
    }

    // Latihan: Tambahkan method deserialize() untuk membaca kembali objek
    @SuppressWarnings("unchecked")
    public static List<Employee> deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Gagal deserialisasi: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return "Employee[name=" + name + ", age=" + age + ", division=" + division + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        String filename = "emp.ser";

        // Latihan: Uji dengan beberapa objek berbeda
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("John", 30, "Engineering"));
        employeeList.add(new Employee("Sarah", 27, "Design"));
        employeeList.add(new Employee("David", 35, "Management"));

        System.out.println("=== Menyimpan (Serialize) Objek ===");
        Employee.serialize(employeeList, filename);

        System.out.println("\n=== Membaca Kembali (Deserialize) Objek ===");
        List<Employee> restoredEmployees = Employee.deserialize(filename);
        for (Employee e : restoredEmployees) {
            System.out.println("Hasil Deserialized: " + e);
        }
    }
}
