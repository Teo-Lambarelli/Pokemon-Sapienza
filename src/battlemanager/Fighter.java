package battlemanager; import pokemon.*; import moves.*; import java.util.ArrayList;

public class Fighter {
	public Pokemon pokemon;
	public Team team;
	public Choice choice;
	public StatsChange statsChange;
	public Fighter opponent;
	
	public ArrayList<Event> event;
	
	public Fighter(Pokemon pokemon, Team team) {
		this.pokemon = pokemon;
		this.team = team;
		this.choice = null;
		this.statsChange = new StatsChange();
	}
	
	public boolean has(EventType type) {
		for (Event e : event)
			if (e.is(type))
				return true;
		return false;
	}
	
	public void turnPass() {
		for (int i = event.size() - 1; i >= 0; i--) {
	        if (event.get(i).pass() <= 0) {
	            event.remove(i);
	        }
	    }
	}
}
