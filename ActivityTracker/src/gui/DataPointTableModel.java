package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.ActivityDataPoint;

public class DataPointTableModel extends AbstractTableModel{
	private List<ActivityDataPoint> dataPoints;
	private String[] colNames = {"Time Elapsed(s)","Distance Traveled(m)","Current Altitude (m)"};
	
	public DataPointTableModel() {
		
	}
	
	public String getColumnName(int column) {
		return colNames[column];
	}


	public void setData(List<ActivityDataPoint> dataPoints) {
		this.dataPoints = dataPoints;
	}
	
	public int getColumnCount() {
		return 3;
	}
	public int getRowCount() {
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
		default:
			value = null;
			break;
		}
		
		return value;
		
	}
}
