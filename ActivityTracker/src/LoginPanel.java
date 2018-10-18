import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginPanel extends JPanel {
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JTextField nameField;
	private JTextField passwordField;
	private JButton logBtn;
	private JButton regBtn;
	
	public LoginPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name: ");
		passwordLabel = new JLabel("Password: ");
		nameField = new JTextField(10);
		passwordField = new JTextField(10);
		
		logBtn = new JButton("Login");
		regBtn = new JButton("Register");
		
		
		Border innerBorder = BorderFactory.createTitledBorder("LOGIN");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

////////////////////FIRST ROW///////////////
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
////////////////////SECOND ROW//////////////////////
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(passwordLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(passwordField,gc);
		////////////////THIRD ROW////////////////////
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(logBtn,gc);
		//////////////////////FOURTH ROW//////////////
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(regBtn,gc);
	}

}
