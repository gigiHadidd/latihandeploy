import java.util.*;

public class ContohProgramJava {
    public static void main(String[] args) {
        // Menggunakan Scanner untuk mengambil input dari pengguna
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan sebuah angka: ");
        int angka = scanner.nextInt();

        // Menggunakan ArrayList untuk menyimpan beberapa angka
        ArrayList<Integer> daftarAngka = new ArrayList<>();

        for (int i = 1; i <= angka; i++) {
            daftarAngka.add(i);
        }

        // Menggunakan Collections untuk mengacak daftar angka
        Collections.shuffle(daftarAngka);

        // Menampilkan angka yang sudah diacak
        System.out.println("Angka yang sudah diacak: " + daftarAngka);

        // Menggunakan HashMap untuk menyimpan pasangan key-value
        HashMap<String, Integer> data = new HashMap<>();
        data.put("Angka Acak Pertama", daftarAngka.get(0));
        data.put("Angka Acak Kedua", daftarAngka.get(1));

        // Menampilkan pasangan key-value
        System.out.println("Data: " + data);

        // Menggunakan Date untuk mendapatkan tanggal dan waktu saat ini
        Date tanggalSekarang = new Date();
        System.out.println("Tanggal dan Waktu Saat Ini: " + tanggalSekarang);
    }
}