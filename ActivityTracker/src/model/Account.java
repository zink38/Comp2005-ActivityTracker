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
	private ArrayList<Object> info;
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
		this.friends = new ArrayList<Account>();
		this.info = new ArrayList<Object>();
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
		public ArrayList<Object> getInfo(){
			return info;
		}
		public void setInfo() {
			info.add(this.userName);
			//info.add(this.age);
			//info.add(this.gender);
		}
		
		public ArrayList<Account> getFriends() {
			return friends;
		}
		
		public void addFriend(Account a) {
			if (!friends.contains(a)) {
				friends.add(a);
			}
		}
		public void removeFriend(Account a) {
			friends.remove(a);
		}
		
		public ArrayList<Activity> getFriendsActivities(Account a) {
			return a.getActivities();
		}
		public ArrayList<Object> getFriendsInfo(Account a){
			return a.getInfo();
		}
		
		//end of changes
		
	public void addDevice(Device device) {
		devices.add(device);
		activities.addAll(device.getActivities());
		
	}
	
	public ArrayList<Activity> getActivities(){
		return activities;
	}
	
	//Could only get this working under the account class. Feel free to move it to the Activity class if you know how.
	public double avgTotalDuration() {
		double temp;
		double avg;
		ArrayList <Double> totals = new ArrayList<Double>();
		ArrayList<Activity> workouts = this.getActivities();
		
		for (int i = 0; i < workouts.size(); i++) {
			temp = workouts.get(i).getDuration();
			totals.add(temp);
		}
		
		double sum = 0;
		for (int j = 0; j < totals.size(); j++) {
			sum += totals.get(j);
		}
		double numOfWorkouts = workouts.size();
		avg = sum / numOfWorkouts;
		return avg;
	}
	
	public double avgTotalDistance() {
		double temp;
		double avg;
		ArrayList <Double> totals = new ArrayList<Double>();
		ArrayList<Activity> workouts = this.getActivities();
		
		for (int i = 0; i < workouts.size(); i++) {
			temp = workouts.get(i).getDistance();
			totals.add(temp);
		}
		
		double sum = 0;
		for (int j = 0; j < totals.size(); j++) {
			sum += totals.get(j);
		}
		double numOfWorkouts = workouts.size();
		avg = sum / numOfWorkouts;
		return avg;
	}
	
	public double avgTotalCalories() {
		double temp;
		double avg;
		ArrayList <Double> totals = new ArrayList<Double>();
		ArrayList<Activity> workouts = this.getActivities();
		
		for (int i = 0; i < workouts.size(); i++) {
			temp = workouts.get(i).getCalories();
			totals.add(temp);
		}
		
		double sum = 0;
		for (int j = 0; j < totals.size(); j++) {
			sum += totals.get(j);
		}
		double numOfWorkouts = workouts.size();
		avg = sum / numOfWorkouts;
		return avg;
	}
	
}
