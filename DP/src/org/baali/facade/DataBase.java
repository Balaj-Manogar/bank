package org.baali.facade;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.TableStringConverter;

public class DataBase
{
	private static DataBase instance = null;
	private ArrayList<HashMap<Integer, ClientDetail>> table = new ArrayList<>();

	private DataBase()
	{
	}

	public static DataBase getInstance()
	{
		if (instance == null)
		{
			instance = new DataBase();
		}
		return instance;
	}

	public void add( ClientDetail client)
	{
		HashMap<Integer, ClientDetail> detail;

		try
		{
			detail = new HashMap<Integer, ClientDetail>();
			detail.put(client.getNo(), client);
			table.add(detail);
			Display msg = new ConsoleDisplay("Client Data Added");
			msg.show();
		}
		catch (Exception e)
		{
			Display msg = new ConsoleDisplay("Error adding client Data!!!!");
		}
	}

	public ClientDetail getDetail(int no)
	{
		ClientDetail detail = null;
				
		for(HashMap<Integer, ClientDetail> data : table)
		{
			if(data.containsKey(no))
			{
				detail = data.get(no);
			}
		}
		return detail;
	}
	
	public boolean update(ClientDetail detail)
	{
		
		for(HashMap<Integer, ClientDetail> data : table)
		{
			if(data.containsKey(detail.getNo()))
			{
				detail = data.remove(detail.getNo());
				data.put(detail.getNo(), detail);
				return true;
			}
		}
		return false;
	}
}
