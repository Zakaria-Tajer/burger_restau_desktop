package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import objects.Side;

public class SidesController implements Initializable {
   
    public static ArrayList<Side> SideOrder = new ArrayList<>();
    @FXML ChoiceBox size;
    @FXML Label quantityLabel;
    @FXML Label sideName;
    private Integer quantityInt;
    private String userSize;
    private String side;
    private Integer cost;
    
     public void increaseQuantity() {
    quantityInt = Integer.parseInt(quantityLabel.getText()) + 1;
    quantityLabel.setText(quantityInt.toString());
    }
    public void decreaseQuantity() {
        quantityInt = Integer.parseInt(quantityLabel.getText()) - 1;
        if (quantityInt < 1){
            quantityLabel.setText("1");
        } else{
            quantityLabel.setText(quantityInt.toString());
        }
    }
    
    public void addToCart() {
            if (sideName.getText().equals("Nestea") || sideName.getText().equals("Sprite") || sideName.getText().equals("Coke") || sideName.getText().equals("Nestea") ||sideName.getText().equals("Fanta") || sideName.getText().equals("Root Beer") || sideName.getText().equals("Coke Zero")){
            cost = 1 * Integer.parseInt(quantityLabel.getText());
                
            if(size.getValue().equals("Medium")){
                cost = cost + (1 * Integer.parseInt(quantityLabel.getText()));
            }
            if(size.getValue().equals("Large")){
                cost = cost + (2 * Integer.parseInt(quantityLabel.getText()));
            }
        }
            
            if(sideName.equals("French Fries") || sideName.equals("Poutine") || sideName.equals("Onion Rings") || sideName.equals("Curly Fries")){
            cost = 4 * Integer.parseInt(quantityLabel.getText());
                
            if(size.getValue().equals("Medium")){
                cost = cost + (1 * Integer.parseInt(quantityLabel.getText()));
            }
            if(size.getValue().equals("Large")){
                cost = cost + (2 * Integer.parseInt(quantityLabel.getText()));
            }
        }
       
           Side newSide = new Side(sideName.getText(), size.getValue().toString(), Integer.parseInt(quantityLabel.getText()), cost);    
           SideOrder.add(newSide); 
               try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Cart.fxml"));
            Parent root = loader.load();
         
            //Get controller of scene2
            CartController userCart = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            userCart.transferSideOrder(SideOrder);
 
        } catch (IOException ex) {
            System.err.println(ex);
        }    
    }
    
    public void chooseNestea() {
        String userSideChoice = "Nestea"; 
        sideName.setText(userSideChoice);
    }
    public void chooseSprite() {
        String userSideChoice = "Sprite"; 
        sideName.setText(userSideChoice);
    }
    public void chooseCoke() {
        String userSideChoice = "Coke"; 
        sideName.setText(userSideChoice);
    }
    public void chooseFanta() {
        String userSideChoice = "Fanta"; 
        sideName.setText(userSideChoice);
    }
    public void chooseRootBeer() {
        String userSideChoice = "Root Beer"; 
        sideName.setText(userSideChoice);
    }
    public void chooseCokeZero() {
        String userSideChoice = "Coke Zero"; 
        sideName.setText(userSideChoice);
    }
    public void chooseFries() {
        String userSideChoice = "French Fries"; 
        sideName.setText(userSideChoice);
    }
    public void chooseCurlyFries() {
        String userSideChoice = "Curly Fries"; 
        sideName.setText(userSideChoice);
    }
        public void chooseOnionRings() {
        String userSideChoice = "Onion Rings"; 
        sideName.setText(userSideChoice);
    }
            public void choosePoutine() {
        String userSideChoice = "Poutine"; 
        sideName.setText(userSideChoice);
    }
            
    public void cancelOrder() {
        sideName.setText("Order");
        size.setValue("Small");
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       size.getItems().addAll("Small", "Medium", "Large");
       size.setValue("Small");
    }    
    
}
