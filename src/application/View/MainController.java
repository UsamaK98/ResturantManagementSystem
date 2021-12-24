package application.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;

import Services.Oracle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Model.*;
import application.Controller.*;

public class MainController {

	@FXML
	AnchorPane ap;
	@FXML
	private TextField t1;
	@FXML
	private TextField t2;
	@FXML
	private TextField t3;
	@FXML
	private TextField t4;
	@FXML
	private TextField t5;
	@FXML
	private TextField t6;
	@FXML
	private ChoiceBox<String> cb;
	@FXML
	private TextArea ta;
	static String Maincourses="";
	static String totalorder="";
	
	ArrayList<ReserveTable> reserveTables=new ArrayList<ReserveTable>();
	Vector<MainCourse> mc=new Vector<MainCourse>();
	Vector<Beverages> bg=new Vector<Beverages>();
	Vector<Desert> ds=new Vector<Desert>();
	Order order=new Order();
	static float totalprice=0;
	static Customer c;
	static Oracle oc=new Oracle();
	
public void openCustomerPage(ActionEvent event) throws IOException {
		
		AnchorPane pane=FXMLLoader.load(getClass().getResource("Customerpage.fxml"));
		ap.getChildren().setAll(pane);
	}


public void StaffEntered(ActionEvent event) throws IOException {

	StaffMember s=new StaffMember(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText());
	//s.addStaff();	
	oc.NewStaff(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText());
	
	oc.writeinfile(t1.getText());

	AnchorPane pane=FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
	//AnchorPane pane=FXMLLoader.load(getClass().getResource("Menu.fxml"));
	ap.getChildren().setAll(pane);
}


public void openStaffPage(ActionEvent event) throws IOException {
		
		AnchorPane pane=FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
		ap.getChildren().setAll(pane);
	}

public void LoginSelected(ActionEvent event) throws IOException {
	

	System.out.println("yheggferfdf ");
	AnchorPane pane=FXMLLoader.load(getClass().getResource("Login.fxml"));
	ap.getChildren().setAll(pane);
	
}


public void Gohome(ActionEvent event) throws IOException {
	

	AnchorPane pane=FXMLLoader.load(getClass().getResource("StaffPage.fxml"));
	ap.getChildren().setAll(pane);
	
}


public void CancelOrder(ActionEvent event) throws IOException {
	

	Maincourses="";
	totalorder="";
	totalprice=0;
	AnchorPane pane=FXMLLoader.load(getClass().getResource("OrderCanceled.fxml"));
	ap.getChildren().setAll(pane);
	
}
	
public void LoginEntered(ActionEvent event) throws IOException {
	
	
	String staffid=t2.getText();
	Boolean check=false;
	String line;
	check=oc.login(staffid);
	if(check) {
		AnchorPane pane=FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
		//AnchorPane pane=FXMLLoader.load(getClass().getResource("Menu.fxml"));
		ap.getChildren().setAll(pane);
	}
	else {
		System.out.println("dsds ");
		t1.appendText("Incorrect Staff Id.Enter Again");
	}
}



public void checkDetails(ActionEvent event) throws IOException {
	
	t1.setText(c.getName());
	t2.setText(c.getAge());
	t3.setText(c.getGender());
	t4.setText(c.getContactNumber());
	t5.setText(c.getEmail());
	t6.setText(c.getAddress());
	
}

public void openStaffRegPage(ActionEvent event) throws IOException {
		
		AnchorPane pane=FXMLLoader.load(getClass().getResource("StaffRegpage.fxml"));
		ap.getChildren().setAll(pane);
	}


public void openUpdateorder(ActionEvent event) throws IOException {
		
		AnchorPane pane=FXMLLoader.load(getClass().getResource("UpdateOrder.fxml"));
		ap.getChildren().setAll(pane);
	}





public void ReserveSeat(ActionEvent event) throws IOException {
	
	ReserveTable tb=new ReserveTable(Integer.parseInt(t5.getText()),true);
	
	Reservation rs=new Reservation(t1.getText(),t2.getText(),t3.getText(),Integer.parseInt(t4.getText()),tb);
	reserveTables.add(tb);
	
	rs.addReservedSeat();
	
	AnchorPane pane=FXMLLoader.load(getClass().getResource("Menu.fxml"));
	ap.getChildren().setAll(pane);
}




public void DesertPage(ActionEvent event) throws IOException {
	
	AnchorPane pane=FXMLLoader.load(getClass().getResource("DesertPage.fxml"));
	ap.getChildren().setAll(pane);
	
	
	
}


public void BeveragesPage(ActionEvent event) throws IOException {
	
	AnchorPane pane=FXMLLoader.load(getClass().getResource("BeveragesPage.fxml"));
	ap.getChildren().setAll(pane);
	
	
	
}


public void openMainCoursePage(ActionEvent event) throws IOException {
	
	AnchorPane pane=FXMLLoader.load(getClass().getResource("MainCoursePage.fxml"));
	ap.getChildren().setAll(pane);
	
}


public void PaymentMethodPage(ActionEvent event) throws IOException {
	
	AnchorPane pane=FXMLLoader.load(getClass().getResource("PaymentMethodPage.fxml"));
	ap.getChildren().setAll(pane);
}
public void fillChoiceBoxwithMainCourseItems(ActionEvent event) {
	
	mc.add(new MainCourse(456,"Chicken Manchurian",300));
	mc.add(new MainCourse(443,"Spaghetti",200));
	mc.add(new MainCourse(655,"Chicken karahi",500));
	mc.add(new MainCourse(986,"Schezuan chicekn",800));
	
	Vector<String> options=new Vector<String>();
	
	for(MainCourse i : mc ) {
		options.add(i.getName());
	}
	
	cb.getItems().addAll(options);
}


public void fillChoiceBoxwithBeverages(ActionEvent event) {
	
	
	bg.add(new Beverages(23,"Coca Cola",100,"Regular"));
	bg.add(new Beverages(72,"Pina colada",300,"Large"));
	bg.add(new Beverages(68,"Mint margarita",400,"Regular"));
	bg.add(new Beverages(23,"Lemonade",200,"Small"));
	
	Vector<String> options=new Vector<String>();
	
	for(Beverages i : bg ) {
		options.add(i.getName());
	}
	
	cb.getItems().addAll(options);
}


public void fillChoiceBoxwithDesert(ActionEvent event) {
	
	ds.add(new Desert(44,"lava Cake",400,"Chocolate","1 plate"));
	ds.add(new Desert(12,"Ice cream",100,"Mango","2 scoops"));
	ds.add(new Desert(50,"Cheese Cake",500,"cheese","1 plate"));
	ds.add(new Desert(69,"Pastry",200,"Vanilla","1 slice"));
	
	
	Vector<String> options=new Vector<String>();
	
	for(Desert i : ds ) {
		options.add(i.getName());
	}
	
	cb.getItems().addAll(options);
}



public void getMainCourse(ActionEvent event) throws IOException {
	
	
	
	String val=cb.getValue();boolean check=false;
	for(MainCourse i : mc ) {
		if(i.getName().equals(val))
		{
			check=true;
			Maincourses+=Integer.toString(i.getId())+" "+i.getName()+" "+Integer.toString((int) i.getPrice())+"\n";
			totalorder+=Integer.toString(i.getId())+" ";
			totalprice+=i.getPrice();
			break;
		}
	}
	
	System.out.println(Maincourses+"\n"+totalprice + "\n");
	
	//AnchorPane pane=FXMLLoader.load(getClass().getResource("MainMenuPage.fxml"));
	//ap.getChildren().setAll(pane);
	
}
	

public void getBeverages(ActionEvent event) throws IOException {
	
	
	
	String val=cb.getValue();boolean check=false;
	for(Beverages i : bg ) {
		if(i.getName().equals(val))
		{
			check=true;
			Maincourses+=Integer.toString(i.getId())+" "+i.getName()+" "+Integer.toString((int) i.getPrice())+ " "+i.getSize()+"\n";
			totalorder+=Integer.toString(i.getId())+" ";
			
			totalprice+=i.getPrice();
			break;
		}
	}
	
	System.out.println(Maincourses+"\n"+totalprice + "\n");
	
	//AnchorPane pane=FXMLLoader.load(getClass().getResource("MainMenuPage.fxml"));
	//ap.getChildren().setAll(pane);
	
}


public void getDesert(ActionEvent event) throws IOException {

	
	String val=cb.getValue();boolean check=false;
	for(Desert i : ds ) {
		if(i.getName().equals(val))
		{
			check=true;
			Maincourses+=Integer.toString(i.getId())+" "+i.getName()+" "+Integer.toString((int) i.getPrice())+" "+i.getFlavour()+" "+i.getScoops()+"\n";
			totalorder+=Integer.toString(i.getId())+" ";
			
			totalprice+=i.getPrice();
			break;
		}
	}
	
	System.out.println(Maincourses+"\n"+totalprice + "\n");
	
//	AnchorPane pane=FXMLLoader.load(getClass().getResource("MainMenuPage.fxml"));
//	ap.getChildren().setAll(pane);
	
}

public void confirmOrder(ActionEvent event) throws IOException {
	
	AnchorPane pane=FXMLLoader.load(getClass().getResource("receipt.fxml"));
	ap.getChildren().setAll(pane);

}


public void cancelOrder(ActionEvent event) throws IOException {
	
	AnchorPane pane=FXMLLoader.load(getClass().getResource("OrderCanceled.fxml"));
	ap.getChildren().setAll(pane);

}

public  void Printreceipt(ActionEvent event) throws IOException {
		
	Random ran=new Random();
	int id=ran.nextInt(5000);
	order.setOrderID(id);
	order.setCreationTime(java.time.LocalTime.now().toString());
	order.setEstimatedTimeOf("30minutes");
	order.setPaymentMethod("Cash");
	order.setStatus("In process");
	order.setTotalOrderPrice(totalprice);
	order.setOrderType(Maincourses);
	ReserveTable tb=new ReserveTable(ran.nextInt(1000),true);
	int rid=ran.nextInt(7000);
	Receipt rc=new Receipt(order,rid,"Paid");
	rc.setTb(tb);
	//int reciptid, String status, String ctime, String et, String ordertype, String totaltax,String ostatus,String tp
	String deets=rc.receiptdetails();
	System.out.println(totalorder);
	oc.NewReceipt(rid, "Paid", order.getCreationTime(), order.getEstimatedTimeOf(), totalorder, Float.toString(order.getTotalTax()), order.getStatus(), Float.toString(order.getTotalOrderPrice()));
	ta.setText(deets);
}
	
}
