interface Vehicle{
    void bergerak();
}

interface EnginePowered {
    void startEngine();
}

interface FuelPowered {
    void isiBahanBakar();
}

interface ElectricPowered {
    void isiBaterai();
}

class MobilListrik implements Vehicle, EnginePowered, ElectricPowered {
    @Override
    public void startEngine() {
        System.out.println("Menyalakan motor listrik...");
    }

    @Override
    public void isiBaterai() {
        System.out.println("Mengisi baterai mobil listrik...");
    }

    @Override
    public void bergerak() {
        System.out.println("Mobil listrik melaju senyap.");
    }
}

class MobilBensin implements Vehicle, EnginePowered, FuelPowered {
    @Override
    public void startEngine() {
        System.out.println("Menyalakan mesin bensin...");
    }

    @Override
    public void isiBahanBakar() {
        System.out.println("Mengisi bensin di SPBU...");
    }

    @Override
    public void bergerak() {
        System.out.println("Mobil bensin melaju di jalan.");
    }
}

class Sepeda implements Vehicle {
    @Override
    public void bergerak() {
        System.out.println("Sepeda dikayuh di jalur sepeda.");
    }
}

// Contoh penambahan jenis baru tanpa ubah kode lama (OCP)
class MobilHybrid implements Vehicle, EnginePowered, FuelPowered, ElectricPowered {
    @Override
    public void startEngine() {
        System.out.println("Menyalakan sistem hybrid...");
    }

    @Override
    public void isiBahanBakar() {
        System.out.println("Mengisi bensin tangki hybrid...");
    }

    @Override
    public void isiBaterai() {
        System.out.println("Mengisi daya baterai hybrid...");
    }

    @Override
    public void bergerak() {
        System.out.println("Mobil hybrid melaju.");
    }
}

public class Main {
    public static void main(String[] args) {
        MobilListrik mobilListrik = new MobilListrik();
        mobilListrik.startEngine();
        mobilListrik.isiBaterai();
        mobilListrik.bergerak();

        Sepeda sepeda = new Sepeda();
        sepeda.bergerak();
    }
}