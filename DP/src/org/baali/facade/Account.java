package org.baali.facade;

public class Account
{
	

	public static AccountEnum create(int no, int pin, int initialAmount,
			String type)
	{
		AccountEnum account = AccountFactory.create(no, pin, initialAmount, type);
		return account;
	}

}
