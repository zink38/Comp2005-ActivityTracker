package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Account {
	private String userName;
	private String password;
	private ArrayList<Device> devices;
	private ArrayList<Activity> activities;
	
	public Account() {
	
	}
	
	public Account(String name, String password){
		this.userName = name;
		this.password = password;
		this.devices = new ArrayList<Device>();
		this.activities = new ArrayList<Activity>();
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
		activities.addAll(device.getActivities());
		System.out.println("Account");
	}
	
	public ArrayList<Activity> getActivities(){
		return activities;
	}
	
}
