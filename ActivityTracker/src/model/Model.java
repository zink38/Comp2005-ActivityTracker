package model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	private List<Account> accounts;
	
	public Model() {
		accounts = new LinkedList<Account>();
	}
	
	public String removeAccount() {
		return "Account removed\n";

	}
	
	public boolean getAccount(String userName, String password) {
		boolean result = false;
		for(Account account: accounts) {
			if(account.getUserName().equals(userName)) {
				if(account.getPassword().equals(password)) {
					result = true;					
				}
				
			}	
		}
		return result;
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
	public String loadFromFile() {
		return"Data loaded\n";
	}
	public String addData() {
		return "Data Added to Database\n";
	}
	public String sortData() {
		return "Data was Sorted\n";
	}
}
