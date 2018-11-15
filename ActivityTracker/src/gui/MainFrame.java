package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;

public class MainFrame extends JFrame {
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	private Controller controller;

	
	public MainFrame() {
		super("Activity Tracker");
		
		setLayout(new BorderLayout());
		
		controller = new Controller();
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();

		setJMenuBar(createMenuBar());
		
		textPanel.setEnabled(false);
		toolbar.setVisible(false);
		
		toolbar.setButtonListener(new ButtonListener() {
			public void sortEmitted() {
				textPanel.appendText(controller.sort());
			}
			public void editEmitted() {
				textPanel.setEnabled(true);
				textPanel.appendText(controller.isEdit());
				toolbar.isEdit(true);
			}
			public void doneEmitted() {
				textPanel.setEnabled(false);
				textPanel.appendText(controller.updateDB());
				toolbar.isEdit(false);
			}
		});
		
		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				if(e.isOption()) {
						if(controller.login(e)) {
							formPanel.setVisible(false);
							toolbar.setVisible(true);
						}
						else {
							textPanel.appendText("Login Failed\n");
						}
				}
				else {
					textPanel.appendText(controller.register(e));
				}
			}
		});
		
		
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);

		
		setMinimumSize(new Dimension(500,400));
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private JMenuBar createMenuBar() {
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu deviceMenu = new JMenu("Devices");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDeviceItem = new JMenuItem("Import Device...");
		JMenuItem exitItem = new JMenuItem("Exit");
		JMenuItem logoutItem = new JMenuItem("Logout");

		
		
		fileMenu.add(importDeviceItem);
		fileMenu.add(exportDataItem);
		fileMenu.addSeparator();
		fileMenu.add(logoutItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		menuBar.add(deviceMenu);
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		importDeviceItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		exportDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		importDeviceItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				textPanel.appendText(controller.importDevice());				
			}
		});
		
		logoutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				textPanel.setText("");
				textPanel.appendText(controller.logout());
				formPanel.setVisible(true);
				toolbar.setVisible(false);
			}
		});
		
		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPanel.appendText(controller.save());
			}
		});
		
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure you want to exit?", 
						"Confirm exit", JOptionPane.OK_CANCEL_OPTION);
				if(action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		
		});
		
		return menuBar;
	}
	
}