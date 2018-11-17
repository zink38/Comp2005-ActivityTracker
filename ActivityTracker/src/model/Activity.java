package model;

import java.util.LinkedList;
import java.util.List;

public class Activity {
	private double type;
	private double duration;
	private double distance;
	private double maxAltitude;
	private String date;
	private List<ActivityDataPoint> dataPoints;
	
	public Activity(String date){
		this.dataPoints = new LinkedList<ActivityDataPoint>();
		this.date = date;
		
	}
	public void addDataPoint(double duration, double distance, double altitude) {
		ActivityDataPoint point = new ActivityDataPoint(duration, distance, altitude);
		this.dataPoints.add(point);
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getMaxAltitude() {
		return maxAltitude;
	}
	public void setMaxAltitude(double maxAltitude) {
		this.maxAltitude = maxAltitude;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
