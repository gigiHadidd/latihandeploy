class Mahasiswa {
    // Variabel-variabel instance private
    private String nim;
    private String nama;
    private String jurusan;
    private int tahunMasuk;

    // Metode setter untuk mengatur nilai variabel instance
    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void setTahunMasuk(int tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    // Metode getter untuk mendapatkan nilai variabel instance
    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public int getTahunMasuk() {
        return tahunMasuk;
    }

}
