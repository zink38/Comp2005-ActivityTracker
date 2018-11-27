package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Model {
	private Account activeUser;
	private ArrayList<Activity> userActivities;
	private ArrayList<Account> accounts;
	
	public Model() {
		accounts = new ArrayList<Account>();
		activeUser = new Account();
		userActivities = new ArrayList<Activity>();
	}
	
	public String removeAccount() {
		return "Account removed\n";

	}
	
	public Account getActiveUser() {
		return activeUser;
	}
	
	public ArrayList<Activity> getUserActivities(){
		return userActivities;
	}
	
	public boolean login(String userName, String password) {
		boolean result = false;
		for(Account account: accounts) {
			if(account.getUserName().equals(userName)) {
				if(account.getPassword().equals(password)) {
					result = true;	
					activeUser = account;
					userActivities = activeUser.getActivities();
				}
				
			}	
		}
		return result;
	}
	
	public void logout() {
		activeUser = new Account();
	}
	
	public String removeData() {
		return "Data removed\n";
	}
	
	public String createAccount(String userName, String password) {
		String result = "Account Created\n";
		boolean pass = true;
		for(Account account: accounts) {
			if(account.getUserName().equals(userName)) {
				result = "Account Name taken\n";
				pass = false;
			}
		}
		if(pass) {
			Account account = new Account(userName, password);
			accounts.add(account);
		}
		return result;
	}
	
	
	public String getData(){
		return "data table\n";
	}
	
	public String saveToFile() {
		return "Data saved\n";
	}
	public void importDevice(File file) throws IOException {
		Device device = createDevice(file);
		activeUser.addDevice(device);
		
	}
	
	public Device createDevice(File file) throws IOException {
		
		String dataDump;
		String dateDataDump;
		String[] data;
		String[] dateData;
		double distance;
		double duration;
		double altitude;
		double altitude1 = 0;
		double altitudeChange;
		int day;
		int month;
		int year;
		Date date;
		Device device;
		Activity activity = null;
		device = new Device(file);
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				dataDump = inputStream.next();
				data = dataDump.split(",");
				duration = Double.parseDouble(data[0]);
				distance = Double.parseDouble(data[1]);
				altitude = Double.parseDouble(data[2]);
				dateDataDump = data[3];
				dateData = dateDataDump.split("-");
				day = Integer.parseInt(dateData[0]);
				month = Integer.parseInt(dateData[1]);
				year = Integer.parseInt(dateData[2]);
				date = new Date(day,month,year);
				if(duration == 0) {
					altitude1 = 0;
					activity = new Activity(date);
					if(activity != null) {
						device.addActivity(activity);
					}
					
				}
				altitudeChange = altitude - altitude1;
				altitude1 = altitude;
				activity.setDistance(distance);
				activity.setDuration(duration);
				activity.addDataPoint(duration, distance, altitude,altitudeChange, date);				
			}
			inputStream.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return device;
	}
	
	public String addData() {
		return "Data Added to Database\n";
	}
	//public int searchMaxDistance(Date date1, Date date2) {
		//int maxDistance;
		//for(Activity activity: getUserActivities()) {
			//if(activ)
		
	//}
}
