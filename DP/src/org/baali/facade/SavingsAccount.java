package org.baali.facade;

import java.util.HashMap;
import java.util.HashSet;

public class SavingsAccount extends AbstractAccount
{
	private static int Id = 1000;
	private int no;
	private int pin;
	private int initialAmount;
	
	

	public SavingsAccount(int no, int pin, int initialAmount)
	{
		super(no,pin,initialAmount);		
	}
	
	public SavingsAccount()
	{
		
	}

	@Override
	public AccountEnum create()
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

	public static void setId()
	{
		Id++;
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
