import java.util.Scanner;

public class Administrator extends Customer{
	
	private String adminPassword;
	
	public Administrator()
	{
		this.adminPassword = "";
	}
	
	public Administrator(String adminPassword, String ppsNum, String fName, String lName, String DOB,Customer list,
			int password)
	{
		super(ppsNum, fName, lName, DOB, password);
		this.adminPassword = adminPassword;
		
		Scanner scan = new Scanner(System.in);
		
		while(adminPassword.length() > 7)
		{
			System.out.println("The Password must have 7 characters ");
			System.out.println("Enter the password again: ");
			
			adminPassword = scan.nextLine();
		}
		
	}
	
	public String getAdminPassword()
	{
		return this.adminPassword;
	}
	
	public void setAdminPassword(String adminPassword)
	{
		this.adminPassword = adminPassword;
	}

	
	public String toString()
	{
		return "\n" + "Admin password: " + this.adminPassword;
	}

}
