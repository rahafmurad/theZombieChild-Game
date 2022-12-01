package theZombieChild;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author rana
**/
public class DragandDropController extends ScreenController implements Initializable {
    ScreenController CloseByClicking, MemoryCardPuzzle;

    @FXML
    private ImageView pic;
    public Button next;
    public Label score;
    int scoreNum = 80;
    String ID = "drag";

    private double mouseAnchoeX;
    private double mouseAnchoeY;

    DraggableMaker draggbleMaker = new DraggableMaker();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        draggbleMaker.makeDraggable(pic);
        score.setText(String.valueOf(scoreNum));
    }

    private class DraggableMaker {

        @FXML
        private void makeDraggable(ImageView pic) {

            pic.setOnMousePressed(mouseEvent -> {
                mouseAnchoeX = mouseEvent.getX();
                mouseAnchoeY = mouseEvent.getX();
            });

            pic.setOnMouseDragged(mouseEvent -> {
                pic.setLayoutX(mouseEvent.getSceneX() - mouseAnchoeX);
                pic.setLayoutY(mouseEvent.getSceneY() - mouseAnchoeY);

                // The coordinates of the empty speace --> (x:24 y:183)
                if ((pic.getLayoutX() > 20 && pic.getLayoutX() < 25)  && (pic.getLayoutY() > 182 && pic.getLayoutY() < 184)) {
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
                    pic.setMouseTransparent(true);
                    pic.setCursor(Cursor.CLOSED_HAND);
                }

            });

        }
    }
}
