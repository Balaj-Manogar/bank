package org.baali.facade;

public class CurrentAccount extends AbstractAccount
{
	private static int Id = 2000;
	private int no;
	private int pin;
	private int initialAmount;
	
	
	public CurrentAccount(int no, int pin, int initialAmount)
	{
		super(no,pin,initialAmount);		
	}
	
	public CurrentAccount()
	{
		// TODO Auto-generated constructor stub
	}
	
	public  AccountEnum create()
	{
		AccountEnum creationDetail = AccountEnum.AccountNotCreated;
		try
		{
			processAccount(getId());
			creationDetail = AccountEnum.AccountCreated;
			Display display = new ConsoleDisplay(creationDetail.getMsg());
			display.show();
		}
		catch (Exception e)
		{
			creationDetail = AccountEnum.AccountNotCreated;
			Display display = new ConsoleDisplay(creationDetail.getMsg());
		}

		return creationDetail;
	}

	public static int getId()
	{
		return Id;
	}

	public int getNo()
	{
		return no;
	}

	public void setNo(int no)
	{
		this.no = no;
	}

	public int getInitialAmount()
	{
		return initialAmount;
	}

	public void setInitialAmount(int initialAmount)
	{
		this.initialAmount = initialAmount;
	}

}
