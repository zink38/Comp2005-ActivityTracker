package model;

import java.util.LinkedList;

public class Account {
	private String userName;
	private String password;
	
	public Account(String name, String password){
		this.userName = name;
		this.password = password;
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

	private LinkedList<Device> devices;
	
	
}
