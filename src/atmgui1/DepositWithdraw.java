package atmgui1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DepositWithdraw {

    public void setmainmenu(Mainmenu mainmenu) {
        this.mainmenu = mainmenu;   
    }
Scene scene;
Stage stage;
Mainmenu mainmenu;
int b;
double balance;
Double deposited;
Double withdrawed;

  
    public DepositWithdraw(Stage stage) {
        this.stage=stage;
    }

    Scene getScene() {
        return scene;
    }
   
    public void prepareScene() {
        
        //creating widgets************************************************************************************************************
        Label money = new Label("Amount of money you wish to use in this operation is:");
        final TextField amount = new TextField();
        amount.setPromptText("Please enter amount of money");
        Button btn1 = new Button();
        btn1.setText("Sumbit");
         Label message = new Label();
        //creating widgets************************************************************************************************************
        
        
        btn1.setOnAction((ActionEvent event) -> {
           b=mainmenu.getB();
            if(b==1){
               String x=amount.getText();
               deposited= Double.valueOf(x);
                balance = balance + deposited;
                stage.setScene(mainmenu.getScene());
              
            }
            if(b==2) 
            {
                
                   String y=amount.getText();
                   withdrawed= Double.parseDouble(y);
                   if (balance-withdrawed >= 0)
                  {
                    balance = balance - withdrawed;
                    stage.setScene(mainmenu.getScene());
                  }
                  else
                     message.setText("Balance in account is insufficient for this withdrawl action");
   
                  }
            
        });
        
        //drawing************************************************************************************************************************
        GridPane grid = new GridPane();
        grid.add(money,1,1);
        grid.add(amount,1,2);
        grid.add(btn1,1,3);
        grid.add(message,1,4);
        //drawing************************************************************************************************************************
        
        scene = new Scene(grid, 400, 150);
       
    }

     public Double getBalance() {
        return balance;
     }

    public Double getWithdrawed() {
        return withdrawed;
    }

    public Double getDeposited() {
        return deposited;
    }
    
    }

   
