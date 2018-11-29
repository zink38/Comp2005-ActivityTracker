package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Activity;
import model.Date;
import model.Model;




public class StatPanel extends JPanel {
	private TextField dateField1;
	private TextField dateField2;
	private JLabel dateHeader;
	private JLabel dash;
	private JLabel avgDistance;
	private JLabel avgDuration;
	private JLabel avgAltGained;
	private JLabel avgAltLost;
	private JLabel avgCalories;
	private JLabel avgDistanceL;
	private JLabel avgDurationL;
	private JLabel avgAltGainedL;
	private JLabel avgAltLostL;
	private JLabel avgCaloriesL;
	private JButton filterBtn;
	private FilterListener filterListener;
	
	public StatPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		filterBtn = new JButton("Filter");
		dateField1 = new TextField(10);
		dateField2 = new TextField(10);
		dateHeader = new JLabel("Enter Date Range DD/MM/YEAR");
		dash = new JLabel("-");
		avgCalories = new JLabel("0");
		avgDistance = new JLabel("0");
		avgDuration = new JLabel("0");
		avgAltGained = new JLabel("0");
		avgAltLost = new JLabel("0");
		avgCaloriesL = new JLabel("0");
		avgDistanceL = new JLabel("Average Distance: ");
		avgDurationL = new JLabel("Average Duration: ");
		avgAltGainedL = new JLabel("Average Altitude Gained: ");
		avgAltLostL = new JLabel("Average Altitude Lost: ");
		avgCaloriesL = new JLabel("Average Calories Burned: ");
		
		
		filterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int day;
				int month;
				int year;
				Date date1;
				Date date2;
				String[] dateData;
				String dateDump1 = dateField1.getText();
				String dateDump2 = dateField2.getText();
				dateData = dateDump1.split("/");
				day = Integer.parseInt(dateData[0]);
				month = Integer.parseInt(dateData[1]);
				year = Integer.parseInt(dateData[2]);
				date1 = new Date(day,month,year);
				dateData = dateDump2.split("/");
				day = Integer.parseInt(dateData[0]);
				month = Integer.parseInt(dateData[1]);
				year = Integer.parseInt(dateData[2]);
				date2 = new Date(day,month,year);

				FilterEvent ev = new FilterEvent(this, date1, date2);
				
				if(filterListener != null) {
					filterListener.filterEventOccurred(ev);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Statistics");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents();
	}
	
	public void layoutComponents() {
		int x = 10;
		int y = 25;
		int increment = 15;
		int width = 200;
		int height = 15;
		int x2 = x + width;
		setLayout(null);
		avgDurationL.setBounds(x,y,width,height);
		avgDuration.setBounds(x2,y,width,height);
		y += increment;
		avgDistanceL.setBounds(x,y,width,height);
		avgDistance.setBounds(x2,y,width,height);
		y += increment;
		avgAltGainedL.setBounds(x,y,width,height);
		avgAltGained.setBounds(x2,y,width,height);
		y += increment;
		avgAltLostL.setBounds(x,y,width,height);
		avgAltLost.setBounds(x2,y,width,height);
		y += increment;
		avgCaloriesL.setBounds(x,y,width,height);
		avgCalories.setBounds(x2,y,width,height);

		add(avgDurationL);
		add(avgDuration);
		add(avgDistanceL);
		add(avgDistance);
		add(avgAltGainedL);
		add(avgAltGained);
		add(avgAltLostL);
		add(avgAltLost);
		add(avgCaloriesL);
		add(avgCalories);
		
		y += increment*5;
		dateHeader.setBounds(x+x, y, 250, height);
		y += increment;
		dateField1.setBounds(x,y,110,20);
		dateField2.setBounds(x+x+110,y,110,20);
		dash.setBounds(122,y,x,height);
		y+=increment*2;
		filterBtn.setBounds(50, y, width/2, height*2);
		
		add(dateHeader);
		add(dateField1);
		add(dateField2);
		add(dash);
		add(filterBtn);
		
	}
	public void setFilterListener(FilterListener filterListener) {
		this.filterListener = filterListener;
	}
	public void update(ArrayList<Activity> activities) {
		avgDuration.setText(Double.toString((double)Math.round(Model.avgTotalDuration(activities)*100)/100));		avgDistance.setText(Double.toString((double)Math.round(Model.avgTotalDistance(activities)*100)/100));
		avgAltGained.setText(Double.toString((double)Math.round(Model.avgAltGained(activities)*100)/100));
		avgAltLost.setText(Double.toString((double)Math.round(Model.avgAltLost(activities)*100)/100));
		avgCalories.setText(Double.toString((double)Math.round(Model.avgTotalCalories(activities)*100)/100));
	}	
	public void reset() {
		avgDuration.setText("0");
		avgDistance.setText("0");
		avgAltGained.setText("0");
		avgAltLost.setText("0");
		avgCalories.setText("0");
	}
}
