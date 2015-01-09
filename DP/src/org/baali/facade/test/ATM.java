package org.baali.facade.test;

import org.baali.facade.Bank;

public class ATM
{
	private static Bank bank = new Bank(1, "XYZ");
	public static Bank getBank()
	{
		return bank;
	}
	
	

	public static void main(String[] args)
	{
		
		getBank().createAccount(1234, 567, 4000, "savings");
		BankProxy client = new BankProxy(getBank());
		client.login(1234, 567);
		client.withdrawCash(500);
		client.withdrawCash(500);
		client.depositCash(2000);

	}

}
