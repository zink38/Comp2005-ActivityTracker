package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Activity;

public class ActivityTableModel extends AbstractTableModel {
	private ArrayList<Activity> activities;
	private String[] colNames = {"Duration(s)","Distance(m)","Altitude Gained(m)","Altitude Lost(m)","Pace(min/km)","Calories(cal)","Date"};
	
	public ActivityTableModel() {
		
	}
	
	public String getColumnName(int column) {
		
		return colNames[column];
	}
	
	public void setData(ArrayList<Activity> activities) {
		this.activities = activities;
	}
	public ArrayList<Activity> getData() {
		return this.activities;
	}
	
	public int getColumnCount() {
		
		return 7;
	}

	
	public int getRowCount() throws NullPointerException {
		
		return activities.size();
	}

	
	public Object getValueAt(int row, int col) {
		Activity activity = activities.get(row);
		Object value = new Object();
		switch(col) {
		case 0:
			value = activity.getDuration();
			
			break;
		case 1:
			value = activity.getDistance();
			
			break;
		case 2:
			value = (double) Math.round(activity.getAltGained()*100)/100;;
			
			break;
		case 3:
			value = (double) Math.round(activity.getAltLost()*100)/100;
			
			break;
		case 4:
			value = (double) Math.round(activity.getPace()*100)/100;
			
			break;
		case 5:
			value = (double) Math.round(activity.getCalories()*100)/100;
			
			break;
		case 6:
			value = activity.getDate();
			
			break;
		default:
			value = null;
			break;
		}
		return value;
	}
	
}
