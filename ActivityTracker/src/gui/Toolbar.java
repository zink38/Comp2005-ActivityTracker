package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	private JButton sortDataBtn;
	private JButton editDataBtn;
	private JButton doneBtn;
	private ButtonListener buttonListener;
	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		sortDataBtn = new JButton("Sort Data");
		editDataBtn = new JButton("Edit Data");
		doneBtn = new JButton("Done");
		
		sortDataBtn.addActionListener(this);
		editDataBtn.addActionListener(this);
		doneBtn.addActionListener(this);
		
		doneBtn.setVisible(false);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(sortDataBtn);
		add(editDataBtn);
		add(doneBtn);
		
	}
	public void isEdit(boolean bol) {
		doneBtn.setVisible(bol);
	}
	public void setButtonListener(ButtonListener listener) {
		this.buttonListener = listener;
	}
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if(clicked == sortDataBtn) {
			if(buttonListener != null) {
				buttonListener.sortEmitted();
			}
		}
		else if(clicked == editDataBtn) {
			if(buttonListener != null) {
				buttonListener.editEmitted();
			}
		}
		else {
			buttonListener.doneEmitted();
		}
	}
}
