
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import objects.Burger;
import objects.Side;

public class CartController implements Initializable {

    public static ArrayList<Burger> BurgerOrder = new ArrayList<>();
    public static ArrayList<Side> SideOrder = new ArrayList<>();  
    @FXML private Label order;
    @FXML private Label userTotal;
    private Integer totalBeforeTax;
     
    //Receive arraylist from burger
    public void transferBurgerOrder(ArrayList burger) {
      BurgerOrder = burger; 
      System.out.println(BurgerOrder);   
    }
     
    public void transferSideOrder(ArrayList side){
      SideOrder = side;
      System.out.println(SideOrder);
    }
    
    public void showOrder(){  
    
    StringBuilder burgerString = new StringBuilder();
    StringBuilder sideString = new StringBuilder();
    for(int i = 0; i < BurgerOrder.size(); i++){      
        burgerString.append(BurgerOrder.get(i).toString()).append("\n");   
    }
    for(int i = 0; i < SideOrder.size(); i++){
        sideString.append(SideOrder.get(i).toString()).append("\n");
    }
        
    order.setText(burgerString + "\n" + sideString);
    
    totalBeforeTax = 0;
        for(int i = 0; i < BurgerOrder.size(); i++){
            totalBeforeTax = totalBeforeTax + BurgerOrder.get(i).cost;
        }
        for(int j = 0; j < SideOrder.size(); j++){
            if(SideOrder.get(j)!=null){
                totalBeforeTax = totalBeforeTax + SideOrder.get(j).cost;
            }
        }   
    double tax = Math.round((totalBeforeTax * 0.13)*100)/100;    
    double totalAfterTax =  tax + totalBeforeTax;    
    StringBuilder userTotalString = new StringBuilder();
    
    userTotalString.append("Total Before Tax: $").append(totalBeforeTax).append(".00\n").append("Tax: $").append(tax).append("0\n").append("Total After Tax: $").append(totalAfterTax).append("0");    
    userTotal.setText(userTotalString.toString());
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        
    }       
}
