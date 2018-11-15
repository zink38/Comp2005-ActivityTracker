package controller;
//Keegan was here 
import model.Model;
import gui.FormEvent;

public class Controller {
	Model model = new Model();
	
	public Controller() {
		
	}
	public boolean login(FormEvent ev){
		String userName = ev.getUserName();
		String password = ev.getPassword();
		return model.getAccount(userName, password);
	}
	public String save() {
		return model.saveToFile();
	}
	public String importDevice() {
		return model.loadFromFile();
	}
	public String removeData() {
		return model.removeData();
	}
	public String register(FormEvent ev) {
		String userName = ev.getUserName();
		String password = ev.getPassword();
		return model.createAccount(userName, password);
	}
	public String logout() {
		return "Data Restricted\n";
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
