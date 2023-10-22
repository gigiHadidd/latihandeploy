import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Playable {
    void play();
}

class MusicItem implements Playable {
    private String title;
    private String artist;

    public MusicItem(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public void play() {
        System.out.println("Memutar lagu: " + title + " oleh " + artist);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist;
    }
}

class Song extends MusicItem {
    public Song(String title, String artist) {
        super(title, artist);
    }
}

class Playlist implements Playable {
    private List<MusicItem> items = new ArrayList<>();

    public void addItem(MusicItem item) {
        items.add(item);
    }

    public List<MusicItem> getItems() {
        return items;
    }

    @Override
    public void play() {
        System.out.println("Memutar daftar putar:");
        for (MusicItem item : items) {
            item.play();
        }
    }
}

public class MusicApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Playlist playlist = new Playlist();

        // Menambahkan lagu ke dalam playlist
        playlist.addItem(new Song("Money", "Pink Floyd"));
        playlist.addItem(new Song("Arabella", "Arctic Monkeys"));
        playlist.addItem(new Song("Another You", "Brian McKnight"));

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Daftar Lagu ");
            System.out.println("2. Putar Daftar Putar");
            System.out.println("3. Keluar");
            System.out.print("Pilih tindakan: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Daftar Lagu yang Sudah Ada:");
                    List<MusicItem> songs = playlist.getItems();
                    for (int i = 0; i < songs.size(); i++) {
                        System.out.println((i + 1) + ". " + songs.get(i));
                    }
                    break;
                case 2:
                    playlist.play();
                    break;
                case 3:
                    System.out.println("Keluar dari aplikasi.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
