
package atmgui1;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;

public class AtmBank extends Application {
    
 public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("           ATM      ");
        //send stage
        Mainmenu mainmenu= new Mainmenu(primaryStage);
        LoginForm loginForm= new LoginForm(primaryStage);
        DepositWithdraw depositWithdraw=new DepositWithdraw(primaryStage);
        
        //prepare scene
        loginForm.preparescene();
        mainmenu.prepareScene();
        depositWithdraw.prepareScene();
        
        //introduce
        loginForm.setMainmenu(mainmenu);
        mainmenu.setDepositWithdraw(depositWithdraw);
        depositWithdraw.setmainmenu(mainmenu);
        
        

        
        primaryStage.setScene(loginForm.getScene());
        primaryStage.show();
        
        
        
    }}

    

   

