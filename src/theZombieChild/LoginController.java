package theZombieChild;


import java.io.IOException;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author imbes
 */
public class LoginController extends nameTable implements Initializable {

    @FXML
    public TextField logName;
    @FXML
    public PasswordField logPass;
    @FXML
    public Label loginlabel;

    //String userName = logName.getText();
    
     /* Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    Stage stage;
    Scene scene;
    Parent root;
    
    @FXML
    private void btOldUser(ActionEvent event) throws HibernateException, IOException {
        String name = logName.getText();
        String password = logPass.getText();
        /*----- CHECK IF INPUT IS EMPTY -----*/
        if (name.equals("") || password.equals("")){
            if (name.equals("") && password.equals("")){
            loginlabel.setText("Plaese enter BOTH name and password");}
            else if (name.equals("")){
            loginlabel.setText("Plaese enter name");}
            else if(password.equals("")){
            loginlabel.setText("Plaese enter password");}}
        /*----- GET DATA -----*/    
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean contains= false;
        if (!name.equals("") || !password.equals("")){
            List<nameTable> uList = null;
            String sql = "FROM nameTable";
            Query result = session.createQuery(sql);
            uList = result.list();
            //System.out.println("item list size: " + uList.size());
            for (nameTable i : uList) {
            String username = i.getName();
            if(name.equals(username)){
            contains= true;
            break;}else{
            contains= false; }
            }
            if(contains){		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fullVid.fxml"));	
		root = loader.load();	
                //endingController scene2Controller = loader.getController();
		//scene2Controller.displayName(name);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else{
            loginlabel.setText("["+name+"] is an invalid name in our databse\n please check again");
            }
            session.getTransaction().commit();
            session.close();}
        }
    }

    
    