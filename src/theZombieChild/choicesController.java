package theZombieChild;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author rahaf
 */

public class choicesController extends ScreenController implements Initializable {
    ScreenController PicPuzzle, CloseByClicking;
    
    @FXML
    public ToggleButton label; 
    public ToggleButton label1;
    public ToggleButton label2;
    public ToggleButton label3;
    public Button next;
    public Label score;
    int scoreNum = 50;
    String ID = "choice";
  
     public void true1(ActionEvent event) {
         label.setStyle( "-fx-background-color: OLIVEDRAB"); 
         label1.setDisable(true);
    }   
    public void false1(ActionEvent event) {
         label1.setStyle( "-fx-background-color:DARKRED");
         label.setStyle( "-fx-background-color: WHEAT"); 
    }   
        
    public void true2(ActionEvent event) {
         label2.setStyle( "-fx-background-color: OLIVEDRAB");
         if (label.getStyle() == "-fx-background-color: OLIVEDRAB"){
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
             label3.setDisable(true);
             next.setDisable(false);
         }
    }   
    public void false2(ActionEvent event) {
         label2.setStyle( "-fx-background-color: WHEAT"); 
         label3.setStyle( "-fx-background-color:DARKRED");
    }   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        score.setText(String.valueOf(scoreNum));
    }    
    
    
}
