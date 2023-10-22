import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ObjekMusik {
    private String judul;
    private String artis;

    public ObjekMusik(String judul, String artis) {
        this.judul = judul;
        this.artis = artis;
    }

    public String getJudul() {
        return judul;
    }

    public String getArtis() {
        return artis;
    }

    public void mainkan() {
        System.out.println("Memutar lagu: " + getJudul() + " oleh " + getArtis());
    }
}

class Lagu extends ObjekMusik {
    private int durasi;
    private String lirik;

    public Lagu(String judul, String artis, int durasi, String lirik) {
        super(judul, artis);
        this.durasi = durasi;
        this.lirik = lirik;
    }

    public String getLirik() {
        return lirik;
    }

    @Override
    public void mainkan() {
        System.out.println("Memutar lagu: " + getJudul() + " oleh " + getArtis());
    }
}

class Playlist extends ObjekMusik {
    private List<ObjekMusik> daftarLagu = new ArrayList<>();

    public Playlist(String judul) {
        super(judul, "Various Artists");
    }

    public void tambahkanLagu(ObjekMusik objekMusik) {
        daftarLagu.add(objekMusik);
    }

    public List<ObjekMusik> getDaftarLagu() {
        return daftarLagu;
    }

    @Override
    public void mainkan() {
        System.out.println("Memutar playlist: " + getJudul());
        for (ObjekMusik lagu : daftarLagu) {
            lagu.mainkan();
        }
    }
}

interface PengaturanSuara {
    void aturVolume(int volume);
    void aturEqualizer(String equalizer);
}

class AplikasiMusik implements PengaturanSuara {
    private List<Pengguna> daftarPengguna = new ArrayList<>();
    private List<ObjekMusik> daftarLagu = new ArrayList<>();
    private int volume = 50;
    private String equalizer = "Default";

    public void tambahkanPengguna(Pengguna pengguna) {
        daftarPengguna.add(pengguna);
    }

    public void tambahkanLagu(ObjekMusik lagu) {
        daftarLagu.add(lagu);
    }

    @Override
    public void aturVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume diatur ke: " + volume);
    }

    @Override
    public void aturEqualizer(String equalizer) {
        this.equalizer = equalizer;
        System.out.println("Equalizer diatur ke: " + equalizer);
    }

    public List<ObjekMusik> getDaftarLagu() {
        return daftarLagu;
    }
}

class Pengguna {
    private String nama;
    private String email;
    private Playlist playlist;

    public Pengguna(String nama, String email) {
        this.nama = nama;
        this.email = email;
        this.playlist = new Playlist("Playlist Saya");
    }

    public void tambahkanLaguKePlaylist(ObjekMusik objekMusik) {
        playlist.tambahkanLagu(objekMusik);
    }

    public void mainkanPlaylist() {
        playlist.mainkan();
    }

    public Playlist getPlaylist() {
        return playlist;
    }
}

public class Main {
    public static void main(String[] args) {
        AplikasiMusik aplikasiMusik = new AplikasiMusik();
        Scanner scanner = new Scanner(System.in);

        ObjekMusik lagu1 = new Lagu("La vie en rose", "Artis: Louis Armstrong", 180,
                "Des yeux qui font baisser les miens\n" +
                        "Un rire qui se perd sur sa bouche\n" +
                        // ... lirik lagu ...
                        "Mon cœur qui bat");

        ObjekMusik lagu2 = new Lagu("Dream a little Dream of Me", "Artis: Ella Fitzgerald", 240,
                "Stars shining bright above you\n" +
                        // ... lirik lagu ...
                        "Dream a little dream of me");

        ObjekMusik lagu3 = new Lagu("Can't Help Falling in Love", "Artis: Elvis Presley", 200,
                "Wise men say\n" +
                        // ... lirik lagu ...
                        "Yeah");

        aplikasiMusik.tambahkanLagu(lagu1);
        aplikasiMusik.tambahkanLagu(lagu2);
        aplikasiMusik.tambahkanLagu(lagu3);

        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (verifikasiLogin(username, password)) {
            Pengguna pengguna1 = new Pengguna(username, "appmusic@gmail.com");

            Playlist playlistPengguna = pengguna1.getPlaylist();
            List<ObjekMusik> daftarLagu = aplikasiMusik.getDaftarLagu();

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Tambahkan Lagu");
                System.out.println("2. Memilih Lagu yang sudah ada");
                System.out.println("3. Keluar");
                System.out.println("4. Atur Volume");
                System.out.println("5. Atur Equalizer");
                System.out.print("Pilih menu (1/2/3/4/5): ");
                int menu = scanner.nextInt();
                scanner.nextLine();

                if (menu == 1) {
                    System.out.print("Masukkan nama lagu: ");
                    String namaLagu = scanner.nextLine();
                    System.out.print("Masukkan nama artis: ");
                    String namaArtis = scanner.nextLine();
                    System.out.print("Apakah ingin menambahkan lirik? (y/n): ");
                    String tambahLirik = scanner.nextLine();
                    String lirikLagu = "";

                    if (tambahLirik.equalsIgnoreCase("y")) {
                        System.out.print("Masukkan lirik lagu: ");
                        lirikLagu = scanner.nextLine();
                    }

                    ObjekMusik laguBaru = new Lagu(namaLagu, "Artis: " + namaArtis, 0, lirikLagu);
                    aplikasiMusik.tambahkanLagu(laguBaru);

                    System.out.println("Lagu " + laguBaru.getJudul() + " oleh " + laguBaru.getArtis() + " telah ditambahkan.");
                } else if (menu == 2) {
                    System.out.println("Daftar Lagu:");

                    for (int i = 0; i < daftarLagu.size(); i++) {
                        ObjekMusik lagu = daftarLagu.get(i);
                        System.out.println(i + 1 + ". " + lagu.getJudul() + " oleh " + lagu.getArtis());
                    }

                    System.out.print("Masukkan nomor lagu yang ingin Anda tambahkan ke playlist: ");
                    int nomorLagu = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline

                    ObjekMusik laguDipilih = daftarLagu.get(nomorLagu - 1);

                    System.out.println("Memutar lagu " + laguDipilih.getJudul() + " oleh " + laguDipilih.getArtis() + ":");
                    System.out.print("Apakah ingin memutar lagu dengan lirik? (y/n): ");
                    String putarDenganLirik = scanner.nextLine();

                    if (putarDenganLirik.equalsIgnoreCase("y")) {
                        Lagu laguPutar = (Lagu) laguDipilih;
                        String lirikLaguPutar = laguPutar.getLirik();
                        System.out.println("Lirik lagu:\n" + lirikLaguPutar);
                    }

                    pengguna1.tambahkanLaguKePlaylist(laguDipilih);
                    System.out.println("Lagu " + laguDipilih.getJudul() + " oleh " + laguDipilih.getArtis() + " telah ditambahkan ke playlist Anda.");
                } else if (menu == 3) {
                    System.out.println("Terima kasih telah menggunakan aplikasi musik.");
                    break;
                } else if (menu == 4) {
                    System.out.print("Masukkan volume (0-100): ");
                    int volume = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline
                    aplikasiMusik.aturVolume(volume);
                } else if (menu == 5) {
                    System.out.print("Masukkan equalizer: ");
                    String equalizer = scanner.nextLine();
                    aplikasiMusik.aturEqualizer(equalizer);
                } else {
                    System.out.println("Menu tidak valid. Pilih menu yang sesuai.");
                }
            }
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }

        scanner.close();
    }

    private static boolean verifikasiLogin(String username, String password) {
        // Gantilah dengan logika verifikasi login sesuai dengan kebutuhan Anda.
        // Contoh sederhana: username dan password harus sama.
        return username.equals(password);
    }
}

