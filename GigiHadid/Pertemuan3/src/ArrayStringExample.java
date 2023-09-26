public class ArrayStringExample {
    public static void main(String[] args) {
        // Mendefinisikan sebuah array String untuk menyimpan nama-nama
        String[] nama = new String[7];

        // Mengisi array dengan beberapa nama
        nama[0] = "Alvin";
        nama[1] = "William";
        nama[2] = "Rafly";
        nama[3] = "Giselle";
        nama[4] = "Neil";
        nama[5] = "Liko";
        nama[6] = "Cecilia";


        // Menampilkan nama-nama dari array
        System.out.println("Nama-nama dalam array:");

        for (int i = 0; i < nama.length; i++) {
            System.out.println(nama[i]);
        }
    }
}