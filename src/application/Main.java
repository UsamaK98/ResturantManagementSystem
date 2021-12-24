package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Services.DBHandler;
import Services.PersistenceFactory;
import Services.Storage;
import application.DB.CustomerDao;
import application.Model.Customer;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root=FXMLLoader.load(getClass().getResource("View/WelcomePage.fxml"));
			Scene scene=new Scene(root);
			primaryStage.setTitle("Restaurant Management System");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
		PersistenceFactory f = PersistenceFactory.getInstance();
		Storage d = f.createPersistenceHandler("hibernate");
		
		launch(args);
		
	}
}
