package PanePackage;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.lang.Boolean;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import AccessPackage.*;
import PaneControl.*;

public class LoginPane extends JPanel implements ValidatePane {
	private static final long serialVersionUID = -8629196372752456960L;
	static JTextField agentNameTextField = new JTextField(30);
    static String dialogText = "Podaj proszę imię i nazwisko agenta:";

	public LoginPane() {
		JLabel label = new JLabel(dialogText);
		add(label);
		add(agentNameTextField);
		addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent ce) {
            	agentNameTextField.requestFocusInWindow();
            }
        });
	}

	public Boolean validatePaneData() {
		String text = agentNameTextField.getText();
		if (text == null) {
			return false;
		}
        CharSequence space = " ";
		if (text.contains(space)) {
			return true;
		}
		return false;
	}
	
}