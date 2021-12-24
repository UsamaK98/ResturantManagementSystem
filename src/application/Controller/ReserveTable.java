package application.Controller;

public class ReserveTable {

	int tableid;
	boolean reserved;
	
	public ReserveTable(int tableid, boolean reserved) {
		super();
		this.tableid = tableid;
		this.reserved = reserved;
	}
	public ReserveTable() {
		// TODO Auto-generated constructor stub
	}
	public int getTableid() {
		return tableid;
	}
	public void setTableid(int tableid) {
		this.tableid = tableid;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	
}
