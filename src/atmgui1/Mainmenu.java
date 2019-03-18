 package atmgui1;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Mainmenu  {
     Stage stage;
     Scene scene;
     LoginForm AtmGui1;
     DepositWithdraw depositWithdraw;
     int b;
     Double balance2; 
     int i=0;
     Double deposited;
     Double withdrawed;
     ArrayList<transactions> History =new ArrayList<transactions>();
     int count=0;
     
    public Mainmenu(Stage stage)
    {
    this.stage =stage;
    }

    public void setDepositWithdraw(DepositWithdraw depositWithdraw) {
        this.depositWithdraw = depositWithdraw;
    }
    
    public void prepareScene() 
    {    
         //creating widgets************************************************************************************************************
        Button btn1 = new Button();
        btn1.setText("DEPOSIT");
        Button btn2 = new Button();
        btn2.setText("Withdrawl");
        Button btn3 = new Button();
        btn3.setText("Balance Inqury");
        Button btn4 = new Button();
        btn4.setText("Previos Transaction");
        Button btn5 = new Button();
        btn5.setText("Next Transaction");
        Label message = new Label();
        //creating widgets************************************************************************************************************
      
       //Deposit Set On Action*********************************************************************************************************************
       btn1.setOnAction((ActionEvent event) -> {
           b=1;
           depositWithdraw.prepareScene();
           stage.setScene(depositWithdraw.getScene());
           deposited= depositWithdraw.getDeposited();
           transactions transaction2 = new transactions("deposit",deposited);
           History.add(transaction2);
            i=i+1;
           count=0;
            });
        //Withdraw Set On Action*******************************************************************************************************************
        
        btn2.setOnAction((ActionEvent event) -> {
           b=2;
           depositWithdraw.prepareScene();
            stage.setScene(depositWithdraw.getScene());
            withdrawed= depositWithdraw.getWithdrawed();
            transactions transaction1 = new transactions("withdraw",withdrawed);
            History.add(i,transaction1);
           i=i+1;
            //i=History.size();
           count=0;
        });
       //balance inquiry Set On Action*******************************************************************************************************************
        btn3.setOnAction((ActionEvent event) -> {
            balance2 = depositWithdraw.getBalance();
            message.setText("Your balnce now is: " +balance2 
                    +"\n\n You may have to press on balance require\nbutton again if you did any new transaction \n to reupdate balance" );  
            count=0;
        });
         //previous Set On Action*******************************************************************************************************************
        btn4.setOnAction((ActionEvent event) -> {
            if(count<5){
            transactions LastTrans = History.get(i-count-1);
            message.setText("type of transaction: " +LastTrans.getType() + "\n Amount: " +LastTrans.getQuantity());
             count= count + 1;
            }
            else 
            {
                message.setText("Your history view has Max. of viewing the last 5 transaction only");
            }
           
        });  
        //Next Set On Action*******************************************************************************************************************
        btn5.setOnAction((ActionEvent event) -> {
            if(count==0)
            {
                message.setText("This was your last transaction.\n Your history view has Max. of viewing the\n last 5 transaction only");
            }
           else{
            transactions LastTrans = History.get(i-count+1);
            message.setText("type of transaction: " +LastTrans.getType() + "\n Amount: " +LastTrans.getQuantity()); 
             count= count - 1;
            }
        });

        //drawing************************************************************************************************************************
        GridPane grid = new GridPane();
        
        grid.add(btn1,0,0);
        grid.add(btn2,0,1);
        grid.add(btn3,0,2);
        grid.add(btn4,0,3);
        grid.add(btn5,0,4);
        grid.add(message,0,6);
        //drawing************************************************************************************************************************
        scene = new Scene(grid, 300, 250);
        
        
    }
    
    public void setLoginForm(LoginForm AtmGui1) {
        this.AtmGui1 = AtmGui1;
    }

    Scene getScene() {
         return this.scene;
    }

    public int getB() {
        return b;
    }

    public ArrayList<transactions> getHistory() {
        return History;
    }


    

}
