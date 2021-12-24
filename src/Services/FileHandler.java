package Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import CustomExceptions.InvalidCredentialsException;
import application.Model.Customer;
import application.Model.Receipt;
import application.Model.StaffMember;

public class FileHandler implements Storage {
	
	private File myFileObj;
	
	public FileHandler(){
		myFileObj= new File("newFile.txt");
	}
	
	public FileHandler(String filename) {
		myFileObj=new File(filename);
	}
	
	
	public File getMyFileObj() {
		return myFileObj;
	}

	public void setMyFileObj(File myFileObj) {
		this.myFileObj = myFileObj;
	}

	public void writeinfile(String u, String p) throws IOException {
		
		FileWriter fw=new FileWriter("StaffMembers.txt");
		fw.write(u+" "+p + "\n");
		fw.close();
	}
	
	public boolean login(String username, String passwd) throws IOException {
		
		boolean isGranted = false;
		try {
            Scanner in = new Scanner(myFileObj);
            while (in.hasNextLine())
            {
	              String s = in.nextLine();  
	              String[] sArray = s.split(" ");
	              
	              System.out.println(sArray[0]); //Just to verify that file is being read
	              System.out.println(sArray[1]);
	
	              
	              if (username.equals(sArray[0]) && passwd.equals(sArray[1]))
	              {
	                System.out.println("User successfully authenticated!");
	                return true;
	              }
            }
            in.close();
        } catch (FileNotFoundException e) {
           e.printStackTrace();
           throw new InvalidCredentialsException("User does not exist!");
        }
		return false;
		
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
