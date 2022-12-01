package theZombieChild;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author atheer
 */
public class VideoController extends ScreenController implements Initializable{
    ScreenController PicPuzzle;
    
	@FXML
        private MediaView mediaView;
        private MediaPlayer mediaPlayer;
	
	@FXML
	private Button playButton, pauseButton, resetButton, next;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String MEDIA_URL1 = "Vids/theOriginalVid.mp4";
                mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL1).toExternalForm()));
                mediaPlayer.setAutoPlay(false);
                mediaView.setMediaPlayer(mediaPlayer);
	}
	
	public void playMedia() {
		mediaPlayer.play();
	}
	
	public void pauseMedia() {
		mediaPlayer.pause();
	}
	
	public void resetMedia() {
		if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
			mediaPlayer.seek(Duration.seconds(0.0));
		}
	}
        
}

   