package gui;

import java.util.EventObject;

import model.Date;

public class FilterEvent extends EventObject {
	
	private Date date1;
	private Date date2; 
	
	
	public FilterEvent(Object source) {
		super(source);
	}
	
	public FilterEvent(Object source, Date date1, Date date2) {
		super(source);
		
		this.date1 = date1;
		this.date2 = date2;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}
}