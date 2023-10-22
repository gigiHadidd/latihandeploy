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

    public Lagu(String judul, String artis, int durasi) {
        super(judul, artis);
        this.durasi = durasi;
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

        ObjekMusik lagu1 = new Lagu("La vie en rose", "Artis: Louis Armstrong", 180);
        ObjekMusik lagu2 = new Lagu("Dream a little Dream of Me", "Artis: Ella Fitzgerald", 240);
        ObjekMusik lagu3 = new Lagu("Can't Help Falling in Love", "Artis: Elvis Presley", 200);

        aplikasiMusik.tambahkanLagu(lagu1);
        aplikasiMusik.tambahkanLagu(lagu2);
        aplikasiMusik.tambahkanLagu(lagu3);

        System.out.print("Masukkan nama Anda: ");
        String namaPengguna = scanner.nextLine();

        System.out.print("Masukkan email Anda: ");
        String emailPengguna = scanner.nextLine();

        Pengguna pengguna1 = new Pengguna(namaPengguna, emailPengguna);

        Playlist playlistPengguna = pengguna1.getPlaylist();
        List<ObjekMusik> daftarLagu = aplikasiMusik.getDaftarLagu();

        System.out.println("Daftar Lagu:");

        for (int i = 0; i < daftarLagu.size(); i++) {
            ObjekMusik lagu = daftarLagu.get(i);
            System.out.println(i + 1 + ". " + lagu.getJudul() + " oleh " + lagu.getArtis());
        }

        System.out.print("Masukkan nomor lagu yang ingin Anda tambahkan ke playlist: ");
        int nomorLagu = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        ObjekMusik laguDipilih = daftarLagu.get(nomorLagu - 1);
        pengguna1.tambahkanLaguKePlaylist(laguDipilih);

        System.out.println("Lagu " + laguDipilih.getJudul() + " telah ditambahkan ke playlist Anda.");

        System.out.println("Memainkan playlist pengguna:");
        pengguna1.mainkanPlaylist();

        scanner.close();
    }
}
