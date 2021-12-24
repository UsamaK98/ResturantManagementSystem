package application.View;

import java.io.IOException;

import application.Controller.Resturant;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MenuController {

	@FXML
	Label L1 = new Label();
	
	@FXML
	AnchorPane ap;
	
	public MenuController() {
		String u = Resturant.getUser();
		L1.setText(u);
	}
	
	public void openSeatReservationPage(ActionEvent event) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("SeatReservationPage.fxml"));
		ap.getChildren().setAll(pane);
	}
	
	public void openDeliveryPage(ActionEvent event) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("DeliveryPage.fxml"));
		ap.getChildren().setAll(pane);
		
	}
	
	public void openMainMenuPage(ActionEvent event) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("MainMenuPage.fxml"));
		ap.getChildren().setAll(pane);
	}
	
	public void Logout (ActionEvent event) throws IOException {
		AnchorPane p = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
		ap.getChildren().setAll(p);
	}
	
	public void viewCustomers (ActionEvent e) throws IOException {
		AnchorPane p = FXMLLoader.load(getClass().getResource("ViewCustomersPage.fxml"));
		ap.getChildren().setAll(p);
	}
}
