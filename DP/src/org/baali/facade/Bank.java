package org.baali.facade;

public class Bank
{
	private int id;
	private String name;
	private boolean logInStatus = false;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Bank(int i, String name)
	{
		this.id = i;
		this.name = name;
	}

	public AccountEnum createAccount(int no, int pin, int initialAmount,
			String type)
	{
		AccountEnum creationDetail = Account.create(no, pin, initialAmount,
				type);
		return creationDetail;
	}

	public AccountEnum logIn(int no, int pin)
	{
		AccountEnum status = AccountEnum.LogInFailure;
		DataBase db = DataBase.getInstance();
		ClientDetail data = db.getDetail(no);
		if (data.getNo() == no && data.getPin() == pin)
		{
			logInStatus = true;
			status = AccountEnum.LogInSuccess;
		}

		return status;

	}

	public boolean isLogInStatus()
	{
		return logInStatus;
	}

	public AccountEnum withdraw(int money, int no)
	{
		// TODO Auto-generated method stub
		AccountEnum status = AccountEnum.WithdrawFailure;
		Display display;
		if (logInStatus)
		{
			if(no < 2000)
			{
				IAccount account = new SavingsAccount();
				status = account.withdraw(no, money);
			}
			
			else
			{
				IAccount account = new CurrentAccount();
				status= account.withdraw(no, money);
			}
			//status = 
		}
		else
		{
			status = AccountEnum.LogInFailure;
			display = new ConsoleDisplay(status.getMsg());
			display.show();
		}
		return status;
	}

	public AccountEnum deposit(int amount, int no)
	{
		AccountEnum status = AccountEnum.WithdrawFailure;
		Display display;
		if(logInStatus)
		{
			if(no < 2000)
			{
				IAccount account = new SavingsAccount();
				status = account.deposit(no, amount);
			}
			
			else
			{
				IAccount account = new CurrentAccount();
				status= account.deposit(no, amount);
			}
		}
		else
		{
			status = AccountEnum.LogInFailure;
			display = new ConsoleDisplay(status.getMsg());
			display.show();
		}
		return null;
	}
	
	
}
