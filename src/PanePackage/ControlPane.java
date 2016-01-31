package PanePackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import PaneControl.ControlNotifier;
import PaneControl.ControlEventType;

public class ControlPane extends JPanel implements ActionListener {

	private static final long serialVersionUID = -8367081876127498611L;
    
	static JButton forwardButton;
	static JButton backButton;
	static JButton closeButton;
	static String forwardButtonText = "Next";
	static String backButtonText = "Back";
    static String closeButtonText = "Close";
    ControlNotifier notifier;
    
	public ControlPane(ControlNotifier notifier) {
		this.notifier = notifier;
		/* Create needed buttons */
		forwardButton = new JButton(forwardButtonText);
		backButton = new JButton(backButtonText);
		closeButton = new JButton(closeButtonText);
		/* Added as listener */
		forwardButton.addActionListener(this);
		backButton.addActionListener(this);
		closeButton.addActionListener(this);
		/* Add buttons to panel */
		add(forwardButton);
		add(backButton);
		add(closeButton);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
    	Object source = event.getSource();
    	if (source == forwardButton) {
    		this.notifier.setControlEvent(this, ControlEventType.ControlEventType_Forward);
    	} else if (source == backButton) {
    		this.notifier.setControlEvent(this, ControlEventType.ControlEventType_Back);
    	} else if (source == closeButton) {
    		this.notifier.setControlEvent(this, ControlEventType.ControlEventType_Close);
    	}
	}
}
