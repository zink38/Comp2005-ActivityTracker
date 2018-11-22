package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Activity;

public class ActivityTableModel extends AbstractTableModel {
	private List<Activity> activities;
	private String[] colNames = {"Duration","Distance","Altitdude","Date"};
	
	public ActivityTableModel() {
		
	}
	
	public String getColumnName(int column) {
		
		return colNames[column];
	}
	
	public void setData(List<Activity> activities) {
		this.activities = activities;
	}
	
	public int getColumnCount() {
		
		return 4;
	}

	
	public int getRowCount() {
		
		return activities.size();
	}

	
	public Object getValueAt(int row, int col) {
		Activity activity = activities.get(row);
		Object value = new Object();
		switch(col) {
		case 0:
			value = activity.getDuration();
			System.out.println("Duration");
			break;
		case 1:
			value = activity.getDistance();
			System.out.println("Distance");
			break;
		case 2:
			value = activity.getMaxAltitude();
			System.out.println("Altitude");
			break;
		case 3:
			value = activity.getDate();
			System.out.println("Date");
			break;
		default:
			value = null;
			break;
		}
		return value;
	}
	
}
