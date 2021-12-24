package application.View;

import java.io.IOException;

import Services.FileHandler;
import application.Controller.Resturant;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	AnchorPane ap;
	
	@FXML
	private TextField t1;
	
	@FXML
	private TextField t2;
	
	@FXML
	ProgressBar updProg = new ProgressBar();
	
	public void LoginPressed(ActionEvent event) throws IOException, InterruptedException {
		
		FileHandler f = new FileHandler("E:\\AP Workspace\\RestaurantManagementSystem\\StaffMembers.txt");
		if (f.login(t1.getText(), t2.getText())){
			//start();
			AnchorPane pane=FXMLLoader.load(getClass().getResource("CustomerDetailsPage.fxml"));
			ap.getChildren().setAll(pane);
		} else {
			System.out.println("Incorrect Username or Password, Enter Again");
		}
		Resturant.setUser(t1.getText());
		
	}
	
	public void goBack (ActionEvent event) throws IOException {
		AnchorPane p = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
		ap.getChildren().setAll(p);
	}
	
	
	public void start() {
	    Task<Void> task = new Task<Void>() {
	      @Override public Void call() {
	        for (int i = 0; i < 10; i++) {
	          try {
	            Thread.sleep(100);
	          } catch (InterruptedException e) {
	            Thread.interrupted();
	            break;
	          }
	          System.out.println(i + 1);
	          updateProgress(i + 1, 10);
	        }
	        return null;
	      }
	    };

	   // ProgressBar updProg = new ProgressBar();
	    updProg.progressProperty().bind(task.progressProperty());

	    Thread th = new Thread(task);
	    th.setDaemon(true);
	    th.start();

	    StackPane layout = new StackPane();
	    layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
	    layout.getChildren().add(updProg);
	    //stage.setScene(new Scene(layout));
	   // stage.show();
	  }
}
