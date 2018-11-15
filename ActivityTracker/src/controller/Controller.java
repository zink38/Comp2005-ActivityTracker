package controller;
//test
import model.Model;

public class Controller {
	Model model = new Model();
	
	public Controller() {
		
	}
	public String login(){
		return model.getAccount();
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
	public String register() {
		return model.addAccount();
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
