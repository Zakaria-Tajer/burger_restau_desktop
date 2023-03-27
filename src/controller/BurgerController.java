package controller;

import java.io.IOException;
import objects.Burger;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class BurgerController implements Initializable {
    
    //Variable Declaration
    public static ArrayList<Burger> BurgerOrder = new ArrayList<>();
    public static String userBurgerChoice;
    public Integer cost;
    @FXML private Pane pane;
    @FXML private ChoiceBox size;
    @FXML private ChoiceBox bun;
    @FXML private CheckBox ketchup;
    @FXML private CheckBox mustard;
    @FXML private CheckBox mayonaise;
    @FXML private Label burgerName;
    @FXML private Button cancel;
    @FXML private Button cart;
    @FXML private Button inc;    //Decreases the quantity on the screen

    @FXML private Button dec;
    @FXML private Label quantityLabel;
    public Integer quantityInt;     
    
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
    
    //Determines the cost of the burger, creates a new burger object, and transfers the arraylist to the cart
    public void addToCart(){
        if (userBurgerChoice.equals("The Classic")){
            cost = 6 * Integer.parseInt(quantityLabel.getText());
                
            if(size.getValue().equals("Medium")){
                cost = cost + (1 * Integer.parseInt(quantityLabel.getText()));
            }
            if(size.getValue().equals("Large")){
                cost = cost + (2 * Integer.parseInt(quantityLabel.getText()));
            }
        }
        if (userBurgerChoice.equals("Mighty Angus") || userBurgerChoice.equals("Steakhouse")){
            cost = 7 * Integer.parseInt(quantityLabel.getText());    
            if(size.getValue().equals("Medium")){
                cost = cost + (1 * Integer.parseInt(quantityLabel.getText()));
            }
            if(size.getValue().equals("Large")){
                cost = cost + (2 * Integer.parseInt(quantityLabel.getText()));
            }
        }
        if (userBurgerChoice.equals("Big Bertha")){
            cost = 8 * Integer.parseInt(quantityLabel.getText());
                
            if(size.getValue().equals("Medium")){
                    cost = cost + (1 * Integer.parseInt(quantityLabel.getText()));
                }
            if(size.getValue().equals("Large")){
                    cost = cost + (2 * Integer.parseInt(quantityLabel.getText()));
                }
        }   
        Burger newBurger = new Burger(userBurgerChoice, size.getValue().toString(), bun.getValue().toString(), ketchup.isSelected(), mustard.isSelected(), mayonaise.isSelected(), Integer.parseInt(quantityLabel.getText()), cost);    
        BurgerOrder.add(newBurger); 
               try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Cart.fxml"));
            Parent root = loader.load();
             
            //Get controller of scene2
            CartController userCart = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            userCart.transferBurgerOrder(BurgerOrder);
 
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    //If the user selected The Classic
    public void chooseClassic(){
         userBurgerChoice = "The Classic"; 
        burgerName.setText(userBurgerChoice);
    }
    
    //If the user selected Mighty Angus
    public void chooseAngus() {
        userBurgerChoice = "Mighty Angus"; 
        burgerName.setText(userBurgerChoice);
    }
   
    //If the user selected Big Bertha
    public void chooseBertha() {
        userBurgerChoice = "Big Bertha"; 
        burgerName.setText(userBurgerChoice);
    }
    
    //If the user selected Steakhouse
    public void chooseSteak() {
        userBurgerChoice = "Steakhouse"; 
        burgerName.setText(userBurgerChoice);
    }
    
    //Resets some of the variables (burgerName, size, bun)
    public void cancelOrder(){
        burgerName.setText("Burger Customizations");
        size.setValue("Small");
        bun.setValue("White");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        size.getItems().addAll("Small", "Medium", "Large");
        size.setValue("Small");
        bun.getItems().addAll("White", "Sesame", "Whole Wheat", "Gluten Free");
        bun.setValue("White");
    }       
}
