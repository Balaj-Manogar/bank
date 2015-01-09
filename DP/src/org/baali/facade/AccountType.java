package org.baali.facade;

public enum AccountType
{
	savings(1, "savings"),
	current(2, "current");
	
	int id;
	String type;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	private AccountType(int id, String type)
	{
		this.id = id;
		this.type = type;
	}

}
