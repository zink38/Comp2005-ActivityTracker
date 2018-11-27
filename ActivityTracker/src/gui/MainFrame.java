package gui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;
import model.Activity;
import model.ActivityDataPoint;
import model.Date;

public class MainFrame extends JFrame {
	//private TextPanel textPanel;
	private StatPanel statPanel;
	private FormPanel formPanel;
	private Controller controller;
	private TablePanel tablePanel;
	private JFileChooser fileChooser;
	private ArrayList<Activity> defaultActivities;
	private ArrayList<ActivityDataPoint> defaultDataPoints;
	
	public MainFrame() {
		super("Activity Tracker");
		
		setLayout(null);
		
		controller = new Controller();
		
		//textPanel = new TextPanel();
		statPanel = new StatPanel();
		formPanel = new FormPanel();
		tablePanel = new TablePanel();
		fileChooser = new JFileChooser();
		defaultActivities = new ArrayList<Activity>(); 
		defaultDataPoints = new ArrayList<ActivityDataPoint>();
		
		fileChooser.addChoosableFileFilter(new DeviceFileFilter());
		
		
		setJMenuBar(createMenuBar());
		tablePanel.setActivities(defaultActivities);
		tablePanel.setDataPoints(defaultDataPoints);
		
		//textPanel.setEnabled(false);
		statPanel.setVisible(false);
		//tablePanel.setVisible(true);
		
		tablePanel.setActivityTableListener(new ActivityTableListener() {
			public void changeTable(int row) {
				tablePanel.changeTable();
				tablePanel.setDataPoints(controller.getUserActivities().get(row).getDataPoints());
				tablePanel.updateDataPoint();				
			}
		});
		
		tablePanel.setDataPointTableListener(new DataPointTableListener() {
			public void changeTable() {
				tablePanel.changeTable();
				//tablePanel.updateActivity();
			}
		});
		
		
		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				if(e.isOption()) {
						if(controller.login(e)) {
							formPanel.setVisible(false);
							statPanel.setVisible(true);
							tablePanel.setActivities(controller.getUserActivities());
							tablePanel.updateActivity();
						}
						else {
							
						}
				}
				else {
					controller.register(e);
				}
			}
		});
		
		statPanel.setFilterListener(new FilterListener() {
						
			public void filterEventOccurred(FilterEvent e) {
				ArrayList<Activity> activities;
				ArrayList<Activity> filteredActivities;
				Date date1;
				Date date2; 
				date1 = e.getDate1();
				date2 = e.getDate2();
				activities = controller.getUserActivities();
				filteredActivities = controller.filterByDate(date1, date2, activities);
				System.out.println(tablePanel.getTableState());
				if(!tablePanel.getTableState()) {
					tablePanel.changeTable();
				}
				tablePanel.setActivities(filteredActivities);
				tablePanel.updateActivity();
				
				
			}
		});
		
		setMinimumSize(new Dimension(800,600));
		setMaximumSize(new Dimension(800,600));
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		statPanel.setBounds(0,0,300,600);
		formPanel.setBounds(0,0,300,600);
		tablePanel.setBounds(300,0,500,600);
		
		add(statPanel);
		add(formPanel);
		add(tablePanel);
		
		
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
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.importDevice(fileChooser.getSelectedFile());
						tablePanel.updateActivity();
						tablePanel.updateDataPoint();
						
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could Not Load Data From File.",
								"Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		logoutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				controller.logout();
				if(!tablePanel.getTableState()) {
					tablePanel.changeTable();
				}
				tablePanel.setActivities(defaultActivities);
				tablePanel.updateActivity();
				formPanel.setVisible(true);
				statPanel.setVisible(false);
			}
		});
		
		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.save();
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