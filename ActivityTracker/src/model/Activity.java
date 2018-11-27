package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Activity {
	private Activities type;
	private double duration;
	private double distance;
	private double maxAltitude;
	private double altGained;
	private double altLost;
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
		//added altGained and altLost functions
		if(altitudeChange >= 0) {
			this.altGained += altitudeChange;
		}
		else {
			this.altLost += altitudeChange;
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
	public double getAltGained() {
		return altGained;
	}
	public void setAltGained(double altGained) {
		this.altGained = altGained;
	}
	public double getAltLost() {
		return altLost;
	}
	public void setAltLost(double altLost) {
		this.altLost = altLost;
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
