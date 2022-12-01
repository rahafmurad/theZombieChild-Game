package theZombieChild;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenController {

 private Stage stage;
 private Scene scene;
 private Parent root;
 
 
 public void login(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 
  public void fullVid(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("fullVid.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 
  public void PicPuzzle(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("PicPuzzle.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
  
  public void choices(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("choices.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
  
  public void CloseByClicking(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("CloseByClicking.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
  
  public void DragThePig(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("DragThePig.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
  
  public void MemoryCardPuzzle(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("MemoryCardPuzzle.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
  
  public void Ending(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("End.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
}
