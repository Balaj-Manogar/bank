package org.baali.facade;

public class ConsoleDisplay implements Display
{
	private String msg;
	

	public ConsoleDisplay()
	{
		
	}
	public ConsoleDisplay(String msg)
	{
		
		this.msg = msg;
	}


	@Override
	public void show()
	{
		System.out.println(this.msg);

	}

	@Override
	public String getMsg()
	{
		return msg;
	}

	@Override
	public void setMsg(String msg)
	{
		this.msg = msg;
	}


	

}
