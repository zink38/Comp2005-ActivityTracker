import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private TextPanel textPanel;
	//private JButton btn;
	private Toolbar toolbar;
	private FormPanel formPanel;
	
	public MainFrame() {
		super("Activity Tracker");
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		//btn = new JButton("Click Me!");
		
		
		/*btn.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPanel.appendText("Hello\n");
			}
		});*/
		
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		//add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}