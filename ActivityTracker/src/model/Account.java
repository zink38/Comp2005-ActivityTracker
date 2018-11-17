package model;

import java.util.LinkedList;
import java.util.List;

public class Account {
	private String userName;
	private String password;
	private List<Device> devices;
	private List<Activity> activities;
	
	public Account(String name, String password){
		this.userName = name;
		this.password = password;
		this.devices = new LinkedList<Device>();
		this.activities = new LinkedList<Activity>();
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addDevice(Device device) {
		devices.add(device);
	}
	
	public List<Activity> getActivities(){
		return activities;
	}
	
}
