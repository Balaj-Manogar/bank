package org.baali.facade;

public class SecurityCode
{

	int id;
	int pin;
	int no;
	
	public SecurityCode(int id, int no, int pin)
	{
		this.id = id;
		this.pin = pin;
		this.no = no;
	}

	public AccountEnum add()
	{
		AccountEnum pinStatus = AccountEnum.PinNotAdded;
		try
		{
			DataBase db = DataBase.getInstance();
			ClientDetail data = db.getDetail(no);
			data.setPin(pin);
			db.update(data);
			pinStatus = AccountEnum.PinAdded;
			Display msg = new ConsoleDisplay(pinStatus.getMsg());
			msg.show();
		}
		catch (Exception e)
		{
			pinStatus = AccountEnum.PinNotAdded;
			Display msg = new ConsoleDisplay(pinStatus.getMsg());
			msg.show();
		}
		return pinStatus;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getPin()
	{
		return pin;
	}

	public void setPin(int pin)
	{
		this.pin = pin;
	}

}
