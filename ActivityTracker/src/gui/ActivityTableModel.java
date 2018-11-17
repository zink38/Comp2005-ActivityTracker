package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Activity;

public class ActivityTableModel extends AbstractTableModel{
	private List<Activity> activities;
	private String[] colNames = {"Duration(s)","Distance(m)","Max Altitude(m)","Date"};
	
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
			break;
		case 1:
			value = activity.getDistance();
			break;
		case 2:
			value = activity.getMaxAltitude();
			break;
		case 3:
			value = activity.getDate();
		default:
			value = null;
			break;
		}
		
		return value;
		
	}
}
