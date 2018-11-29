package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Activity {
	private Activities type;
	private double duration;
	private double distance;
	private double altGained;
	private double altLost;
	private double pace;
	private double calories;
	private Date date;
	private ArrayList<ActivityDataPoint> dataPoints;
	
	public Activity(Date date){
		this.dataPoints = new ArrayList<ActivityDataPoint>();
		this.date = date;
		
	}
	public void addDataPoint(double duration, double distance, double altitude,double altitudeChange, Date date) {
		ActivityDataPoint point = new ActivityDataPoint(duration, distance, altitude, altitudeChange, date);
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
		int lastPos = this.dataPoints.size() - 1; 
		duration = this.dataPoints.get(lastPos).getCurrentDuration();
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getDistance() {
		int lastPos = this.dataPoints.size() - 1; 
		distance = this.dataPoints.get(lastPos).getCurrentDistance();
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
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
	public double getPace() {
		double timeInMin = this.getDuration() / 60;
		double distInKm = this.getDistance() / 1000;
		pace = timeInMin / distInKm;
		return pace;
	}
	public void setPace(double distance, double duration) {
		double timeInMin = duration/60;
		double distInKm = distance / 1000;
		pace = distInKm / timeInMin;
	}
	public double getCalories() {
		int lastPos = this.dataPoints.size() - 1; 
		double dist = this.dataPoints.get(lastPos).getCurrentDistance();
		calories = dist/ 11.44876;
		return calories;
	}
	public void setCalories(double cals) {
		calories = cals;
	}

}
