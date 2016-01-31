package AccessPackage;

public class AccessEvent {
	public final Boolean accessGranted;
	public final Object source;
	 
	AccessEvent(Object source, Boolean accessGranted) {
		this.source = source;
		this.accessGranted = accessGranted;
	}
}