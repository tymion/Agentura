import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JComponent;

import AccessPackage.*;
import PanePackage.*;
import PaneControl.*;

import java.util.List;

import com.itextpdf.text.DocumentException;

public class MainFrame extends JFrame implements ActionListener, AccessListener {

	private static final long serialVersionUID = -4693088276764431778L;

	JComponent currentPane;

	MainFrame(String name)	{
		AccessNotifier access = new AccessNotifier();
		ControlNotifier control = new ControlNotifier();
		ControlPane controlPane = new ControlPane(control);
		List<ValidatePane> panesStack = new ArrayList<>();
		LoginPane login = new LoginPane();
		panesStack.add(login);
		ClientPane clientPane = new ClientPane();
		panesStack.add(clientPane);
		PaneStack paneStack = new PaneStack(panesStack, control);
		access.addAccessListener(this);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
        topPanel.add(paneStack);
        JPanel buttomPanel = new JPanel();
        buttomPanel.setLayout(new BoxLayout(buttomPanel, BoxLayout.Y_AXIS));
        buttomPanel.add(controlPane);
        panel.add(topPanel);
        panel.add(buttomPanel);
        setContentPane(panel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PDFOverwriter pdf = new PDFOverwriter();
		try {
			pdf.writeText();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void accessChanged(AccessEvent event) {
		if (event.source != this.currentPane) {
			return;
		}
		System.out.println("accessChanged");
	}
}
