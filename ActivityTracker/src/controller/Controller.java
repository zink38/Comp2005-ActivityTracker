package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import gui.FormEvent;
import model.Account;
import model.Activity;
import model.Model;

public class Controller {
	Model model = new Model();
	
	public Controller() {
		
	}
	public boolean login(FormEvent ev){
		String userName = ev.getUserName();
		String password = ev.getPassword();
		return model.login(userName, password);
	}
	public Account getActiveUser() {
		return model.getActiveUser();
	}
	
	public ArrayList<Activity> getUserActivities(){
		return model.getUserActivities();
	}
	public String save() {
		return model.saveToFile();
	}
	public void importDevice(File file) throws IOException {
		model.importDevice(file);
		
	}
	public String removeData() {
		return model.removeData();
	}
	public String register(FormEvent ev) {
		String userName = ev.getUserName();
		String password = ev.getPassword();
		return model.createAccount(userName, password);
	}
	public void logout() {
		model.logout();
	}
	public String isEdit() {
		return "Prepared for editing\n";
	}
	public String updateDB() {
		return model.addData();
	}
	public String sort() {
		return model.sortData();
	}
}
