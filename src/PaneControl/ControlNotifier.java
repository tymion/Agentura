package PaneControl;
import java.util.Set;
import java.util.HashSet;

import PaneControl.ControlEventType;

public class ControlNotifier {
	private final Set<ControlListener> listeners = new HashSet<>();

	public void addControlEventListener(ControlListener listener) {
		listeners.add(listener);
	}

	public void removeControlEventListener(ControlListener listener) {
		listeners.remove(listener);
	}

	public void setControlEvent(Object source, ControlEventType type) {
		broadcast(new ControlEvent(source, type));
	}

	private void broadcast(ControlEvent controlEvent ) {
		for (ControlListener listener : listeners ) {
			listener.controlEventPerform(controlEvent);
		}
	}
}