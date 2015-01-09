package org.baali.facade;

public enum AccountEnum
{
	AccountCreated(1,"Account is Created"),
	AccountNotCreated(-1,"Account is Not Created"),
	MoneyNotAdded(3, "Cash is not added"),
	MoneyAdded(4, "Cash is added"),
	PinAdded(5,"Pin is added"),
	PinNotAdded(6, "Pin not added"),
	LogInSuccess(7, "Log in successful"),
	LogInFailure(8, "Log in failed"),
	WithdrawSuccess(9, "Withdrawn Successfully"),
	WithdrawFailure(10, "Withdraw Failed"),
	WithdrawProcess(11, " Withdrawal in process"),
	NotSufficientMoney(12, "Not Sufficient Money"),
	SufficientMoney(13, "Sufficient Money"),
	CashDepositProgress(14, "Cash deposit is in progress"),
	CashDepositSuccess(15, "Cash deposited successfully"),
	CashDepositFailure(16, "Cash deposit failed");
	
	
	private int id;
	private String msg;
	
	AccountEnum(int id, String msg){
		this.id = id;
		this.msg = msg;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	};
}
