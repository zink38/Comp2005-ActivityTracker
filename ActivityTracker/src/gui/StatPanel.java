package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Date;




public class StatPanel extends JPanel {
	private TextField dateField1;
	private TextField dateField2;
	private JLabel dateHeader;
	private JLabel dash;
	private JLabel maxDistance;
	private JLabel maxDuration;
	private JLabel maxAltitude;
	private JLabel maxDistanceL;
	private JLabel maxDurationL;
	private JLabel maxAltitudeL;
	private JButton filterBtn;
	private FilterListener filterListener;
	
	public StatPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		filterBtn = new JButton("Filter");
		dateField1 = new TextField(10);
		dateField2 = new TextField(10);
		dateHeader = new JLabel("Enter Date Range");
		dash = new JLabel("-");
		maxDistance = new JLabel("0");
		maxDuration = new JLabel("0");
		maxAltitude = new JLabel("0");
		maxDistanceL = new JLabel("Max Distance: ");
		maxDurationL = new JLabel("Max Duration: ");
		maxAltitudeL = new JLabel("Max Altitude: ");
		
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
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
////////////////////FIRST ROW///////////////
		gc.gridy = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		
		add(dateHeader, gc);
		
		////////////////////NEXT ROW//////////////////////
		gc.gridy++;
		
		gc.weightx = 0.1;
		gc.weighty = 0.01;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(dateField1, gc);
		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		add(dash,gc);
		gc.gridx = 2;
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(dateField2,gc);
		
		
		////////////////NEXT ROW////////////////////
		gc.gridy++;
		
		gc.weightx = 2;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(maxDistanceL, gc);
		gc.gridx = 1;
		
		gc.weightx = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(maxDistance,gc);
		
		////////////////NEXT ROW////////////////////
		gc.gridy++;
		
		gc.weightx = 2;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(maxDurationL, gc);
		gc.gridx = 1;
		
		gc.weightx = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(maxDuration,gc);
		
		////////////NEXT ROW///////////////////
		gc.gridy++;
		
		gc.weightx = 2;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(maxAltitudeL, gc);
		gc.gridx = 1;
		
		gc.weightx = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(maxAltitude,gc);
		
		/////////////NEXT ROW ////////////////
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridx = 1;
		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(filterBtn,gc);
	}
	public void setFilterListener(FilterListener filterListener) {
		this.filterListener = filterListener;
	}
	
}
