public class Main {
    public static void main(String[] args) {
        // Membuat objek Mobil dengan nama "Mobilku"
        Transportasi transportasi1 = new Mobil("Mobil");

        // Membuat objek Motor dengan nama "Motorku"
        Motor motor = new Motor("Motor");

        // Memanggil metode menggunakan() pada objek Mobil dan Motor
        transportasi1.menggunakan();
        motor.menggunakan();
    }
}





