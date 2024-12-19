package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class WaitController implements Initializable {

    @FXML
    private Label label;
    
    @FXML
    private Text id;

    private final String playText = "Waiting";
    private final String content = "...";
    private StringBuilder displayedText = new StringBuilder(playText);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(displayedText.toString());

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); 

        for (int i = 0; i < content.length(); i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i + 0.375), event -> {
                displayedText.append(content.charAt(index));
                label.setText(displayedText.toString());
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        KeyFrame resetKeyFrame = new KeyFrame(Duration.seconds(content.length() + 1), event -> {
            displayedText = new StringBuilder(playText);
            label.setText(displayedText.toString());
        });
        timeline.getKeyFrames().add(resetKeyFrame);

        timeline.play();
    }
    
    public void setID(String id) {
    	this.id.setText("Room ID: " + id);
    }
}
