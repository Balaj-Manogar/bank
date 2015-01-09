package org.baali.facade;

public interface IAccount
{

	public AccountEnum create();
	public AccountEnum withdraw(int no, int money);
	public AccountEnum deposit(int no, int money);

}
