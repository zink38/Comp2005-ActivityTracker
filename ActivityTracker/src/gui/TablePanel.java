package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Activity;

public class TablePanel extends JPanel {
	private JTable dataPointTable;
	private JTable activityTable;
	private ActivityTableModel activityTableModel;
	private DataPointTableModel dataPointTableModel;
	private JPopupMenu popup;
	
	
	public TablePanel() {
		activityTableModel = new ActivityTableModel();
		dataPointTableModel = new DataPointTableModel();
		dataPointTable = new JTable(dataPointTableModel);
		activityTable = new JTable(activityTableModel);
		popup = new JPopupMenu();
		
		JMenuItem detailsItem = new JMenuItem("View Details");
		popup.add(detailsItem);
		
		
		
		setLayout(new BorderLayout());
		add(new JScrollPane(dataPointTable),BorderLayout.NORTH);
		add(new JScrollPane(activityTable),BorderLayout.CENTER);
	}


	public void setActivityData(List<Activity> activities) {
		activityTableModel.setData(activities);
	}
	
	public void update() {
		activityTableModel.fireTableDataChanged();
		dataPointTableModel.fireTableDataChanged();
	}
}


