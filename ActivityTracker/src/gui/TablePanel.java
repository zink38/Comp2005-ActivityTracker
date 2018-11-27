package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Activity;
import model.ActivityDataPoint;

public class TablePanel extends JPanel {
	private boolean tableState = true;
	private JTable activityTable;
	private JTable dataPointTable;
	private JScrollPane aTS;
	private JScrollPane dTS;
	private ActivityTableModel activityTableModel;
	private DataPointTableModel dataPointTableModel;
	private JPopupMenu popupActivity;
	private JPopupMenu popupDataPoint;
	private ActivityTableListener activityTableListener;
	private DataPointTableListener dataPointTableListener;
	
	public TablePanel() {
		
		activityTableModel = new ActivityTableModel();
		dataPointTableModel = new DataPointTableModel();
		activityTable = new JTable(activityTableModel);
		dataPointTable = new JTable(dataPointTableModel);
		popupActivity = new JPopupMenu();
		popupDataPoint = new JPopupMenu();
		
		JMenuItem backItem = new JMenuItem("View Runs");
		JMenuItem detailItem = new JMenuItem("View Run Details");
		popupActivity.add(detailItem);
		popupDataPoint.add(backItem);
		
		activityTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row = activityTable.rowAtPoint(e.getPoint()); 
				activityTable.getSelectionModel().setSelectionInterval(row, row);
				if(e.getButton() ==  MouseEvent.BUTTON3) {
					popupActivity.show(activityTable, e.getX(), e.getY());
				}
			}
		});
		
		dataPointTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row = dataPointTable.rowAtPoint(e.getPoint()); 
				dataPointTable.getSelectionModel().setSelectionInterval(row, row);
				if(e.getButton() ==  MouseEvent.BUTTON3) {
					popupDataPoint.show(dataPointTable, e.getX(), e.getY());
				}
			}
		});
		
		detailItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				int row = activityTable.getSelectedRow();
				if(activityTableListener != null) {
					activityTableListener.changeTable(row);
				}
			}
		});
		backItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(dataPointTableListener != null) {
					dataPointTableListener.changeTable();
				}
			}
		});
		setLayout(null);
		
		aTS = new JScrollPane(activityTable);
		dTS = new JScrollPane(dataPointTable);
		dTS.setVisible(false);
		aTS.setBounds(0,0,500,600);
		dTS.setBounds(0,0,500,600);
		add(dTS);
		add(aTS);
		
		
	}
	public void setActivities(ArrayList<Activity> activities) {
		activityTableModel.setData(activities);
	}
	public void setDataPoints(ArrayList<ActivityDataPoint> dataPoints) {
		dataPointTableModel.setData(dataPoints);
	}
	public void updateActivity() {
		activityTableModel.fireTableDataChanged();	
	}
	
	public void updateDataPoint() {
		dataPointTableModel.fireTableDataChanged();
	}
	
	public void setActivityTableListener(ActivityTableListener listener) {
		this.activityTableListener = listener;
	}
	public void setDataPointTableListener(DataPointTableListener listener) {
		this.dataPointTableListener = listener;
	}
	public boolean getTableState() {
		return this.tableState;
	}
	public void setTableState(boolean tableState) {
		this.tableState = tableState;
	}
	
	public void changeTable() {
		if(tableState) {
			aTS.setVisible(false);
			dTS.setVisible(true);
			tableState = false;
		}
		else {		
			aTS.setVisible(true);
			dTS.setVisible(false);
			tableState = true;
		
		}
	}
	
}
