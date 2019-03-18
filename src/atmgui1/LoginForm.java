
package atmgui1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginForm {
    Stage stage;
    Scene scene;
    Mainmenu Mainmenu;
    public void setMainmenu(Mainmenu Mainmenu) {
        this.Mainmenu = Mainmenu;
    }

    public LoginForm(Stage stage) {
        this.stage = stage;
    }

    LoginForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void preparescene() {
      
        //creating buttons************************************************************************************************************
        Button btn1 = new Button();
        btn1.setText("Login");
        final TextField Cardnumber = new TextField();
        Cardnumber.setPromptText("Enter your Card number");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter your password");
        Label welcome = new Label("          WELCOME   ");
        Label cardNumber = new Label("card number:");
        Label passWord = new Label("password:");
        Label message = new Label();
        //creating buttons************************************************************************************************************
        //Set On Action*********************************************************************************************************************
  
        btn1.setOnAction((ActionEvent event) -> {
            String Card = Cardnumber.getText();
            String Word = password.getText();
            boolean valid ;
             valid = Word.equals("jolie") && Card.equals("5865");
           if(valid==true)
            {
               stage.setScene(Mainmenu.getScene());
            }
            else
            {
            message.setText("wrong card number or password");
                
            }
        });
        //Set On Action*******************************************************************************************************************
        //drawing************************************************************************************************************************
        GridPane grid = new GridPane();
        grid.add(welcome,0,0);
        grid.add(cardNumber,0,1);
        grid.add(passWord,0,2);
        grid.add(Cardnumber,1,1);
        grid.add(password,1,2);
        grid.add(btn1,1,3);
        grid.add(message,1,4);
        
        //drawing************************************************************************************************************************
        
    scene = new Scene(grid, 300,200);
    
    }

    //public void setScene1(Scene scene) {
      //  this.scene = scene;
    //}

   // public Stage getStage() {
     //   return stage;
    //}


    public Mainmenu getMainmenu() {
        return Mainmenu;
    }

    Scene getScene() {
        return this.scene;
    }
     
    
}
