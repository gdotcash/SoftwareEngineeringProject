
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
		String key= start.replace(" ", "") + "-" + end.replace(" ", "");
		String startTime=key.substring(0,8);
		String endTime=key.substring(9);
		String dayKey=key.substring(0,4);
		
		
		if(validateTime(key,name)==false)
		{
			return false;
		}
		if(this.calendar.get(dayKey).addEvent(startTime,endTime,name)==true)
		{
			return true;
		}
		return false;
		//need to validate the time within the day class and validate the day. 
		
		
	}
	
	/*
	this endtime  string would be enough to make sure there is nothing that this event overlaps. it should create a string in the key format for endtime and then check all
    the keys between those times and if there are no keys inbetween those times it returns true
	needs to be the ability to check for the end time of previous events so that it isnt in the middle of something before it.
	going to need to check the entry before it so that the previous endtime is not after the start time AND before the end time.
	*/
	
	private boolean validateTime(String key, String name)
	{
		
		//Strings are formatted DDMMHHMM-DDMMHHMM
		String startTime=key.substring(0,8);
		String endTime=key.substring(9);
		String dayKey=key.substring(0,4);
		if(this.calendar.containsKey(dayKey)==false)
		{
			if(validateMonthAndDay(startTime,endTime)==false)
			{
				return false;
			}
			addDay(dayKey);
			return true;
		}
		if(this.calendar.containsKey(dayKey)==true)
		{
			if(validateMonthAndDay(startTime,endTime==false))
			{
				return false;
			}
			return true;
		}

	
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
	
	private boolean validateMonthAndDay(String start, String end)
	{
		int month=Integer.parseInt(start.substring(0,2)); 
		int day=Integer.parseInt(start.substring(2,4));
		int hour=Integer.parseInt(start.substring(4,6));
		int minute=Integer.parseInt(start.substring(6,8));
		
		int endMonth=Integer.parseInt(end.substring(0,2));
		int endDay=Integer.parseInt(end.substring(2,4));
		int endHour=Integer.parseInt(end.substring(4,6));
		int endMinute=Integer.parseInt(end.substring(6,8));
		
		if(validate24HTime(hour,minute)==false || validate24HTime(endHour,endMinute)==false)
		{
			return false;
		}
		
		if(month<1 || month>12 || day < 1 || day > 31 || endMonth!=month || endDay!=day)
		{
			return false;
		} 
		
		if(endHour<hour || (endHour==hour && endMinute<minute))
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
	
	private void addDay(String day)
	{
		
		
		Day newDay= new Day();
		
		this.calendar.put(day,newDay);
		
		
	}
	

}
