
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private HBox AnchorPane;
    @FXML
    private Pane contentArea;

    //Initializes and loads the home page
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    //Loads the home page
    @FXML
    private void openHome(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
    
    //Loads the cart page
      @FXML
    private void cart(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Cart.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
    
    //Loads the burger page
    @FXML
    private void openBurger(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Burger.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
    
    //Loads the sides page
        @FXML
    private void openSides(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Sides.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }    
    
    //Exits the application
    @FXML
    private void closeApp(MouseEvent event) {
        System.exit(0);
    }
    
    //Minimizes the application
    @FXML
    private void minimizeApp(MouseEvent event) {
       Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.setIconified(true);
    }
    
}
