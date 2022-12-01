package theZombieChild;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.util.Duration;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author atheer
**/
/*Ref: https://youtu.be/QpMnQV2BZsc*/
public class MCController extends ScreenController implements Initializable{
    ScreenController DragThePig, Ending;
    
    
  ArrayList<Button> buttons = new ArrayList<>();
    MemoryGame memoryGame = new MemoryGame();
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    public Button next;
    public Label score;
    int scoreNum = 100;
    String ID = "card";

    int matchCount = 0;
    
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> hideButtons()));

    private boolean firstButtonClicked = false;

    private int firstButtonIndex;
    private int secondButtonIndex;
    private boolean match;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        memoryGame.setupGame();
        buttons.addAll(Arrays.asList(button0, button1, button2, button3, button4,
                button5, button6, button7));
        score.setText(String.valueOf(scoreNum));
    }

    @FXML
    void buttonClicked(ActionEvent event) {
        if(!firstButtonClicked){
            //If next turn is started before old buttons are hidden
            if(!match&&matchCount<4){
                hideButtons();
                timeline.stop();
            }
            match = false;
            firstButtonClicked = true;
            //Get clicked button memory letter
            String buttonId = ((Control)event.getSource()).getId();
            firstButtonIndex = Integer.parseInt(buttonId.substring(buttonId.length() - 1));
            //Change clicked button text
            buttons.get(firstButtonIndex).setText(memoryGame.getOptionAtIndex(firstButtonIndex));
            return;
        }
        //Get clicked button memory letter
        String buttonId = ((Control)event.getSource()).getId();
        secondButtonIndex = Integer.parseInt(buttonId.substring(buttonId.length() - 1));
        //Change clicked button text
        buttons.get(secondButtonIndex).setText(memoryGame.getOptionAtIndex(secondButtonIndex));
        firstButtonClicked = false;
        //Check if the two clicked button match
        if(memoryGame.checkTwoPositions(firstButtonIndex,secondButtonIndex)){
            match = true;
            matchCount = matchCount+1;
            if(matchCount==4){
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                List<scoreTable> sList = null;
                String sql = "FROM scoreTable";
                Query result = session.createQuery(sql);
                sList = result.list();
                for (scoreTable i : sList) {
                    String username = i.getPartName();
                        if(ID.equals(username)){
                        String gScore = i.getScore();
                        scoreNum = Integer.valueOf(gScore)+ scoreNum;
                        score.setText(String.valueOf(scoreNum));}}
                next.setDisable(false);
            } 
        return;
        }
        timeline.play();
    }

    private void hideButtons(){
        buttons.get(firstButtonIndex).setText("!");
        buttons.get(secondButtonIndex).setText("!");
    }

}