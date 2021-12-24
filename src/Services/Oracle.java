package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import application.Model.Customer;
import application.Model.Receipt;
import application.Model.StaffMember;

public class Oracle implements Storage {

		
		public void NewCustomer(String name, String age, String gender, String contactNumber, String email, String address) {
			
			try 
	    	{

				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","tiger1234");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				stmt.executeQuery(" insert into Customer values(' "+name+" ',' "+age+" ',' "+gender+" ', ' "+contactNumber+" ',' "+email+" ', ' "+address+" ' ) ");
				//step4 execute query  
	    		con.close();
	    	}
	    	catch(ClassNotFoundException e)
	    	{
	    		System.out.println("Driver not loaded");
	    	}
	    	catch(SQLException e)
	    	{
	    		System.out.println("Connection not established");
	    	}
			
		}
		
public void NewReceipt(int reciptid, String status, String ctime, String et, String ordertype, String totaltax,String ostatus,String tp) {
			
			try 
	    	{

				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","tiger1234");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				stmt.executeQuery(" insert into Receipt values(' "+Integer.toString(reciptid)+" ',' "+status+" ',' "+ctime+" ', ' "+et+" ',' "+ordertype+" ', ' "+totaltax+"  ', ' "+ostatus+"  ', ' "+tp+"  ' ) ");
				//step4 execute query  
				System.out.println(" insert into Receipt values(' "+Integer.toString(reciptid)+" ',' "+status+" ',' "+ctime+" ', ' "+et+" ',' "+ordertype+" ', ' "+totaltax+"  ', ' "+ostatus+"  ', ' "+tp+"  ' )");
	    		con.close();
	    	}
	    	catch(ClassNotFoundException e)
	    	{
	    		System.out.println("Driver not loaded");
	    	}
	    	catch(SQLException e)
	    	{
	    		System.out.println("Connection not established");
	    	}
			
		}
		
	public void NewStaff(String staffID, String shift, String salary, String breakTime, String status, String staffType) {
			
			try 
	    	{

				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","tiger1234");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				stmt.executeQuery(" insert into StaffMember values(' "+staffID+" ',' "+shift+" ',' "+salary+" ', ' "+breakTime+" ',' "+status+" ', ' "+staffType+" ' ) ");
				//step4 execute query 
	    		con.close();
	    	}
	    	catch(ClassNotFoundException e)
	    	{
	    		System.out.println("Driver not loaded");
	    	}
	    	catch(SQLException e)
	    	{
	    		System.out.println("Connection not established");
	    	}
			
		}
	
	public void ReservedSeats(String reservedfor, String date, String time, String reservationID, String tt) {
		
		try 
    	{

			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","tiger1234");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			stmt.executeQuery(" insert into ReservedSeats values(' "+reservedfor+" ',' "+date+" ',' "+time+" ', ' "+reservationID+" ','  "+tt+" ' ) ");
			//step4 execute query 
    		con.close();
    	}
    	catch(ClassNotFoundException e)
    	{
    		System.out.println("Driver not loaded");
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Connection not established");
    	}
		
	}
	
	public void writeinfile(String id) throws IOException {
		
		FileWriter fw=new FileWriter("StaffMembers.txt");
		fw.write(id+"\n");
		fw.close();
	}
	
	public Boolean login(String staffid) throws IOException {
		
		String line="";
		Boolean check=false;
		BufferedReader br=new BufferedReader(new FileReader("StaffMembers.txt"));
		while( (line = br.readLine() )!= null) {
			if(line.equals(staffid))
			{
				check=true;break;
			}
		}	
		return check;
	}

	@Override
	public void NewCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NewReceipt(Receipt r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NewStaff(StaffMember s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReservedSeats() {
		// TODO Auto-generated method stub
		
	}
}
