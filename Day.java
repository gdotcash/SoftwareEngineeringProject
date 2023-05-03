package scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;


public class Day {
	
	private HashMap <String,Event> events;
	private ArrayList <String> keys;
	
	public Day()
	{
		this.events = new HashMap<String,Event>();
		this.keys=new ArrayList<String>();
		
	}
	
	public void addEvent(String startTime, String endTime, String name)
	{
		String key= start.replace(" ", "") + "-" + end.replace(" ", "");
		validateTime(key);
	}
	//needs updated
	public void removeEvent(Event oldEvent)
	{
		
		this.events.remove(oldEvent);
	}

	
	private boolean validateTime(String key)
	{
		
		//if the identical key is there, return false
		if(this.events.containsKey(key))
		{
			return false;
		}
		
		//Strings are formatted DDMMHHMM-DDMMHHMM
		String startTime=key.substring(4,8);
		String endTime=key.substring(13);
		//checking that the events start time is not after its end time, and that the months and days are real
		
		if(validateMonthAndDay())
			int indexOfKey=0;
			keys.add(key);
			String [] arr= (String[]) keys.toArray();
			Arrays.sort(arr);
			//putting the keys into a sorted array will show me the event before and after our desired scheduled time
			for(int i=0; i<arr.length();i++)
			{
				if(arr[i].equals(key))
				{
					indexOfKey=i;
					break;
				}
			}
			
			if(indexOfKey==0)
			{
				if(validateMonthAndDay(startTime,endTime)==false)
				{
					keys.remove(key);
					return false
				}
				return true;
			
			}
			//need to check that the end time of the previous event does not exceed the start time of the new event
			if(indexOfKey>0)
			{
				String endTimeOfPrev=arr[indexOfKey-1].substring(13);
				if(validateMonthAndDay(endTimeOfPrev,startTime)==false)
				{
					keys.remove(key);
					return false;
				}
			}
		
			//checking that the end time of the new event is not after the start time of the next event
			if(arr.length()>=indexOfKey + 1)
			{
				int startOfNext=arr[indexOfKey + 1].substring(3,8);
				if(validateMonthAndDay(key.substring(8), arr[indexOfKey + 1].substring(8))==false)
				{
					keys.remove(key);
					return false;
				}
			}
			//if all of these pass, we return true
			return true;
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
	
	public String display() {
		// TODO Auto-generated method stub
		return "";
		
	}
}
