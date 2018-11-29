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
	
	private JLabel maxDistance;
	private JLabel maxDuration;
	private JLabel maxAltGained;
	private JLabel maxAltLost;
	private JLabel maxCalories;
	private JLabel maxDistanceL;
	private JLabel maxDurationL;
	private JLabel maxAltGainedL;
	private JLabel maxAltLostL;
	private JLabel maxCaloriesL;
	
	private JLabel maxPace;
	private JLabel maxPaceL;
	
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
		
		maxPaceL = new JLabel("Max Pace: ");
		maxPace = new JLabel("0");
		
		maxCalories = new JLabel("0");
		maxDistance = new JLabel("0");
		maxDuration = new JLabel("0");
		maxAltGained = new JLabel("0");
		maxAltLost = new JLabel("0");
		maxCaloriesL = new JLabel("0");
		maxDistanceL = new JLabel("Max Distance: ");
		maxDurationL = new JLabel("Max Duration: ");
		maxAltGainedL = new JLabel("Max Altitude Gained: ");
		maxAltLostL = new JLabel("Max Altitude Lost: ");
		maxCaloriesL = new JLabel("Max Calories Burned: ");
		
		
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
		y += increment;
		maxDurationL.setBounds(x,y,width,height);
		maxDuration.setBounds(x2,y,width,height);
		y += increment;
		maxDistanceL.setBounds(x,y,width,height);
		maxDistance.setBounds(x2,y,width,height);
		y += increment;
		maxAltGainedL.setBounds(x,y,width,height);
		maxAltGained.setBounds(x2,y,width,height);
		y += increment;
		maxAltLostL.setBounds(x,y,width,height);
		maxAltLost.setBounds(x2,y,width,height);
		y += increment;
		maxCaloriesL.setBounds(x,y,width,height);
		maxCalories.setBounds(x2,y,width,height);
		y += increment;
		maxPaceL.setBounds(x,y,width,height);
		maxPace.setBounds(x2,y,width,height);
		y += increment;

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
		add(maxDurationL);
		add(maxDuration);
		add(maxDistanceL);
		add(maxDistance);
		add(maxAltGainedL);
		add(maxAltGained);
		add(maxAltLostL);
		add(maxAltLost);
		add(maxCaloriesL);
		add(maxCalories);
		add(maxPaceL);
		add(maxPace);
		
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
		avgDuration.setText(Double.toString((double)Math.round(Model.avgTotalDuration(activities)*100)/100)+"s");		
		avgDistance.setText(Double.toString((double)Math.round(Model.avgTotalDistance(activities)*100)/100)+"m");
		avgAltGained.setText(Double.toString((double)Math.round(Model.avgAltGained(activities)*100)/100)+"m");
		avgAltLost.setText(Double.toString((double)Math.round(Model.avgAltLost(activities)*100)/100)+"m");
		avgCalories.setText(Double.toString((double)Math.round(Model.avgTotalCalories(activities)*100)/100)+"cal");
		
		maxDuration.setText(Double.toString((double)Math.round(Model.maxDuration(activities)*100)/100)+"s");		
		maxDistance.setText(Double.toString((double)Math.round(Model.maxDistance(activities)*100)/100)+"m");
		maxAltGained.setText(Double.toString((double)Math.round(Model.maxAltGained(activities)*100)/100)+"m");
		maxAltLost.setText(Double.toString((double)Math.round(Model.maxAltLost(activities)*100)/100)+"m");
		maxCalories.setText(Double.toString((double)Math.round(Model.maxCalories(activities)*100)/100)+"cal");
		maxPace.setText(Double.toString((double)Math.round(Model.maxPace(activities)*100)/100)+"min/km");
	}	
	public void reset() {
		avgDuration.setText("0");
		avgDistance.setText("0");
		avgAltGained.setText("0");
		avgAltLost.setText("0");
		avgCalories.setText("0");
		maxDuration.setText("0");
		maxDistance.setText("0");
		maxAltGained.setText("0");
		maxAltLost.setText("0");
		maxCalories.setText("0");
		maxPace.setText("0");
	}
}
