package application.Controller;

public class Beverages extends MenuItem {


	private String size;
	
	public Beverages(int id, String name, float price,String s) {
		super(id, name, price);
		// TODO Auto-generated constructor stub
		setSize(s);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
	
}

