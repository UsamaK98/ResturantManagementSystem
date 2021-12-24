package application.Model;

import Services.Oracle;

public class StaffMember {
	
	String StaffID;
	String Shift;
	String Salary;
	String BreakTime;
	String Status;
	String StaffType;
	Oracle oc=new Oracle();
	
	public StaffMember(String staffID, String shift, String salary, String breakTime, String status, String staffType) {
		super();
		StaffID = staffID;
		Shift = shift;
		Salary = salary;
		BreakTime = breakTime;
		Status = status;
		StaffType = staffType;
	}
	
	public String getStaffID() {
		return StaffID;
	}
	public void setStaffID(String staffID) {
		StaffID = staffID;
	}
	public String getShift() {
		return Shift;
	}
	public void setShift(String shift) {
		Shift = shift;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}
	public String getBreakTime() {
		return BreakTime;
	}
	public void setBreakTime(String breakTime) {
		BreakTime = breakTime;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getStaffType() {
		return StaffType;
	}
	public void setStaffType(String staffType) {
		StaffType = staffType;
	}
	
}
