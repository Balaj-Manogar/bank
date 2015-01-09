package org.baali.facade;

public class ClientDetail
{
	private int id;
	private int no;
	private int pin;
	private int amount;
	public ClientDetail(int id, int no, int pin, int amount)
	{
		this.id = id;
		this.no = no;
		this.pin = pin;
		this.amount = amount;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getNo()
	{
		return no;
	}
	public void setNo(int no)
	{
		this.no = no;
	}
	public int getPin()
	{
		return pin;
	}
	public void setPin(int pin)
	{
		this.pin = pin;
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
