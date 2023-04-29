package scheduler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Calendar {
	
	public HashMap <String,Day> calendar;
	private ArrayList <String> keys;
	//think we will have to have an array of all the inputed keys to be able to display them in order
	// keys should be fromatted ""DDMM24HR"" so april 12 3:36PM= ""04121536"
	public Calendar()
	{
		calendar= new HashMap<String,Day>();
		keys= new ArrayList<String>();
	}
	
	public void display()
	{
		Object [] arr=keys.toArray();
		Arrays.sort(arr);
		calendar.forEach((key,value) -> System.out.println("Day: " + key + "\n" + value.display()));
	
	}
	
	public boolean addEvent(String name, String start, String end)
	{
		String key= name.replace(" ","")
		if(validateTime(key,endTime)==false)
		{
			return false;
		}
		keys.add(key);
		int month=Integer.parseInt(key.substring(0,2)); //grabs the first 2 digits of the string and returns it as an int
		int day=Integer.parseInt(key.substring(2,4));
		int hour=Integer.parseInt(key.substring(4,6));
		int minute=Integer.parseInt(key.substring(6,8));
		//need to validate the time within the day class and validate the day. 
		return true;
		
	}
	
	/*
	this endtime  string would be enough to make sure there is nothing that this event overlaps. it should create a string in the key format for endtime and then check all
    the keys between those times and if there are no keys inbetween those times it returns true
	needs to be the ability to check for the end time of previous events so that it isnt in the middle of something before it.
	going to need to check the entry before it so that the previous endtime is not after the start time AND before the end time.
	*/
	
	private boolean validateTime(String key,String endTime)
	{
		if(calendar.containsKey(key))
		{
			return false;
		}
		String [] arr= (String[]) keys.toArray();
		Arrays.sort(arr);
		
		
		int month=Integer.parseInt(key.substring(0,2)); 
		int day=Integer.parseInt(key.substring(2,4));
		int hour=Integer.parseInt(key.substring(4,6));
		int minute=Integer.parseInt(key.substring(6,8));
		if(validateMonthAndDay(month,day) && validate24HTime(hour,minute))
			return true;
		
		return false;
	}
	
	private boolean validate24HTime(int hour, int minute)
	{
		if(hour < 0 || hour > 23 || minute < 0 || minute > 59)
		{
			return false;
		}
		return true;
	}
	
	private boolean validateMonthAndDay(int month, int day)
	{
		if(month<1 || month>12 || day < 1 || day > 31)
		{
			return false;
		}
		switch(month)
		{
			case 2:
				if(day>28)
				{
					return false;
				}
			case 4,6,9,11:
				if(day>30)
				{
					return false;
				}
		}
		return true;
			
	}
	
	private void addDay(String day,Event newEvent)
	{
		
		//day start time end time name of event is going to be passed
	}
	

}
