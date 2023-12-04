import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Customer implements Serializable{
	
	ArrayList<Customer>list;
	private String ppsNum;
	private String fName;
	private String lName;
	private String DOB;
	private int password = 0;
	CustomerAccount ca;
	
	public Customer()
	{
		list = new ArrayList<Customer>();
		this.ppsNum = "";
		this.fName = "";
		this.lName = "";
		this.DOB = "";
		this.password = 0;
	}
	
	public Customer(String ppsNum, String fName, String lName, String DOB, int password)
	{
		this.ppsNum = ppsNum;
		this.fName = fName;
		this.lName = lName;
		this.DOB = DOB;
		this.password = password;
		
		while(DOB.length() < 7)
		{
			Scanner scan = new Scanner(System.in);
			
			System.out.println("A date of brith must have 8 digits ");
			
			System.out.println("please re-enter your date of birth: ");
			DOB = scan.nextLine();
			
			System.out.println(this.DOB);
		}
		
		while(ppsNum.length() < 7)
		{
			Scanner scan = new Scanner(System.in);
			
			System.out.println("A PPS Number must have 8 Charaters ");
			
			System.out.println("Pleaase re-enter your PPS Number");
			ppsNum = scan.nextLine();
			
			System.out.println(this.ppsNum);
		}
		
	}
	
	public String getPpsNum()
	{
		return this.ppsNum;
	}
	
	public String getFName()
	{
		return this.fName;
	}
	
	public String getLName()
	{
		return this.lName;
	}
	
	public String getDOB()
	{
		return this.DOB;
	}


	public void setPpsNum(String ppsNum)
	{
		ppsNum = this.ppsNum;
	}
	
	public void setFName(String fName)
	{
		fName = this.fName;
	}
	
	public void setLName(String lName)
	{
		lName = this.lName;
	}
	
	public void setDOB(String DOB)
	{
		DOB = this.DOB;
	}
	
	public String toString()
	{
		return "\n" + "PPS Number: " + this.ppsNum + "\n" + "First name: " + this.fName + "\n" +
				"Last name: " + this.lName + "Date of Birth: " + this.DOB; 
	
	}

	 

} 
