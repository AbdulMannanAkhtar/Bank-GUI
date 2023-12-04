import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.EventListener.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;


public class BankGUI implements ActionListener, ItemListener{

	Customer customer;
	CustomerAccount customerAc;
	ArrayList<Customer>list;
	CardLayout cl = new CardLayout();
	JPanel cards, welcomePanel, imgPanel, newCustomerPnl, card1, menu1, card2, card3, card4, card5, welcomeImg, 
	addCustomer, details, bottomPnl, sidePnl, TPnl, Tmsg;
	JButton Customer, newCustomer, Exit, CreateAccount, Return, Submit, back, back2, menu, home, Enter, home2;
	JLabel welcome, imageLabel, adminPassword, msg, imageLabel2, addDetails, PPSNumber, firstN, lastN, 
	birthDate, transactionDetails, Amount, Date, TType;
	Container c, c2, c3, c4;
	ImageIcon image, welcomeImage;
	JMenu Account, Transactions, Details;
	JMenuItem AddAccount, ModifyAccount, DeleteAccount, Withdraw, Lodge, AccountDetails, Statements;
	JTextField ppsNo, firstName, lastName, amount, transactionType;
	JFormattedTextField dob, date;
	JTextArea newAccDetails, showDetails, Balance;
	JFrame frame = new JFrame("Bank GUI");
	
	String AdminPassword  = "11223344";
	Random R = new Random();
	int customerAcNum = R.nextInt(9999999);
	double balance = 100;
	
	public BankGUI()
	{
	
		//JFrame frame = new JFrame("Bank GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		imgPanel = new JPanel();
		welcomePanel = new JPanel(new GridLayout(5,1));
		welcomePanel.setBackground(new Color(0, 206, 209));
		imgPanel.setBackground(new Color(255, 255, 255));		
		
		
		card1 = new JPanel(new BorderLayout());
		card2 = new JPanel(new BorderLayout());
		card3 = new JPanel(new BorderLayout());
		card4 = new JPanel(new BorderLayout());
		card5 = new JPanel(new BorderLayout());
		
		Customer = new JButton("Customer         ");
		newCustomer = new JButton("New Customer");
		Exit = new JButton("Exit                   ");
		welcome = new JLabel("WELCOME TO MY BANK");
		adminPassword = new JLabel("11223344");
		welcome.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		image = new ImageIcon("C:\\Users\\abdul\\OneDrive\\Desktop\\Abdul\\college\\Year 2\\Semester 1\\OOSD2\\CA3\\src\\bankIcon.png");
		imageLabel = new JLabel(image);
		
		welcome.setForeground(new Color(0, 0, 0));
		welcome.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		Customer.setForeground(Color.white);
		Customer.setBackground(Color.black);
		Customer.setPreferredSize(new Dimension(100, 40));
		
		newCustomer.setForeground(Color.white);
		newCustomer.setBackground(Color.black);
		newCustomer.setPreferredSize(new Dimension(100, 40));

		Exit.setForeground(Color.white);
		Exit.setBackground(Color.black);
		Exit.setPreferredSize(new Dimension(100, 40));
		
		
		Customer.addActionListener(this);
		newCustomer.addActionListener(this);
		Exit.addActionListener(this);

		
		c = Box.createVerticalBox();
		c.add(Box.createHorizontalStrut(100));
		c.add(Box.createVerticalGlue());c.add(Customer);
		c.add(Box.createRigidArea(new Dimension(0, 10)));
		c.add(Box.createVerticalGlue());c.add(newCustomer);
		c.add(Box.createRigidArea(new Dimension(0, 10)));
		c.add(Box.createVerticalGlue());c.add(Exit);
		
				
		
		welcomePanel.add(welcome);
		welcomePanel.add(c);
		
		imgPanel.add(imageLabel);

		
		AddAccount = new JMenuItem("Add account");
		ModifyAccount = new JMenuItem("Modify accunt");
		DeleteAccount = new JMenuItem("Delete account");
		Withdraw = new JMenuItem("Withdraw funds");
		Lodge = new JMenuItem("Lodge funds");
		AccountDetails = new JMenuItem("Account details");
		Statements = new JMenuItem("Statements");

		
		Account = new JMenu("Accounts");
		Account.setMnemonic(KeyEvent.VK_A);
		
		Account.add(AddAccount);
		Account.add(ModifyAccount);
		Account.add(DeleteAccount);
		
		Transactions = new JMenu("Transactions");
		Transactions.setMnemonic(KeyEvent.VK_T);
		
		Transactions.add(Withdraw);
		Transactions.add(Lodge);
		
		Details = new JMenu("Details");
		Details.setMnemonic(KeyEvent.VK_D);
		
		Details.add(AccountDetails);
		Details.add(Statements);
		
		AddAccount.addActionListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(Account);
		menuBar.add(Transactions);
		menuBar.add(Details);
		
		menuBar.setBackground(new Color(0, 206, 209));
		
		
		bottomPnl = new JPanel();
		back2 = new JButton("Home");
		back2.setForeground(Color.white);
		back2.setBackground(Color.black);
		back2.setPreferredSize(new Dimension(100, 40));
		menu1 = new JPanel(new BorderLayout());
		menu1.setBorder(BorderFactory.createEmptyBorder());
		//menu1.setBackground((new Color(0, 206, 209)));
		
		showDetails = new JTextArea();
		showDetails.setSize(20,10);
		showDetails.setEditable(false);
		
		menu1.add(menuBar, BorderLayout.NORTH);
		menu1.add(showDetails, BorderLayout.CENTER);
		bottomPnl.add(back2, BorderLayout.SOUTH);
		
		newCustomerPnl = new JPanel(new GridLayout(3,1));
		newCustomerPnl.setBackground(new Color(0, 206, 209));
		msg = new JLabel("  WELCOME TO MY BANK NEW CUSTOMER  ");
		msg.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CreateAccount = new JButton("Create Account");
		Return = new JButton("Return               ");
		welcomeImg = new JPanel();
		welcomeImg.setBackground(new Color(255, 255, 255));
		
		welcomeImage = new ImageIcon("C:\\Users\\abdul\\OneDrive\\Desktop\\Abdul\\college\\Year 2\\Semester 1\\OOSD2\\CA3\\src\\welcome.png");
		imageLabel2 = new JLabel(welcomeImage);
		
		welcomeImg.add(imageLabel2);
		
		CreateAccount.setForeground(Color.white);
		CreateAccount.setBackground(Color.black);
		CreateAccount.setPreferredSize(new Dimension(100, 40));
		
		Return.setForeground(Color.white);
		Return.setBackground(Color.black);
		Return.setPreferredSize(new Dimension(100,40));
		
		c2 = Box.createVerticalBox();
		c2.add(Box.createHorizontalStrut(100));
		c2.add(Box.createVerticalGlue());c2.add(CreateAccount);
		c2.add(Box.createRigidArea(new Dimension(0, 10)));
		c2.add(Box.createVerticalGlue());c2.add(Return);
		c2.add(Box.createRigidArea(new Dimension(0,10)));
		
		newCustomerPnl.add(msg);
		newCustomerPnl.add(c2);
		
		details = new JPanel();
		details.setBackground(new Color(0, 206, 209));
		addCustomer = new JPanel();
		//addCustomer.setBorder(BorderFactory.createEmptyBorder());
		addCustomer.setBackground(new Color(0, 206, 209));
		addDetails = new JLabel("PLEASE ENTER YOUR DETAILS HERE");
		addDetails.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ppsNo = new JTextField(40);
		ppsNo.setForeground(Color.black);
		firstName = new JTextField(40);
		firstName.setForeground(Color.black);
		lastName = new JTextField(40);
		lastName.setForeground(Color.black);
		dob = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		dob.setForeground(Color.black);
		
		PPSNumber = new JLabel("PPS Number");
		PPSNumber.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		firstN = new JLabel("First name");
		firstN.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		lastN = new JLabel("Last name");
		lastN.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		birthDate = new JLabel("Date of Brith");
		birthDate.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		
		newAccDetails = new JTextArea();
		newAccDetails.setSize(12, 60);
		
		
		Submit = new JButton("Submit            ");
		Submit.setForeground(Color.white);
		Submit.setBackground(Color.black);
		Submit.setPreferredSize(new Dimension(100, 40));
		
		back = new JButton("Return to menu");
		back.setForeground(Color.white);
		back.setBackground(Color.black);
		back.setPreferredSize(new Dimension(100, 40));
		
		c3 = Box.createVerticalBox();
		c3.add(Box.createHorizontalStrut(100));
		c3.add(Box.createVerticalGlue());c3.add(PPSNumber);
		c3.add(Box.createVerticalGlue());c3.add(ppsNo);
		c3.add(Box.createRigidArea(new Dimension(0, 5)));
		c3.add(Box.createVerticalGlue());c3.add(firstN);
		c3.add(Box.createVerticalGlue());c3.add(firstName);
		c3.add(Box.createRigidArea(new Dimension(0,5)));
		c3.add(Box.createVerticalGlue());c3.add(lastN);
		c3.add(Box.createVerticalGlue());c3.add(lastName);
		c3.add(Box.createRigidArea(new Dimension(0, 5)));
		c3.add(Box.createVerticalGlue());c3.add(birthDate);
		c3.add(Box.createVerticalGlue());c3.add(dob);
		c3.add(Box.createRigidArea(new Dimension(0, 5)));
		c3.add(Box.createVerticalGlue());c3.add(Submit);
		c3.add(Box.createRigidArea(new Dimension(0, 10)));
		c3.add(Box.createVerticalGlue());c3.add(newAccDetails);
		c3.add(Box.createRigidArea(new Dimension(0,10)));
		c3.add(Box.createVerticalGlue());c3.add(back);
		
		c3.setVisible(true);
		
		details.add(addDetails);
		addCustomer.add(c3);
		
		Tmsg = new JPanel();
		Tmsg.setBackground(new Color(0, 206, 209));
		TPnl = new JPanel();
		TPnl.setBackground(new Color(0, 206, 209));
		sidePnl = new JPanel();
		sidePnl.setBorder(BorderFactory.createEmptyBorder());
		sidePnl.setBackground(new Color(0, 206, 209));
		
		menu = new JButton("Return to menu");
		menu.setForeground(Color.white);
		menu.setBackground(Color.black);
		menu.setPreferredSize(new Dimension(100, 40));
		
		home = new JButton("Home");
		home.setForeground(Color.white);
		home.setBackground(Color.black);
		home.setPreferredSize(new Dimension(100, 40));
		
		Enter = new JButton("Enter");
		Enter.setForeground(Color.white);
		Enter.setBackground(Color.black);
		Enter.setPreferredSize(new Dimension(100, 40));
		
		transactionDetails = new JLabel("MANAGE YOUR TRANSACTIONS HERE");
		transactionDetails.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Amount = new JLabel("Amount you want to withdraw/lodge");
		Amount.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		TType = new JLabel("Transaction Type");
		TType.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		Date = new JLabel("Transaction date");
		Date.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		
		transactionType = new JTextField(40);
		amount = new JTextField(40);
		date = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		
		Balance = new JTextArea();
		Balance.setSize(12, 50);
		

		home2 = new JButton("");
		home2.setForeground(Color.white);
		home2.setBackground(Color.black);
		home2.setPreferredSize(new Dimension(100, 40));
		
		c4 = Box.createVerticalBox();
		c4.add(Box.createHorizontalStrut(100));
		c4.add(Box.createVerticalGlue());c4.add(Amount);
		c4.add(Box.createVerticalGlue());c4.add(amount);
		c4.add(Box.createRigidArea(new Dimension(0, 5)));
		c4.add(Box.createVerticalGlue());c4.add(TType);
		c4.add(Box.createVerticalGlue());c4.add(transactionType);
		c4.add(Box.createRigidArea(new Dimension(0,5)));
		c4.add(Box.createVerticalGlue());c4.add(Date);
		c4.add(Box.createVerticalGlue());c4.add(date);
		c4.add(Box.createRigidArea(new Dimension(0,5)));
		c4.add(Box.createVerticalGlue());c4.add(Enter);
		c4.add(Box.createRigidArea(new Dimension(0,5)));
		c4.add(Box.createVerticalGlue());c4.add(Balance);
		c4.add(Box.createRigidArea(new Dimension(0,5)));
		c4.add(Box.createVerticalGlue());c4.add(Balance);
		
		Tmsg.add(transactionDetails);
		TPnl.add(c4);
		sidePnl.add(menu);
		sidePnl.add(home);
		
		cards = new JPanel();
		
		cards.setLayout(cl);
		card1.add(welcomePanel, BorderLayout.WEST);
		card1.add(imgPanel, BorderLayout.CENTER);
		card1.add(adminPassword, BorderLayout.SOUTH);
		card1.setBorder(BorderFactory.createEmptyBorder());
		cards.add(card1, "welcome");
		card2.add(bottomPnl, BorderLayout.SOUTH);
		card2.add(menu1, BorderLayout.CENTER);
		card2.setBorder(BorderFactory.createEmptyBorder());
		cards.add(card2, "menu");
		card3.add(newCustomerPnl, BorderLayout.WEST);
		card3.add(welcomeImg, BorderLayout.CENTER);
		card3.setBorder(BorderFactory.createEmptyBorder());
		cards.add(card3, "new customer");
		card4.add(addCustomer, BorderLayout.CENTER);
		card4.add(details, BorderLayout.NORTH);
		card4.setBorder(BorderFactory.createEmptyBorder());
		cards.add(card4, "addCustomer");
		card5.add(Tmsg, BorderLayout.NORTH);
		card5.add(TPnl, BorderLayout.CENTER);
		card5.add(sidePnl, BorderLayout.SOUTH);
		cards.add(card5, "transactions");
		
		cl.show(cards, "welcome");

		
		newCustomer.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(cards, "new customer");
			}
			
		});
		
		Customer.addActionListener(new ActionListener()
		{
			ArrayList<Customer>list = new ArrayList<Customer>();

			public void actionPerformed(ActionEvent e) 
			{
				//String accountNumber;
				int AccNum;
				int result;
				JPasswordField accNo = new JPasswordField();
				String EnterAccNo = "Please enter your account number or admin password";
				result = JOptionPane.showOptionDialog(card2, new Object[] {accNo, EnterAccNo}, 
				"Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				AccNum = customerAcNum;
				String a = String.valueOf(customerAcNum);
				
				if(list == null)
				{
					JOptionPane.showMessageDialog(frame, "No customers exist");
				}
				else if(EnterAccNo.equals(a)|| EnterAccNo == AdminPassword)
				{
					JOptionPane.showMessageDialog(frame, "Acount number not recgonised");
				}
				else
				{
					cl.show(cards, "menu");

				}
				
			}
			
			
			
		});
		
		Exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(frame.EXIT_ON_CLOSE);
				
			}
			
		});
		
		CreateAccount.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(cards, "addCustomer");
			}
			
		});
		
		Return.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				cl.first(cards);
			}
			
		});
		
		Submit.addActionListener(new ActionListener()
		{
			ArrayList<Customer>list = new ArrayList<Customer>();

			public void actionPerformed(ActionEvent e) 
			{
				String ppsNumber;
				String FName;
				String LName;
				String dateOfBirth;
				int ID;
				
				String all = "";
			 	
				ppsNumber = ppsNo.getText(); 
				FName = firstName.getText();
				LName = lastName.getText();
				dateOfBirth = dob.getText();
				
				
										
				ID = ppsNo.getText().charAt(0) + ppsNo.getText().charAt(1) + ppsNo.getText().charAt(2) + 
				dob.getText().charAt(4) + dob.getText().charAt(5) + dob.getText().charAt(6) + 
				dob.getText().charAt(7);
				
				CustomerAccount customers = new CustomerAccount(customerAcNum, balance, ppsNumber, FName, LName, dateOfBirth, ID);

				list.add(customers);
				
								
				for(Customer C: list)
				{
					all = all + C.toString() + "\n";
							
				}
				
				newAccDetails.setText(all + "Your Unique ID is: " + ID + " This is used to access certain features");
				
				DeleteAccount.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						for(Customer C: list)
						{
							if(balance > 0)
							{
								JOptionPane.showMessageDialog(frame, "There are still funds in this account therefore "
										+ "it cannot be deleted");
							}
							else
							{
								list.remove(C);
							}
						}
						
					}
					
				});
				
				AccountDetails.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						int result;
						String i = String.valueOf(ID);
						JPasswordField id = new JPasswordField();
						String EnterId = "Please enter your unique ID or admin passsword";
						result = JOptionPane.showOptionDialog(card3, new Object[] {id, EnterId}, 
						"Account Info", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
						
						
						for(Customer C: list)
						{
							if(EnterId == i || EnterId == AdminPassword)
							{
								showDetails.setText("Your details are: " + ppsNumber + "\n" + FName + "\n" + 
										LName + "\n" + dateOfBirth + "\n" + balance + "\n" + customerAcNum);
							}
						}
					}
					
				});
				
				Enter.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						Transactions T = null;
						String Tamount;
						String TransactionType;
						String Tdate;
						int result;
						String i = String.valueOf(ID);
						JPasswordField id = new JPasswordField();
						String EnterId = "Please enter your unique ID or admin password";
						result = JOptionPane.showOptionDialog(card5, new Object[] {id, EnterId}, 
						"Transaction", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
						
						
						for(Customer C: list)
						{
							if(EnterId == i|| EnterId == AdminPassword)
							{
								Tamount = amount.getText();
								Integer x = Integer.valueOf(Tamount);
								TransactionType = transactionType.getText();
								Tdate = date.getText();
								
								T = new Transactions(Tamount, TransactionType, balance, Tdate, C, EnterId, EnterId, EnterId,ID);
								
								list.add(T);
								
								if(transactionType.getText().equalsIgnoreCase("Withdrawl")|| transactionType.getText().equalsIgnoreCase("Intrest")
										|| transactionType.getText().equalsIgnoreCase("bank charge"))
								{
									balance = balance - x - 15;
								}
								else if(transactionType.getText().equalsIgnoreCase("Lodgement"))
								{
									balance = balance + x - 15;
								}
								Balance.setText(Tdate + ":" + TransactionType +  ":" + Tamount + "\n" 
										+ "Blance: " + balance);
								
							}
							
							
						}
					
					}
				});
				Statements.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						Transactions T = null;
						String Tamount;
						String TransactionType;
						String Tdate;
						
						Tamount = amount.getText();
						Integer x = Integer.valueOf(Tamount);
						TransactionType = transactionType.getText();
						Tdate = date.getText();
						int result;
						String i = String.valueOf(ID);
						
						
						
						JPasswordField id = new JPasswordField();
						String EnterId = "Please enter your unique ID or admin password";
						result = JOptionPane.showOptionDialog(card5, new Object[] {id, EnterId}, 
						"Statements", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
						
						for(Customer C: list)
						{
							if(EnterId == i || EnterId == AdminPassword)
							{
								showDetails.setText(Tdate + list.toString() + "\n" + "Balance: " + balance);
							}
						}
						
					}
			
				});
			
			}
		});
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.first(cards);
			}
			
		});
		
		AddAccount.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(cards, "addCustomer");
				
			}
			
		});
		
		Withdraw.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) 
			{
				cl.show(cards, "transactions");
			}
			
		});
		
		Lodge.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) 
			{
				cl.show(cards, "transactions");
			}
			
		});

		home.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(cards, "welcome");
			}
			
		});
		
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(cards, "menu");
			}
			
		});
		
		back2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.first(cards);
			}
			
		});
		
		
		
		frame.add(cards);
		//frame.add(welcomePanel, BorderLayout.WEST);
		//frame.add(imgPanel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main (String [] args)
	{
		
		BankGUI bank =new BankGUI();
		

	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
