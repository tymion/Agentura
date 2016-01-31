package PanePackage;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JPanel;
import java.awt.Component;
import PaneControl.*;

public class PaneStack  extends JPanel implements ControlListener {
	private final List<ValidatePane> panesStack;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8351859444697321187L;
	
	ControlNotifier notifier = null;
	ValidatePane currentPane = null;
	int currentPaneIdx = -1;
	CardLayout layout;
	
	public PaneStack(List<ValidatePane> panesStack, ControlNotifier notifier) {
		super(new CardLayout());
		this.notifier = notifier;
		this.notifier.addControlEventListener(this);
		this.panesStack = panesStack;
		int i = 0;
		for (ValidatePane panel : panesStack){
			add((Component) panel, (new Integer(i)).toString());
			i++;
		}
		this.layout = (CardLayout)(this.getLayout());
		pushPane();
	}
	
	private void pushPane() {
		System.out.println("something" + this.currentPaneIdx);
		if (this.panesStack.size() <= this.currentPaneIdx + 1) {
			System.out.println("something is fucked up");
			return;
		}
		this.currentPaneIdx++;
//		this.currentPane = this.panesStack.get(this.currentPaneIdx);
//		add((JPanel)this.currentPane);
		this.layout.show(this, (new Integer(this.currentPaneIdx)).toString());
	}
	
	private void popPane() {
		if (this.currentPaneIdx == 0) {
			System.out.println("something is fucked up");
			return;
		}
		this.currentPaneIdx--;
		this.currentPane = this.panesStack.get(this.currentPaneIdx);
		add((JPanel)this.currentPane);
	}

	private ValidatePane getCurrentCard()
	{
		ValidatePane card = null;

	    for (Component comp : this.getComponents() ) {
	        if (comp.isVisible() == true) {
	            card = (ValidatePane) comp;
	        }
	    }

	    return card;
	}
	
	public void controlEventPerform(ControlEvent event) {
    	switch (event.type) {
    	case ControlEventType_Back:
    		popPane();
   			break;
   		case ControlEventType_Close:
   			break;
   		case ControlEventType_Forward:
   			ValidatePane card = getCurrentCard();
   			if (card != null && card.validatePaneData() == true) {
   	   			System.out.println("Twst2");
   				pushPane();
   			}
   			break;
    	case ControlEventType_Invalid:
    	default:
   			return;
   		}
	}
}