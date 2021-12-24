package application.DB;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Services.DBHandler;
import application.Model.Customer;
import application.Model.StaffMember;

public class StaffMemberDao {
	
	
	
	public StaffMember getStaffMember (String str) {
		int i = Integer.parseInt(str);
		Session session = DBHandler.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       StaffMember sm = (StaffMember)session.get(StaffMember.class, i);
       tx.commit();
       session.close();
       return sm;
	}
}
