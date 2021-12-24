package Services;

import java.lang.Object;

import application.Controller.Resturant;

public class PersistenceFactory {
	
	private static PersistenceFactory instance=null;
	private Storage service;
	private static Resturant myRes = null;
	
	private PersistenceFactory() {
		myRes = new Resturant();
	}
	
	public static synchronized PersistenceFactory getInstance () {
		if (instance==null) {
			instance = new PersistenceFactory();
		}
		return instance;
	}
	
	public Storage createPersistenceHandler(String servName) {
		if(service==null) {
			if (servName.equals("hibernate")){
				service = new DBHandler();
			} else if (servName.equals("file")) {
				service = new FileHandler();	
			}else {
				System.out.println("Unknown persistence service!");
			}	
		}
		return service;
	}

	public static Resturant getMyRes() {
		return myRes;
	}

	
}
