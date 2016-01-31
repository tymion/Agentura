package PaneControl;

public class ControlEvent {
	public final Object source;
	public ControlEventType type = ControlEventType.ControlEventType_Invalid;

	ControlEvent(Object source, ControlEventType type) {
		this.source = source;
		this.type = type;
	}
}