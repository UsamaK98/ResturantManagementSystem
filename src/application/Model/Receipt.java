package application.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import application.Controller.*;

@Entity
@Table(name="receipt")
public class Receipt {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="receiptid")
	private int receiptid;
	
	@Column(name="status")
	private String status;
	
	private Order od=new Order();
	private ReserveTable tb;
	
	
	public Receipt(Order od, int receiptid, String status) {
		super();
		this.od = od;
		this.receiptid = receiptid;
		this.status = status;
	}
	
	public Order getOd() {
		return od;
	}
	public ReserveTable getTb() {
		return tb;
	}

	public void setTb(ReserveTable tb) {
		tb=new ReserveTable();
		this.tb = tb;
	}

	public void setOd(Order od) {
		this.od = od;
	}
	public int getReceiptid() {
		return receiptid;
	}
	public void setReceiptid(int receiptid) {
		this.receiptid = receiptid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String receiptdetails() {
		
		String deets;
		od.setTotalTax(449);
		od.setStatus("Confirmed");
		od.setTotalOrderPrice(od.getTotalOrderPrice()+od.getTotalTax());
		deets="receipt id: "+Integer.toString(receiptid)+" status: "+status
				+"\n "+ "Created Time: "+od.getCreationTime()+"\nEstimated time: "+
				od.getEstimatedTimeOf()+"\nOrder details:\nID\tName\tPrice\n"+od.getOrderType()+"\nTotal Tax: "+od.getTotalTax()+" order status: "+od.getStatus()
				+"\n total price: "+od.getTotalOrderPrice();
		if(tb!=null)
		deets+="\n table id: "+ Integer.toString(tb.getTableid());
		return deets;
	}
}
