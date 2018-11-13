package controller;

import model.Database;
//hello
public class Controller {
	Database db = new Database();
	
	public Controller() {
		
	}
	public String login(){
		return db.getAccount();
	}
	public String save() {
		return db.saveToFile();
	}
	public String importDevice() {
		return db.loadFromFile();
	}
	public String removeData() {
		return db.removeData();
	}
	public String register() {
		return db.addAccount();
	}
	public String logout() {
		return "Data Restricted\n";
	}
	public String isEdit() {
		return "Prepared for editing\n";
	}
	public String updateDB() {
		return db.addData();
	}
	public String sort() {
		return db.sortData();
	}
}
