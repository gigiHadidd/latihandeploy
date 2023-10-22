import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MediaPlayerApp extends Application {
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Inisialisasi media
        Media media = new Media("file:///path/to/your/mediafile.mp4");
        mediaPlayer = new MediaPlayer(media);

        // Inisialisasi MediaView
        mediaView = new MediaView(mediaPlayer);

        // Tombol untuk mengontrol media
        Button playButton = new Button("Putar");
        Button pauseButton = new Button("Jeda");
        Button stopButton = new Button("Berhenti");

        playButton.setOnAction(event -> mediaPlayer.play());
        pauseButton.setOnAction(event -> mediaPlayer.pause());
        stopButton.setOnAction(event -> mediaPlayer.stop());

        // Menambahkan event handler untuk mengatur posisi pemutaran
        mediaPlayer.setOnReady(() -> {
            Duration totalDuration = media.getDuration();
            mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
                double progress = newValue.toSeconds() / totalDuration.toSeconds();
                // Di sini Anda dapat memperbarui tampilan progres
            });
        });

        // Membuat layout GUI
        VBox root = new VBox(mediaView, playButton, pauseButton, stopButton);

        // Membuat Scene dan menambahkannya ke Stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pemutar Media");
        primaryStage.show();
    }

    @Override
    public void stop() {
        // Memastikan untuk melepaskan sumber daya media saat aplikasi ditutup
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
    }
}
