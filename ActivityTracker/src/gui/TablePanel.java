package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Activity;

public class TablePanel extends JPanel {
	private JTable table;
	private ActivityTableModel tableModel;
	
	public TablePanel() {
		
		tableModel = new ActivityTableModel();
		table = new JTable(tableModel);
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	public void setData(ArrayList<Activity> activities) {
		tableModel.setData(activities);
	}
	public void update() {
		tableModel.fireTableDataChanged();
	}
}
