package application.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Services.Oracle;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String Name;
	
	@Column(name="age")
	private String Age;
	
	@Column(name="gender")
	String Gender;
	
	@Column(name="contactno")
	String ContactNumber;
	
	@Column(name="email")
	String Email;
	
	@Column(name="address")
	String Address;
	
	//Oracle oc=new Oracle();
	
	public Customer() {
		super();
	}
	public Customer(String name, String age, String gender, String contactNumber, String email, String address) {
		super();
		Name = name;
		Age = age;
		Gender = gender;
		ContactNumber = contactNumber;
		Email = email;
		Address = address;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

	
}
