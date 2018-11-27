package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Activity {
	private Activities type;
	private double duration;
	private double distance;
	private double maxAltitude;
	private Date date;
	private ArrayList<ActivityDataPoint> dataPoints;
	
	public Activity(Date date){
		this.dataPoints = new ArrayList<ActivityDataPoint>();
		this.date = date;
		
	}
	public void addDataPoint(double duration, double distance, double altitude,double altitudeChange, Date date) {
		ActivityDataPoint point = new ActivityDataPoint(duration, distance, altitude, altitudeChange, date);
		if(altitude > this.maxAltitude) {
			this.maxAltitude = altitude;
		}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<ActivityDataPoint> getDataPoints(){
		return dataPoints;
	}
	
}
