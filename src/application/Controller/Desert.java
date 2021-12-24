package application.Controller;

public class Desert extends MenuItem {

	private String Flavour;
	private String scoops;
	
	public Desert(int id, String name, float price,String f,String sc) {
		super(id, name, price);
		// TODO Auto-generated constructor stub
		setFlavour(f);
		setScoops(sc);
	}

	public String getFlavour() {
		return Flavour;
	}

	public void setFlavour(String flavour) {
		Flavour = flavour;
	}

	public String getScoops() {
		return scoops;
	}

	public void setScoops(String scoops) {
		this.scoops = scoops;
	}
	
}
