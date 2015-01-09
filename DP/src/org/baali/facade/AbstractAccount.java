package org.baali.facade;

public abstract class AbstractAccount implements IAccount
{
	private int no;
	private int pin;
	private int amount;

	public AbstractAccount(int no, int pin, int amount)
	{
		this.no = no;
		this.pin = pin;
		this.amount = amount;
	}

	public AbstractAccount()
	{

	}

	public void processAccount(int id)
	{
		ClientDetail clientDetail = new ClientDetail(id, this.no, 0, 0);
		DataBase data = DataBase.getInstance();

		data.add(clientDetail);
		SecurityCode code = new SecurityCode(id, this.no, this.pin);
		code.add();
		CashVault vault = new CashVault(id, this.no, this.amount);
		vault.add();
	}

	@Override
	public AccountEnum withdraw(int no, int money)
	{
		Display display;
		AccountEnum withdrawStaus = verify(no, money);
		AccountEnum status = AccountEnum.WithdrawFailure;
		if (withdrawStaus == AccountEnum.SufficientMoney)
		{
			String msg = "Rs " + money + " " + AccountEnum.WithdrawSuccess.getMsg()
					+ " and balance amount is Rs. " + this.amount;
			display = new ConsoleDisplay(msg);
			display.show();
			status = AccountEnum.WithdrawSuccess;
		} else
		{
			String msg = "Rs " + money + " " + AccountEnum.NotSufficientMoney.getMsg();
			display = new ConsoleDisplay(msg);
			display.show();
			status = AccountEnum.WithdrawFailure;
		}
		return status;
	}

	@Override
	public AccountEnum deposit(int no, int money)
	{
		Display display;
		AccountEnum depositStatus = AccountEnum.CashDepositFailure;

		try
		{
			DataBase db = DataBase.getInstance();
			ClientDetail data = db.getDetail(no);
			this.amount = data.getAmount() + money;
			data.setAmount(this.amount);
			db.update(data);
			String msg = "RS. " + money + " " + AccountEnum.CashDepositSuccess.getMsg() + " Total Amount:  " + this.amount;
			display = new ConsoleDisplay(msg);
			display.show();
			depositStatus = AccountEnum.CashDepositSuccess;
		} catch (Exception e)
		{
			String msg = "RS. " + money + " " + AccountEnum.CashDepositFailure.getMsg() + " Total Amount:  " + this.amount;
			depositStatus = AccountEnum.CashDepositFailure;
		}
		return depositStatus;
	}

	public AccountEnum verify(int no, int amount)
	{
		AccountEnum status = AccountEnum.NotSufficientMoney;
		DataBase db = DataBase.getInstance();
		ClientDetail data = db.getDetail(no);
		if (data.getAmount() >= amount)
		{
			this.amount = data.getAmount() - amount;
			data.setAmount(this.amount);
			status = AccountEnum.SufficientMoney;
		}

		return status;
	}

}
