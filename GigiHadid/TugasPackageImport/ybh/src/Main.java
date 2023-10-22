// Interface untuk objek musik yang dapat diputar
interface Playable {
    void play();
}

// Kelas dasar untuk objek musik
class Musik implements Playable {
    private String judul;
    private String artis;

    public Musik(String judul, String artis) {
        this.judul = judul;
        this.artis = artis;
    }

    @Override
    public void play() {
        System.out.println("Memutar musik: " + judul + " oleh " + artis);
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Artis: " + artis;
    }
}

// Kelas dasar untuk objek playlist
class Playlist implements Playable {
    private String nama;
    private Playable[] lagu;

    public Playlist(String nama) {
        this.nama = nama;
        lagu = new Playable[10]; // Batasi playlist hingga 10 lagu
    }

    public void tambahLagu(Playable laguBaru) {
        for (int i = 0; i < lagu.length; i++) {
            if (lagu[i] == null) {
                lagu[i] = laguBaru;
                break;
            }
        }
    }

    @Override
    public void play() {
        System.out.println("Memutar playlist: " + nama);
        for (Playable lagu : lagu) {
            if (lagu != null) {
                lagu.play();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Musik lagu1 = new Musik("Lagu A", "Artis X");
        Musik lagu2 = new Musik("Lagu B", "Artis Y");

        Playlist playlist1 = new Playlist("Playlist Pop");
        playlist1.tambahLagu(lagu1);
        playlist1.tambahLagu(lagu2);

        Musik lagu3 = new Musik("Lagu C", "Artis Z");
        Playlist playlist2 = new Playlist("Playlist Rock");
        playlist2.tambahLagu(lagu3);

        // Polymorphism: Memutar lagu dan playlist
        Playable[] items = new Playable[2];
        items[0] = lagu1;
        items[1] = playlist1;

        for (Playable item : items) {
            item.play();
            System.out.println();
        }

        // Memutar playlist yang berisi lagu dan playlist lainnya
        playlist2.tambahLagu(playlist1);
        playlist2.play();
    }
}
