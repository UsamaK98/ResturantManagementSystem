package application.DB;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Services.DBHandler;
import application.Model.Customer;

public class CustomerDao {
	
	public void saveCustomer (Customer c) {
		Transaction transaction = null;
		try (Session session = DBHandler.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(c);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Customer> getCustomers() {
		try (Session session = DBHandler.getSessionFactory().openSession()) {
			return session.createQuery("from Customer", Customer.class).list();
		}
	}

	public Customer getCustomer(Class<Customer> class1, int i) {
		try (Session session = DBHandler.getSessionFactory().openSession()) {
			return session.get(Customer.class, i);
		}
	}

	public void saveOrUpdate(Customer student2) {
		
		Transaction transaction = null;
		try (Session session = DBHandler.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.saveOrUpdate(student2);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}	
	}
	public Customer getCustomerbyId(int id) {

		Transaction transaction = null;
		Customer student = null;
		try (Session session = DBHandler.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// get an student object
			String hql = " FROM Student S WHERE S.id = :customerId";
			Query query = session.createQuery(hql);
			query.setParameter("studentId", id);
			List<Customer> results = query.getResultList();
			
			if (results != null && !results.isEmpty()) {
				student = (Customer) results.get(0);
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}

}