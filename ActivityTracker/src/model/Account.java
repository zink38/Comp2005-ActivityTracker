package model;

import java.util.LinkedList;

public class Account {
	private String name;
	private String password;
	private LinkedList<Device> devices;
	
	public Account(String name, String password){
		this.name = name;
		this.password = password;
	}
}
