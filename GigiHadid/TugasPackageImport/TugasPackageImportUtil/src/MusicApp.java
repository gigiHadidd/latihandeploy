import java.util.*;

public class MusicApp {
        public static void main(String[] args) {
            // Membuat ArrayList untuk menyimpan lagu-lagu
            ArrayList<Music> playlist = new ArrayList<Music>();

            // Menambahkan lagu ke dalam playlist
            playlist.add(new Music("Money", "Pink Floyd"));
            playlist.add(new Music("Arabella", "Artict Monkeys"));
            playlist.add(new Music("Another You", "Brian McKnight"));

            // Menampilkan playlist
            System.out.println("Playlist:");
            for (Music song : playlist) {
                System.out.println(song);
            }
        }
    }
