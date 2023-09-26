public class EncapsulationExample {
    public static void main(String[] args) {
        // Membuat objek dari kelas Mahasiswa
        Mahasiswa mahasiswa1 = new Mahasiswa();
        mahasiswa1.setNim("825210015");
        mahasiswa1.setNama("Alvin Nicolas Gunadi");
        mahasiswa1.setJurusan("Sistem Informasi");
        mahasiswa1.setTahunMasuk(2021);

        // Menampilkan informasi mahasiswa
        System.out.println("NIM: " + mahasiswa1.getNim());
        System.out.println("Nama: " + mahasiswa1.getNama());
        System.out.println("Jurusan: " + mahasiswa1.getJurusan());
        System.out.println("Tahun Masuk: " + mahasiswa1.getTahunMasuk());
    }
}