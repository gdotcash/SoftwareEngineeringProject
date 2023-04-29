package scheduler;

import java.util.LinkedList;


public class Day {
	
	LinkedList <Event> events;
	
	public Day()
	{
		this.events = new LinkedList <Event>();
	}
	
	public void addEvent(String startTime, String endTime, String name)
	{
		
	}
	
	public void removeEvent(Event oldEvent)
	{
		
		this.events.remove(oldEvent);
	}
	/*
	 * 
	 Not sure if we need this anymore due to the data validation in Calendar class for time. 
	private boolean validateTime(int hour,int minute)
	{
		if(hour<0 || hour>24 || minute <0 || minute>59)
		{
			return false;
		}
		
		
		return true;
	}
	*/
	public String display() {
		// TODO Auto-generated method stub
		return "";
		
	}
}
