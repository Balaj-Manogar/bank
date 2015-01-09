package org.baali.facade;

public class CashVault
{
	int id;
	int amount;
	int no;

	public CashVault(int id, int no, int amount)
	{
		this.id = id;
		this.no = no;
		this.amount = amount;
	}

	public AccountEnum add()
	{
		AccountEnum cashStatus = AccountEnum.MoneyNotAdded;
		try
		{
			DataBase db = DataBase.getInstance();
			ClientDetail data = db.getDetail(no);
			data.setAmount(amount);
			db.update(data);
			cashStatus = AccountEnum.MoneyAdded;
			Display msg = new ConsoleDisplay(cashStatus.getMsg());
			msg.show();
		}
		catch (Exception e)
		{
			cashStatus = AccountEnum.MoneyNotAdded;
			Display msg = new ConsoleDisplay(cashStatus.getMsg());
			msg.show();
		}
		
		return cashStatus;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}
}
