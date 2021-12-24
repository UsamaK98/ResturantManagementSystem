package Services;

import java.util.List;

import application.Model.Customer;
import application.Model.Receipt;
import application.Model.StaffMember;

public interface Storage {
	 
	void NewCustomer(Customer c);
	void NewReceipt(Receipt r);
	void NewStaff(StaffMember s);
	void ReservedSeats();
	
}
