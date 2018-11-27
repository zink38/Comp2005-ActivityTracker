package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Activity;

public class ActivityTableModel extends AbstractTableModel {
	private ArrayList<Activity> activities;
	private String[] colNames = {"Duration","Distance","Max Altitude","Date"};
	
	public ActivityTableModel() {
		
	}
	
	public String getColumnName(int column) {
		
		return colNames[column];
	}
	
	public void setData(ArrayList<Activity> activities) {
		this.activities = activities;
	}
	
	public int getColumnCount() {
		
		return 4;
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
			value = activity.getMaxAltitude();
			
			break;
		case 3:
			value = activity.getDate();
			
			break;
		default:
			value = null;
			break;
		}
		return value;
	}
	
}
