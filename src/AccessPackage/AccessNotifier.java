package AccessPackage;
import java.util.Set;
import java.util.HashSet;

public class AccessNotifier {
	private final Set<AccessListener> listeners = new HashSet<>();
	private Boolean accessGranted;
	
	public void addAccessListener(AccessListener listener) {
		listeners.add( listener );
	}

	public void removeAccessListener(AccessListener listener) {
		listeners.remove( listener );
	}

	public void setAccessGranted(Object source, Boolean accessGranted) {
		if (this.accessGranted != accessGranted) {
			this.accessGranted = accessGranted;
			broadcast(new AccessEvent(source, accessGranted));
		}
	}

	private void broadcast(AccessEvent accessEvent ) {
		for (AccessListener listener : listeners ) {
			listener.accessChanged(accessEvent);
		}
	}
}