import java.util.ArrayList;
import java.util.Scanner;

public class Transactions extends Customer{
	
	private String date;
	private String transactionType;
	private double amount;
	Customer customer;
	
	public Transactions()
	{
		this.date = "";
		this.transactionType = "";
		this.amount = 0;
	}
	
	public Transactions(String date, String transactionType, double amount, String ppsNum, Customer customer,
			String fName, String lName, String DOB, int password)
	{ 
		super(ppsNum, fName, lName, DOB, password);
		this.date = date;
		this.transactionType = transactionType;
		this.amount = amount;
		
		Scanner scan = new Scanner(System.in);
		
		while(!transactionType.equalsIgnoreCase("Lodgement") || !transactionType.equalsIgnoreCase("Withdrawl") || 
				!transactionType.equalsIgnoreCase("Intrest") || !transactionType.equalsIgnoreCase("Bank charges"))
		{
			System.out.println("This bank cannot support the transaction type you have entered ");
			System.out.println("Lodegments, withdrawls, intrest or bank charges are the types of transactions "
					+ "this bank can support");
			
			System.out.println("Re-enter the type of transaction you want to undertake: ");
			transactionType = scan.nextLine();
			
			
		}
			
		
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public String getTransactionType()
	{
		return this.transactionType;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setTransactionType(String transactionType)
	{
		this.transactionType = transactionType;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	public String toString()
	{
		return "\n" + super.toString() + "date: " + this.date + "Transaction Type: " + this.transactionType
				+ "Amount: " + this.amount;
	}
}
