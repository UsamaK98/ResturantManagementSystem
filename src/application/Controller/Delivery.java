package application.Controller;

import application.Model.Customer;
import application.Model.Order;

public class Delivery {

	Customer c=new Customer();
	Order od=new Order();
	
	public Delivery(Customer c, Order od) {
		super();
		this.c = c;
		this.od = od;
	}
	
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	public Order getOd() {
		return od;
	}
	public void setOd(Order od) {
		this.od = od;
	}
	
	
}
