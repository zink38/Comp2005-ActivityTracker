import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LoginFrame extends JFrame {
	private LoginPanel loginPanel;

	
	public LoginFrame() {
		super("Login");
		setLocation(600,0);
		setLayout(new BorderLayout());
		loginPanel = new LoginPanel();
		add(loginPanel, BorderLayout.CENTER);
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}
