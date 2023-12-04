import java.util.Random;

public class CustomerAccount extends Customer{

	private int accountNumber;
	private double balance;
	Customer customer;
	
	public CustomerAccount()
	{
		this.accountNumber = 0;
		this.balance = 0;
		
	}
	
	public CustomerAccount(int accountNumber, double balance, String ppsNum, String fName, String lName, 
			String DOB, int password)
	{
		super(ppsNum, fName, lName, DOB, password);
		this.accountNumber = accountNumber;
		this.balance = balance;
		
		Random R = new Random();
		
		int x = R.nextInt(500) + R.nextInt(500) + R.nextInt(500) + R.nextInt(500) + R.nextInt(500) + R.nextInt(500)
				+ R.nextInt(500) + R.nextInt(500); 
		
		accountNumber = x;
				
		
	}
	
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public void setAccountNumber(int x)
	{
		this.accountNumber = x;
	}
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public String toString()
	{
		return "\n" + super.toString() + "Account Number: " + this.accountNumber + "Balance: "+ 
				this.balance;
	}
}
