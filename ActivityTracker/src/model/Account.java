package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Account {
	private String userName;
	private String password;
	private ArrayList<Device> devices;
	private ArrayList<Activity> activities;
	private ArrayList<Account> friends;

	//private int age;
	//private String gender;
	
	public Account() {
	
	}
	
	public Account(String name, String password){
		this.userName = name;
		this.password = password;
		this.devices = new ArrayList<Device>();
		this.activities = new ArrayList<Activity>();
		//this.age = age;
		//this.gender = gender;

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
	//start of changes 
	//commenting out methods involving age and gender until constructor in Model matches
		/*public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
		*/
		
		
	public void addDevice(Device device) {
		devices.add(device);
		activities.addAll(device.getActivities());	
	}
	
	public ArrayList<Activity> getActivities(){
		return activities;
	}
	
	//Could only get this working under the account class. Feel free to move it to the Activity class if you know how. 
	
}
