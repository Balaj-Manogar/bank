package org.baali.facade;

import java.lang.annotation.Retention;

public class AccountFactory
{
	public static AccountEnum create(int no, int pin, int initialAmount, String type)
	{
		AccountEnum creationDetail = AccountEnum.AccountNotCreated;
		if(type.equals(AccountType.savings.getType()))
		{
			 
			IAccount account = new SavingsAccount( no, pin, initialAmount);
			creationDetail = account.create();
			
		}else if(type.equals(AccountType.current.getType()))
		{
			IAccount account = new CurrentAccount( no, pin, initialAmount);
			creationDetail = account.create();
			//SecurityCode.add(pin);
			//CashVault.add(initialAmount);
		}
		return creationDetail;	}

	

}
