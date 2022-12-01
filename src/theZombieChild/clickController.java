package theZombieChild;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author razan
**/
public class clickController extends ScreenController implements Initializable {
    ScreenController choices, DragThePig;
    
    @FXML   
    ImageView myImageView;
    Button button;
    public Button next;
    public Label score;
    int scoreNum = 70;
    String ID = "click";
    
    Image image = new Image(getClass().getResourceAsStream("img/doorClickingClosed.png"));
    
    public void displayImage(){
        myImageView.setImage(image);
        next.setDisable(false);
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
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        score.setText(String.valueOf(scoreNum));
    }    

}
