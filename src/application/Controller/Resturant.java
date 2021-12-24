package application.Controller;

import java.util.ArrayList;
import java.util.Vector;

import Services.DBHandler;
import Services.Storage;
import application.DB.CustomerDao;
import application.DB.StaffMemberDao;
import application.Model.Customer;
import application.Model.Order;
import application.Model.StaffMember;

public class Resturant {
	
	private static String username = null;
	
	private ArrayList<ReserveTable> reserveTables=new ArrayList<ReserveTable>();
	private Vector<MainCourse> mc=new Vector<MainCourse>();
	private Vector<Beverages> bg=new Vector<Beverages>();
	private Vector<Desert> ds=new Vector<Desert>();
	private Order order=new Order();
	private float totalprice=0;
	
	public void addCustomer(String name, String age, String gender, String contactNumber, String email, String address) {
		Customer c = new Customer (name, age, gender, contactNumber, email, address);
		CustomerDao cd = new CustomerDao();
		cd.saveOrUpdate(c);
	}
	
	public static void setUser (String name) {
		username = name;
	}
	
	public static String getUser() {
		return username;
	}

}	
