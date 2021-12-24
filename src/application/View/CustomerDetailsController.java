package application.View;

import java.io.IOException;

import Services.FileHandler;
import Services.PersistenceFactory;
import application.Controller.Resturant;
import application.Model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CustomerDetailsController {
	
	@FXML
	AnchorPane ap;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField age;
	
	@FXML
	private TextField contact;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField address;
	
	@FXML
	private MenuButton i;
	
	private String myGender;
	
	public void CustomerEntered(ActionEvent event) throws IOException {
		
		Resturant r = PersistenceFactory.getMyRes();
		r.addCustomer(name.getText(),age.getText(), myGender,contact.getText(),email.getText(),address.getText());
		AnchorPane pane=FXMLLoader.load(getClass().getResource("Menu.fxml"));
		ap.getChildren().setAll(pane);
	}
	
	public void setMale (ActionEvent e) {
		myGender="Male";
		i.setText(myGender);
	}
	
	public void setFemale (ActionEvent e) {
		myGender="female";
		i.setText(myGender);
	}
	
	public void setOther (ActionEvent e) {
		myGender="Other";
		i.setText(myGender);
	}
	
	public void goBack (ActionEvent e) throws IOException {
		AnchorPane p = FXMLLoader.load(getClass().getResource("Login.fxml"));
		ap.getChildren().setAll(p);
	}
	
	public void getGender(ActionEvent e) {
		i.setText(myGender);
	}
	
	public void skip (ActionEvent e) throws IOException {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("Menu.fxml"));
		ap.getChildren().setAll(pane);
	}
}
