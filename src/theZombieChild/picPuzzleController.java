package theZombieChild;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author aseel
**/
public class picPuzzleController extends ScreenController implements Initializable {
    ScreenController choices;
        
    @FXML 
    ImageView img1, img2 , img3, img4, img5, img6, img7, img8, img9; 
    String ClickUrl = "";
    String ClickId = "";
    public Button Next;
    
    public Label score;
    int scoreNum = 0;
    String ID = "pic";

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayStart();
        
        score.setText(String.valueOf(scoreNum));
        
        // clicks 
        img1.setOnMouseClicked((event) -> {
            if(ClickId.isEmpty())
            {
               ClickId = img1.getId();
               ClickUrl = img1.getImage().impl_getUrl();
            }else
            {
                SetImage(ClickId, img1.getImage().impl_getUrl());
                SetImage(img1.getId(), ClickUrl);
                ClickUrl = "";
                ClickId = "";
            if(Check()){}
            }
        });
        
        img2.setOnMouseClicked((event) -> {
            if(ClickId.isEmpty())
            {
               ClickId = img2.getId();
               ClickUrl = img2.getImage().impl_getUrl();
            }else
            {
                SetImage(ClickId, img2.getImage().impl_getUrl());
                SetImage(img2.getId(), ClickUrl);
                
                 ClickUrl = "";
                 ClickId = "";
            if(Check()){}
            }
        });
             
        img3.setOnMouseClicked((event) -> {
            if(ClickId.isEmpty())
            {
               ClickId = img3.getId();
               ClickUrl = img3.getImage().impl_getUrl();
            }else
            {
                SetImage(ClickId, img3.getImage().impl_getUrl());
                SetImage(img3.getId(), ClickUrl);
                 ClickUrl = "";
                 ClickId = "";
            if(Check()){}
            }
        });
             
        img4.setOnMouseClicked((event) -> {
            if(ClickId.isEmpty())
            {
               ClickId = img4.getId();
               ClickUrl = img4.getImage().impl_getUrl();
            }else
            {
                SetImage(ClickId, img4.getImage().impl_getUrl());
                SetImage(img4.getId(), ClickUrl);
                
                 ClickUrl = "";
                 ClickId = "";
            if(Check()){}
            }
        });
                  
        img5.setOnMouseClicked((event) -> {
            if(ClickId.isEmpty())
            {
               ClickId = img5.getId();
               ClickUrl = img5.getImage().impl_getUrl();
            }else
            {
                SetImage(ClickId, img5.getImage().impl_getUrl());
                SetImage(img5.getId(), ClickUrl);
                 ClickUrl = "";
                 ClickId = "";
            if(Check()){} 
            }
        });
                       
        img6.setOnMouseClicked((event) -> {
            if(ClickId.isEmpty())
            {
               ClickId = img6.getId();
               ClickUrl = img6.getImage().impl_getUrl();
            }else
            {
                SetImage(ClickId, img6.getImage().impl_getUrl());
                SetImage(img6.getId(), ClickUrl);
                
                 ClickUrl = "";
                 ClickId = "";
            if(Check()){}
            }
        });               
      
        img7.setOnMouseClicked((event) -> {
            if(ClickId.isEmpty())
            {
               ClickId = img7.getId();
               ClickUrl = img7.getImage().impl_getUrl();
            }else
            {
                SetImage(ClickId, img7.getImage().impl_getUrl());
                SetImage(img7.getId(), ClickUrl);
                 ClickUrl = "";
                 ClickId = "";
            if(Check()){}
            }
        });   
           
           
        img8.setOnMouseClicked((event) -> {
            if(ClickId.isEmpty())
            {
               ClickId = img8.getId();
               ClickUrl = img8.getImage().impl_getUrl();
            }else
            {
                SetImage(ClickId, img8.getImage().impl_getUrl());
                SetImage(img8.getId(), ClickUrl);
                
                 ClickUrl = "";
                 ClickId = "";
            if(Check()){}
            }
        });
                
        img9.setOnMouseClicked((event) -> {
            if(ClickId.isEmpty())
            {
               ClickId = img9.getId();
               ClickUrl = img9.getImage().impl_getUrl();
            }else
            {
                SetImage(ClickId, img9.getImage().impl_getUrl());
                SetImage(img9.getId(), ClickUrl);
                 ClickUrl = "";
                 ClickId = "";
            if(Check()){}
            }
        });         
    }    
    
    
    public void SetImage(String id , String url)
    {
        switch(id)
        {
        case "img1":
                img1.setImage(new Image(url));
                break;
        case "img2":
                img2.setImage(new Image(url));
                break;    
        case "img3":
                img3.setImage(new Image(url));
                break;   
        case "img4":
                img4.setImage(new Image(url));
                break; 
        case "img5":
                img5.setImage(new Image(url));
                break;         
        case "img6":
                img6.setImage(new Image(url));
                break; 
        case "img7":
                img7.setImage(new Image(url));
                break;   
        case "img8":
                img8.setImage(new Image(url));
                break;
        case "img9":
                img9.setImage(new Image(url));
                break;         
        }
    }
    
    public void displayStart()
    {
        img1.setImage(new Image("images/row-1-column-3.png"));
        img2.setImage(new Image("images/row-2-column-3.png"));
        img3.setImage(new Image("images/row-1-column-2.png"));
        img4.setImage(new Image("images/row-3-column-1.png"));
        img5.setImage(new Image("images/row-1-column-1.png"));
        img6.setImage(new Image("images/row-2-column-2.png"));
        img7.setImage(new Image("images/row-3-column-2.png"));
        img8.setImage(new Image("images/row-3-column-3.png"));
        img9.setImage(new Image("images/row-2-column-1.png"));
        
    }
    
    
    public boolean Check()
    {
        if(    img1.getImage().impl_getUrl().contains("images/row-1-column-1.png")
            && img2.getImage().impl_getUrl().contains("images/row-1-column-2.png")
            && img3.getImage().impl_getUrl().contains("images/row-1-column-3.png")
            && img4.getImage().impl_getUrl().contains("images/row-2-column-1.png")
            && img5.getImage().impl_getUrl().contains("images/row-2-column-2.png")
            && img6.getImage().impl_getUrl().contains("images/row-2-column-3.png")
            && img7.getImage().impl_getUrl().contains("images/row-3-column-1.png")
            && img8.getImage().impl_getUrl().contains("images/row-3-column-2.png")
            && img9.getImage().impl_getUrl().contains("images/row-3-column-3.png"))
        {
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
            Next.setDisable(false);
            return true;
        }
        return false;
    }
 
}
