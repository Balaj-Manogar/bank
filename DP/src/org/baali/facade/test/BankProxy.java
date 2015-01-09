package org.baali.facade.test;

import org.baali.facade.AccountEnum;
import org.baali.facade.Bank;
import org.baali.facade.ConsoleDisplay;
import org.baali.facade.Display;

public class BankProxy
{
	private Bank bank;
	private int id;
	public BankProxy(Bank bank)
	{
		this.bank = bank;
	}

	public AccountEnum login(int no, int pin)
	{
		AccountEnum logStatus = AccountEnum.LogInFailure;
		this.id = no;
		try
		{
			logStatus = this.bank.logIn(no, pin);
			Display msg = new ConsoleDisplay(logStatus.getMsg());
			msg.show();
		}
		catch(Exception e)
		{
			logStatus = AccountEnum.LogInFailure;
			Display msg = new ConsoleDisplay(logStatus.getMsg());
			msg.show();
		}
		
		return logStatus;
	}

	public AccountEnum withdrawCash(int money)
	{
		AccountEnum withdrawStatus = AccountEnum.WithdrawProcess;
		Display msg = new ConsoleDisplay(withdrawStatus.getMsg());
		msg.show();
		withdrawStatus = bank.withdraw(money, id);
		//msg.setMsg(withdrawStatus.getMsg());
		//msg.show();
		
		return withdrawStatus;		
	}

	public AccountEnum depositCash(int amount)
	{
		AccountEnum depositStatus = AccountEnum.CashDepositProgress;
		Display msg = new ConsoleDisplay(depositStatus.getMsg());
		msg.show();
		depositStatus = bank.deposit(amount, id);
		return depositStatus;
	}

}
