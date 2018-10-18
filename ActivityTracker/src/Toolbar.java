import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	private JButton profileButton;
	private JButton friendsButton;
	private JButton activityButton;
	private JButton deviceButton;
	private JButton trainingButton;
	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		profileButton = new JButton("Profile");
		friendsButton = new JButton("Friends");
		activityButton = new JButton("Activity");
		deviceButton = new JButton("Device");
		trainingButton = new JButton("Training Program");
		
		profileButton.addActionListener(this);
		friendsButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(profileButton);
		add(friendsButton);
		add(activityButton);
		add(deviceButton);
		add(trainingButton);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
	}
}
