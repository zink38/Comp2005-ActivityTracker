package model;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Device {
	private String name;
	private List<Activity> activities;
	private File source;
	
	public Device(File source){
		this.source = source;
		this.activities = new LinkedList<Activity>();
	}
	
	public void addActivity(Activity activity) {
		this.activities.add(activity);
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
	
	
}
