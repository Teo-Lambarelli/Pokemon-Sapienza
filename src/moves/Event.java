package moves;

public class Event {
	private int turns_remaining;
	public EventType type;
	
	public Event(EventType type, int turns) {
		turns_remaining = turns;
		this.type = type;
	}
	
	public int getTurns() {
		return turns_remaining;
	}
	
	public void setTurns(int turns) {
		turns_remaining = turns;
	}
	
	public int pass() {
		return --turns_remaining;
	}
	
	public boolean is(EventType type) {
		return (this.type == type);
	}
}
