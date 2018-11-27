package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.ActivityDataPoint;

public class DataPointTableModel extends AbstractTableModel {
	private ArrayList<ActivityDataPoint> dataPoints;
	private String[] colNames = {"Duration","Distance","Altitude","Altitude Change","Date"};
	
	public DataPointTableModel() {
		
	}
	
	public String getColumnName(int column) {
		
		return colNames[column];
	}
	
	public void setData(ArrayList<ActivityDataPoint> dataPoints) {
		this.dataPoints = dataPoints;
	}
	
	public int getColumnCount() {
		
		return 5;
	}

	
	public int getRowCount() throws NullPointerException{
		
		return dataPoints.size();
	}

	
	public Object getValueAt(int row, int col) {
		ActivityDataPoint dataPoint = dataPoints.get(row);
		Object value = new Object();
		switch(col) {
		case 0:
			value = dataPoint.getCurrentDuration();
			
			break;
		case 1:
			value = dataPoint.getCurrentDistance();
			
			break;
		case 2:
			value = dataPoint.getCurrentAltitude();
			
			break;
		case 3:
			value = (double) Math.round(dataPoint.getAltitudeChange()*100)/100;
			
			break;
		case 4:
			value = dataPoint.getDate();
			
			break;
		default:
			value = null;
			break;
		}
		return value;
	}
	
}