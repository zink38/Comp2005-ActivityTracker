import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	private JTextArea textArea;
	public TextPanel() {
		textArea = new JTextArea();
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		appendText("DATA DISPLAYED HERE");
	}
	public void appendText(String text) {
		textArea.append(text);
	}
}
