package application.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderid")
	int OrderID;
	
	@Column(name="ordertype")
	String OrderType;
	
	@Column(name="creationtime")
	String CreationTime;
	
	@Column(name="estimatedtime")
	String EstimatedTimeOf;
	
	@Column(name="status")
	String status;
	
	@Column(name="t_price")
	float TotalOrderPrice;
	
	@Column(name="t_tax")
	float TotalTax;
	
	@Column(name="p_method")
	String PaymentMethod;
	
	public Order(int orderID, String orderType, String creationTime, String estimatedTimeOf, String status,
			float totalOrderPrice, float totalTax, String paymentMethod)
	{
		super();
		OrderID = orderID;
		OrderType = orderType;
		CreationTime = creationTime;
		EstimatedTimeOf = estimatedTimeOf;
		this.status = status;
		TotalOrderPrice = totalOrderPrice;
		TotalTax = totalTax;
		PaymentMethod = paymentMethod;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getOrderType() {
		return OrderType;
	}
	public void setOrderType(String orderType) {
		OrderType = orderType;
	}
	public String getCreationTime() {
		return CreationTime;
	}
	public void setCreationTime(String creationTime) {
		CreationTime = creationTime;
	}
	public String getEstimatedTimeOf() {
		return EstimatedTimeOf;
	}
	public void setEstimatedTimeOf(String estimatedTimeOf) {
		EstimatedTimeOf = estimatedTimeOf;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getTotalOrderPrice() {
		return TotalOrderPrice;
	}
	public void setTotalOrderPrice(float totalOrderPrice) {
		TotalOrderPrice = totalOrderPrice;
	}
	public float getTotalTax() {
		return TotalTax;
	}
	public void setTotalTax(float totalTax) {
		TotalTax = totalTax;
	}
	public String getPaymentMethod() {
		return PaymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}
}
