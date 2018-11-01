package gui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JTextField userNameField;
	private JTextField passwordField;
	private JButton logBtn;
	private JButton regBtn;
	private FormListener formListener;
	
	
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		
		userNameLabel = new JLabel("UserName: ");
		passwordLabel = new JLabel("Password: ");
		userNameField = new JTextField(10);
		passwordField = new JTextField(10);
		logBtn = new JButton("Login"); 
		regBtn = new JButton("Register");
		
		// Set up mnemonics.
		logBtn.setMnemonic(KeyEvent.VK_L); 
		regBtn.setMnemonic(KeyEvent.VK_R);
		userNameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		userNameLabel.setLabelFor(userNameField);	
		
		logBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameField.getText();
				String password = passwordField.getText();
				boolean option = true;
				
				FormEvent ev = new FormEvent(this, userName, password, option);
				
				if(formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}
		});
		regBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameField.getText();
				String password = passwordField.getText();
				boolean option = false;
				FormEvent ev = new FormEvent(this, userName, password, option);
				
				if(formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Login");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents();
		
	}
	
	public void layoutComponents() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

////////////////////FIRST ROW///////////////
		gc.gridy = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(userNameLabel, gc);
		
		gc.gridx = 1;

		gc.anchor = GridBagConstraints.LINE_START;
		add(userNameField, gc);
////////////////////NEXT ROW//////////////////////
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(passwordLabel, gc);
		
		gc.gridx = 1;

		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(passwordField,gc);
		
		
		////////////////NEXT ROW////////////////////
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 1;

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(logBtn,gc);
		
	////////////////NEXT ROW////////////////////
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridx = 1;
		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(regBtn,gc);
			
		
	}
	
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}
}

