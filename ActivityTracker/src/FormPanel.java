import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JButton editBtn;
	private JButton sortBtn;
	private JButton logBtn;
	
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		editBtn = new JButton("EDIT DATA");
		sortBtn = new JButton("SORT DATA");
		logBtn = new JButton("LOGOUT");
		
		Border innerBorder = BorderFactory.createTitledBorder("OPTIONS");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;

		gc.fill = GridBagConstraints.NONE;

		add(editBtn, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(sortBtn, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;

		add(logBtn, gc);
		
		
	}

}