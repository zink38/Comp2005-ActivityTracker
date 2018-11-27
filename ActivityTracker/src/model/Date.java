package model;

public class Date {
	private int day;
	private int month;
	private int year;
	private int value;
	public Date(int day, int month, int year) {
		String monthS;
		String dayS;
		String yearS;
		String valueS;
		this.day = day;
		this.month = month;
		this.year = year;
		
		if(month<10) {
			monthS = "0"+Integer.toString(month);
		}
		else {
			monthS = Integer.toString(month);
		}
		if(day<10) {
			dayS = "0"+Integer.toString(day);
		}
		else {
			dayS = Integer.toString(day);
		}
				
		yearS = Integer.toString(year);
		valueS = yearS+monthS+dayS;
		
		this.value = Integer.parseInt(valueS); 
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String toString() {
		return day+"/"+month+"/"+year;
	}
	
	
}
