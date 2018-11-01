package gui;
import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String userName;
	private String password; 
	private boolean option;
	
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String userName, String password, boolean option) {
		super(source);
		
		this.option = option;
		this.userName = userName;
		this.password = password;
	}
	
	
	
	
	public boolean isOption() {
		return option;
	}

	public void setOption(boolean option) {
		this.option = option;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
